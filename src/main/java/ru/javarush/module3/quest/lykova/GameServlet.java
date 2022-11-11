package ru.javarush.module3.quest.lykova;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(value = "/game")
public class GameServlet extends HttpServlet {

    private static final String SESSION_STATE_ATTRIBUTE_NAME = "sessionState";
    private static final String BLANK_USERNAME_ATTRIBUTE_NAME = "blankUsername";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionState sessionState = takeSessionState(req);
        String name = req.getParameter(RequestParamType.USERNAME.getParamName());
        if (name != null) {
           sessionState.setName(name);
        }
        if (sessionState.getName() == null || sessionState.getName().isBlank()) {
            req.setAttribute(BLANK_USERNAME_ATTRIBUTE_NAME, true);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }
        startNewGame(req, sessionState);
        processAnswer(req, sessionState);
        getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
    }

    private void processAnswer(HttpServletRequest req, SessionState sessionState) {
        String answerId = req.getParameter(RequestParamType.ANSWER_ID.getParamName());
        if (answerId != null) {
            for (Map.Entry<Answer, Node> entry : sessionState.getCurrentGameNode().getAnswerToNodeMap().entrySet()) {
                if (String.valueOf(entry.getKey().getId()).equals(answerId)) {
                    sessionState.setCurrentGameNode(entry.getValue());
                }
            }
            // TODO: 10.11.2022 throw exception if node is not found
        }
    }

    private void startNewGame(HttpServletRequest req, SessionState sessionState) {
        if (req.getParameter(RequestParamType.NEW_GAME.getParamName()) != null || sessionState.getCurrentGameNode() == null) {
            sessionState.setCurrentGameNode(Quest.init());
            sessionState.setGamesCount(sessionState.getGamesCount() + 1);
        }
    }

    private SessionState takeSessionState(HttpServletRequest req) {
        HttpSession session = req.getSession(true);
        Object sessionState = session.getAttribute(SESSION_STATE_ATTRIBUTE_NAME);
        if (sessionState == null) {
            sessionState = new SessionState();
            ((SessionState) sessionState).setIpAddress(req.getRemoteAddr());
            session.setAttribute(SESSION_STATE_ATTRIBUTE_NAME, sessionState);
        }
        return (SessionState) sessionState;
    }
}
