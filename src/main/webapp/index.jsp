<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="game">
    <label for="name">Введите имя:</label>
    <input id="name" type="text" name="name" required>
    <input type="text" name="newGame" hidden>
    <input type="submit" value="Начать игру">
</form>

<c:if test="${blankUsername}">
    <label>Ошибка! Имя пользователя не было указано.</label>
</c:if>
</body>
</html>
