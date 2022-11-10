package ru.javarush.module3.quest.lykova;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Quest {

    public static Node init() {
        Map<Answer, Node> answerToNodeMap1 = new LinkedHashMap<>();
        answerToNodeMap1.put(
                new Answer(1, "Рассказать правду о себе."),
                new Node("Тебя вернули домой. Победа!", Collections.emptyMap(), true));
        answerToNodeMap1.put(
                new Answer(2, "Солгать о себе."),
                new Node("Твою ложь разоблачили. Поражение.", Collections.emptyMap(), false));
        Node node9 = new Node("Ты поднялся на мостик. Ты кто?", answerToNodeMap1, false);

        Map<Answer, Node> answerToNodeMap2 = new LinkedHashMap<>();
        answerToNodeMap2.put(new Answer(1, "Поднятся на мостик"), node9);
        answerToNodeMap2.put(
                new Answer(2, "Отказаться подниматься на мостик."),
                new Node("Ты не пошел на переговоры. Поражение.", Collections.emptyMap(), false));
        Node node11 = new Node("Ты принял вызов. Поднимешься на мостик к капитану?", answerToNodeMap2, false);

        Map<Answer, Node> answerToNodeMap3 = new LinkedHashMap<>();
        answerToNodeMap3.put(new Answer(1, "Принять вызов."), node11);
        answerToNodeMap3.put(
                new Answer(2, "Отклонить вызов."),
                new Node("Ты отклонил вызов. Поражение.", Collections.emptyMap(), false));
        return new Node("Ты потерял память. Принять вызов НЛО?", answerToNodeMap3, false);
    }

}

