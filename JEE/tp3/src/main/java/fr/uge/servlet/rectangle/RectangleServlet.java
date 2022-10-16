package fr.uge.servlet.rectangle;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@WebServlet("/rectangle")
public class RectangleServlet extends HttpServlet {

    private String body;

    @Override
    public void init() throws ServletException {
        var inputStream = getServletContext().getResourceAsStream("/WEB-INF/templates/rectangle-form.html");
        try {
            body = readFromInputStream(inputStream);
            inputStream.reset();
        } catch (IOException e) {
            throw new ServletException(e);
        }
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println(body);
        var name = req.getAttribute("error_number_format");
        if (name != null) {
            writer.println(name);
        }
        writer.flush();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            var height = Integer.parseInt(req.getParameter("height"));
            var width = Integer.parseInt(req.getParameter("width"));
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.println("area of the rectangle is " + height*width);
            writer.flush();
        } catch (NumberFormatException e) {
            req.setAttribute("error_number_format", "Entrez un numéro valide");
            doGet(req, resp);
        }

    }

    private String readFromInputStream(InputStream inputStream) throws IOException {
        var lines = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines();
        return lines.collect(Collectors.joining("\n"));
    }
}
