package ru.javarush.module3.quest.lykova;

import lombok.Data;

import java.util.Map;

@Data
public class Node {

    private final String question;
    private final Map<Answer, Node> answerToNodeMap;
    private final boolean win;

    public boolean isFinalNode() {
        return answerToNodeMap.isEmpty();
    }

}
