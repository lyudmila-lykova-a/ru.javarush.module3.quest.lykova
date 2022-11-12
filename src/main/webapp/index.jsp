<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.javarush.module3.quest.lykova.RequestParamType" %>
<html>
<head>
    <title>Главная</title>
</head>
<body>
<b>Пролог</b>
<p>Ты стоишь в космическом порту и готов подняться на борт своего корабля. Разве ты не об этом мечтал?
Стать капитаном галактического судна с экипажем, который будет совершать подвиги под твоим командованием.
    Так что вперед!</p>

<b>Знакомство с экипажем</b>
<p>Когда ты поднялся на борт корабля, тебя поприветствоваля девушка с черной палкой в руках:
- Здравствуйте, командир! Я Мишель - ваша помощница. Видите, там в углу пьет кофе наш штурман - сержант Перегарный Шлейф,
под штурвалом спит наш бортмеханик - Зелёный, а фотографирует его Сергей Стальная Хватка - наш навигатор.
    А как обращаться к вам?</p>

<form method="get" action="game">
    <label for="name">Введите имя:</label>
    <input id="name" type="text" name="<%=RequestParamType.USERNAME.getParamName()%>" required>
    <input type="text" name="<%=RequestParamType.NEW_GAME.getParamName()%>" hidden>
    <input type="submit" value="Начать игру">
</form>

<c:if test="${blankUsername}">
    <label>Ошибка! Имя пользователя не было указано.</label>
</c:if>
</body>
</html>
