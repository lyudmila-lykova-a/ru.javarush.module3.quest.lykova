<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.javarush.module3.quest.lykova.RequestParamType" %>
<html>
<head>
    <title>Главная</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/main.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Prata" rel="stylesheet">
</head>
<body>
<div id="all-page" class="container w-50">
    <h1 id="title" class="text-center"><b><i>Space Quest</i></b></h1>

    <h4><b>Пролог</b></h4>
    <p>Ты стоишь в космическом порту и готов подняться на борт своего корабля. Разве ты не об этом мечтал?
        Стать капитаном галактического судна с экипажем, который будет совершать подвиги под твоим командованием.
        Так что вперед!</p>

    <h4><b>Знакомство с экипажем</b></h4>
    <p>Когда ты поднялся на борт корабля, тебя поприветствоваля девушка с черной палкой в руках:
        - Здравствуйте, командир! Я Мишель - ваша помощница. Видите, там в углу пьет кофе наш штурман - сержант
        Перегарный Шлейф,
        под штурвалом спит наш бортмеханик - Зелёный, а фотографирует его Сергей Стальная Хватка - наш навигатор.
        А как обращаться к вам?</p>

    <form id="input-name-form" method="get" action="game" class="d-flex justify-content-center align-items-center">
        <input type="text" name="<%=RequestParamType.NEW_GAME.getParamName()%>" hidden>
        <label for="name">Введите имя:</label><br>
        <input id="name" type="text" name="<%=RequestParamType.USERNAME.getParamName()%>" required>
        <input type="submit" value="Начать игру" class="btn btn-primary">
    </form>

    <c:if test="${blankUsername}">
        <label id="input-error">Ошибка! Имя пользователя не было указано.</label>
    </c:if>
</div>
</body>
</html>
