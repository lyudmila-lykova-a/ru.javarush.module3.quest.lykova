package ru.javarush.module3.quest.lykova;

public class Quest {

    public static Node init(){
        Node node1 = new Node("Ты отклонил вызов. Поражение.", Node.EMPTY, Node.EMPTY, true, false);
        Node node2 = new Node("Отклонить вызов.", node1, Node.EMPTY, false, false);
        Node node3 = new Node("Ты не пошел на переговоры. Поражение.", Node.EMPTY, Node.EMPTY, true, false);
        Node node4 = new Node("Отказаться подниматься на мостик.", node3, Node.EMPTY, false, false);
        Node node5 = new Node("Твою ложь разоблачили. Поражение.", Node.EMPTY, Node.EMPTY, true, false);
        Node node6 = new Node("Солгать о себе.", node5, Node.EMPTY, false, false);
        Node node7 = new Node("Тебя вернули домой. Победа!", Node.EMPTY, Node.EMPTY, true, true);
        Node node8 = new Node("Рассказать правду о себе.", node7, Node.EMPTY, false, false);
        Node node9 = new Node("Ты поднялся на мостик. Ты кто?", node8, node6, false, false);
        Node node10 = new Node("Поднятся на мостик", node9, Node.EMPTY, false, false);
        Node node11 = new Node("Ты принял вызов. Поднимешься на мостик к капитану?", node10, node4, false, false);
        Node node12 = new Node("Принять вызов.", node11, Node.EMPTY, false, false);
        return new Node("Ты потерял память. Принять вызов НЛО?", node12, node2, false, false);
    }

}

