package ru.javarush.module3.quest.lykova.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnswerTest {

    @Test
    public void getId() {
        Answer answer = new Answer(1, "text");
        Assertions.assertEquals(1, answer.getId());
    }

    @Test
    public void getText() {
        Answer answer = new Answer(1, "text");
        Assertions.assertEquals("text", answer.getText());
    }

}
