package ru.javarush.module3.quest.lykova.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

class NodeTest {

    @Test
    public void isFinalNode_emptyMap() {
        Node node = new Node("question", Collections.emptyMap(), false);
        Assertions.assertTrue(node.isFinalNode());
    }

    @Test
    public void isFinalNode_notEmptyMap() {
        Map<Answer, Node> notEmptyMap = Map.of(new Answer(1, ""), new Node("question2", Collections.emptyMap(), true));
        Node node = new Node("question1", notEmptyMap, false);
        Assertions.assertFalse(node.isFinalNode());
    }

    @Test
    public void getQuestion() {
        Node node = new Node("question", Collections.emptyMap(), false);
        Assertions.assertEquals("question", node.getQuestion());
    }

    @Test
    public void getWin() {
        Node node = new Node("question", Collections.emptyMap(), true);
        Assertions.assertTrue(node.isWin());
    }

    @Test
    public void getAnswerToNodeMap() {
        Map<Answer, Node> notEmptyMap = Map.of(new Answer(1, ""), new Node("question2", Collections.emptyMap(), true));
        Node node = new Node("question1", notEmptyMap, false);
        Assertions.assertEquals(notEmptyMap, node.getAnswerToNodeMap());
    }

}