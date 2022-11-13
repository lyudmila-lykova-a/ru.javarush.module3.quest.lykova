package ru.javarush.module3.quest.lykova.service;

import ru.javarush.module3.quest.lykova.model.Answer;
import ru.javarush.module3.quest.lykova.model.Node;
import ru.javarush.module3.quest.lykova.model.RequestParamType;
import ru.javarush.module3.quest.lykova.model.SessionState;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.function.Consumer;

public class GameService {

    public static final String SESSION_STATE_ATTRIBUTE_NAME = "sessionState";
    private static final String BLANK_USERNAME_ATTRIBUTE_NAME = "blankUsername";

    public void process(HttpSession session, HttpServletRequest req, Consumer<String> forwardConsumer) {
        SessionState sessionState = takeSessionState(session, req);
        String name = req.getParameter(RequestParamType.USERNAME.getParamName());
        if (name != null) {
            sessionState.setName(name);
        }
        if (sessionState.getName() == null || sessionState.getName().isBlank()) {
            req.setAttribute(BLANK_USERNAME_ATTRIBUTE_NAME, true);
            forwardConsumer.accept("/index.jsp");
            return;
        }
        startNewGame(req, sessionState);
        processAnswer(req, sessionState);
        forwardConsumer.accept("/game.jsp");
    }

    private void processAnswer(HttpServletRequest req, SessionState sessionState) {
        String answerId = req.getParameter(RequestParamType.ANSWER_ID.getParamName());
        if (answerId != null) {
            for (Map.Entry<Answer, Node> entry : sessionState.getCurrentGameNode().getAnswerToNodeMap().entrySet()) {
                if (String.valueOf(entry.getKey().getId()).equals(answerId)) {
                    sessionState.setCurrentGameNode(entry.getValue());
                }
            }
        }
    }

    private void startNewGame(HttpServletRequest req, SessionState sessionState) {
        if (req.getParameter(RequestParamType.NEW_GAME.getParamName()) != null || sessionState.getCurrentGameNode() == null) {
            sessionState.setCurrentGameNode(Quest.init());
            sessionState.setGamesCount(sessionState.getGamesCount() + 1);
        }
    }

    private SessionState takeSessionState(HttpSession session, HttpServletRequest req) {
        Object sessionState = session.getAttribute(SESSION_STATE_ATTRIBUTE_NAME);
        if (sessionState == null) {
            sessionState = new SessionState();
            ((SessionState) sessionState).setIpAddress(req.getRemoteAddr());
            session.setAttribute(SESSION_STATE_ATTRIBUTE_NAME, sessionState);
        }
        return (SessionState) sessionState;
    }
}
