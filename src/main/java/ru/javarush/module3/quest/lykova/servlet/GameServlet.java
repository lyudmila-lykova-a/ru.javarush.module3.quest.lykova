package ru.javarush.module3.quest.lykova.servlet;

import ru.javarush.module3.quest.lykova.service.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/game")
public class GameServlet extends HttpServlet {

    private final GameService gameService = new GameService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(true);
        gameService.process(session, req, (jspPath) -> {
            try {
                getServletContext().getRequestDispatcher(jspPath).forward(req, resp);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
