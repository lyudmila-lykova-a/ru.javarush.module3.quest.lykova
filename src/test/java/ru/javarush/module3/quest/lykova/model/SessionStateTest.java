package ru.javarush.module3.quest.lykova.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Map;

public class SessionStateTest {

    @Test
    public void getStartSession() {
        LocalDateTime beforeSessionStateCreation = LocalDateTime.now().minus(1, ChronoUnit.MILLIS);
        SessionState sessionState = new SessionState();
        Assertions.assertTrue(beforeSessionStateCreation.isBefore(sessionState.getStartSession()));
    }

    @Test
    public void getName() {
        SessionState sessionState = new SessionState();
        sessionState.setName("name");
        Assertions.assertEquals("name", sessionState.getName());
    }

    @Test
    public void getIpAddress() {
        SessionState sessionState = new SessionState();
        sessionState.setIpAddress("123");
        Assertions.assertEquals("123", sessionState.getIpAddress());
    }

    @Test
    public void getCurrentGameNode() {
        SessionState sessionState = new SessionState();
        Map<Answer, Node> notEmptyMap = Map.of(new Answer(1, ""), new Node("question2", Collections.emptyMap(), true));
        Node node = new Node("question1", notEmptyMap, false);
        sessionState.setCurrentGameNode(node);
        Assertions.assertEquals(node, sessionState.getCurrentGameNode());
    }

    @Test
    public void getGamesCount() {
        SessionState sessionState = new SessionState();
        sessionState.setGamesCount(2);
        Assertions.assertEquals(2, sessionState.getGamesCount());
    }

    @Test
    public void getStartSessionFormatted() {
        SessionState sessionState = new SessionState();
        String regex = "[0-9]{2}[.][0-9]{2}[.][0-9]{4} [0-9]{2}:[0-9]{2}:[0-9]{2}";
        Assertions.assertTrue(sessionState.getStartSessionFormatted().matches(regex));
    }
}
