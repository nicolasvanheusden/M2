package fr.uge.servlet.hellosession;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet("/hellosessionbetter")
public class HelloSessionBetter extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession(true);
        var oldUuid = session.getAttribute("id");
        var uid = UUID.randomUUID();
        var score = 1;
        if (oldUuid == null) {
            session.setAttribute("score", score);
        } else {
            score = (int) session.getAttribute("score");
            session.setAttribute("score", ++score);
        }
        session.setAttribute("id", uid);
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html><html><h1>Bonjour pour la " + score + "ième fois</h1></html>");
        writer.flush();
    }
}
