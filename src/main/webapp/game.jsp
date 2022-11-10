<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="sessionState" scope="session" type="ru.javarush.module3.quest.lykova.SessionState"/>
<html>
<head>
    <title>Title</title>
    <link href="static/css/main.css" rel="stylesheet">
</head>
<body>
<p><c:out value="${sessionScope.sessionState.name}" /></p>
<p><c:out value="${sessionScope.sessionState.startSession}" /></p>
<p><c:out value="${sessionScope.sessionState.ipAddress}" /></p>
<p><c:out value="${sessionScope.sessionState.gamesCount}" /></p>
<p><c:out value="${sessionScope.sessionState.currentGameNode.question}" /></p>

<c:forEach var="answer" items="${sessionState.currentGameNode.answerToNodeMap.keySet()}">
    <p><button onclick="location='game?answerId=${answer.id}'"><c:out value="${answer.text}"/></button></p>
</c:forEach>

<c:if test="${sessionState.currentGameNode.win}">
    <img id="win-img" src="static/img/firework.gif">
</c:if>

<c:if test="${sessionState.currentGameNode.finalNode}">
    <p><button id="resetGame" onclick="location='game?newGame'">Начать новую игру</button></p>
</c:if>

</body>
</html>
