package fr.uge.servlet.hellosession;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet("/hellosession")
public class HelloSession extends HttpServlet {

    private UserManager manager;
    @Override
    public void init() throws ServletException {
        manager = new UserManager();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var cookies = req.getCookies();
        var auth = false;
        UUID uuid = UUID.randomUUID();
        if (cookies != null ){
            for (var cookie: cookies) {
                if (cookie.getName().equals("session")) {
                    auth = true;
                    manager.updateValue(cookie.getValue(), uuid.toString());
                    break;
                }
            }
        }
        if (!auth) {
            manager.addUser(uuid.toString());
        }
        resp.addCookie(new Cookie("session", uuid.toString()));
        var score = manager.getScore(uuid.toString());
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html><html><h1>Bonjour pour la " + score + "ième fois</h1></html>");
        writer.flush();
    }
}
