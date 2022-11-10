package ru.javarush.module3.quest.lykova;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Node {
    public static final Node EMPTY = new Node("", null, null, false, false);

    private final String text;
    private final Node yesNode;
    private final Node noNode;
    private final boolean finalNode;
    private final boolean win;

    public boolean hasNoNode() {
        return noNode != EMPTY && noNode != null;
    }

    public boolean hasYesNode() {
        return yesNode != EMPTY && yesNode != null;
    }

}
