package ru.javarush.module3.quest.lykova.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.javarush.module3.quest.lykova.service.GameService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GameServiceTest {

    @Test
    public void process_emptyName() {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpSession session = Mockito.mock(HttpSession.class);
        StringBuilder actualJspPath = new StringBuilder();
        new GameService().process(session, request, actualJspPath::append);

        Assertions.assertEquals("/index.jsp", actualJspPath.toString());
    }

    @Test
    public void process_notEmptyName() {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        Mockito.when(request.getParameter(RequestParamType.USERNAME.getParamName())).thenReturn("name");
        Mockito.when(request.getRemoteAddr()).thenReturn("localhost");
        HttpSession session = Mockito.mock(HttpSession.class);
        SessionState[] sessionState = new SessionState[1];
        Mockito.doAnswer(invocation -> sessionState[0] = invocation.getArgument(1)).when(session).setAttribute(Mockito.eq(GameService.SESSION_STATE_ATTRIBUTE_NAME), Mockito.any(SessionState.class));
        StringBuilder actualJspPath = new StringBuilder();
        new GameService().process(session, request, actualJspPath::append);

        Assertions.assertEquals("/game.jsp", actualJspPath.toString());
        Assertions.assertEquals("name", sessionState[0].getName());
        Assertions.assertNotNull(sessionState[0].getCurrentGameNode());
        Assertions.assertEquals("localhost", sessionState[0].getIpAddress());
        Assertions.assertEquals(1, sessionState[0].getGamesCount());
    }
}
