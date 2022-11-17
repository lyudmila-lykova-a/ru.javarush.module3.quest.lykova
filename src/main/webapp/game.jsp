<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.javarush.module3.quest.lykova.model.RequestParamType" %>
<jsp:useBean id="sessionState" scope="session" type="ru.javarush.module3.quest.lykova.model.SessionState"/>
<html>
<head>
    <title>Игра</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/main.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Prata" rel="stylesheet">
</head>
<body>
<div id="all-page" class="container w-50 position-relative">
    <h1 id="title" class="text-center"><b><i>Space Quest</i></b></h1>
    <p><c:out value="${sessionScope.sessionState.currentGameNode.question}"/></p>

    <c:forEach var="answer" items="${sessionState.currentGameNode.answerToNodeMap.keySet()}">
        <p>
            <button class="btn btn-secondary" onclick="location='game?<%=RequestParamType.ANSWER_ID.getParamName()%>=${answer.id}'"><c:out
                    value="${answer.text}"/></button>
        </p>
    </c:forEach>

    <c:if test="${sessionState.currentGameNode.win}">
        <p><img id="win-img" src="static/img/firework.gif"></p>
    </c:if>

    <c:if test="${sessionState.currentGameNode.finalNode}">
        <p>
            <button id="resetGame" class="btn btn-primary" onclick="location='game?<%=RequestParamType.NEW_GAME.getParamName()%>'">Начать новую
                игру
            </button>
        </p>
    </c:if>

    <div id="statistics" class="card text-center position-absolute bottom-0 start-50 translate-middle-x">
        <div class="card-header">
            Статистика
        </div>
        <div class="card-body">
            <b>Имя:</b> <c:out value="${sessionScope.sessionState.name}"/><br>
            <b>IP адрес:</b> <c:out value="${sessionScope.sessionState.ipAddress}"/><br>
            <b>Количество игр:</b> <c:out value="${sessionScope.sessionState.gamesCount}"/>
        </div>
        <div class="card-footer text-muted">
            Начало игровой сессии: ${sessionScope.sessionState.getStartSessionFormatted()}
        </div>
    </div>
</div>
</body>
</html>
