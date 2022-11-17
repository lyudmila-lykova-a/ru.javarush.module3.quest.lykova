package ru.javarush.module3.quest.lykova.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RequestParamTypeTest {

    @Test
    public void getParamName() {
        RequestParamType answerId = RequestParamType.ANSWER_ID;
        Assertions.assertEquals("answerId", answerId.getParamName());
    }

}
