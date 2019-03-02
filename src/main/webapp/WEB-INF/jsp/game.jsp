<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <h2>Ciao ${username}
    </h2>
    <br>
</head>
<body>
<form:form action="/controllo" method="post">
    <label for="numero1">Primo numero</label>&nbsp;&nbsp;&nbsp;&nbsp;
    <input id="numero1" type="number" name="numero1" min="0" max="9" step="1" required="true">
    <br>
    <label for="numero2">Secondo numero</label>
    <input id="numero2" type="number" name="numero2" min="0" max="9" step="1" required="true">
    <br>
    <label for="numero3">Terzo numero</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input id="numero3" type="number" name="numero3" min="0" max="9" step="1" required="true">
    <br>
    <br>
    <c:choose>
        <c:when test="${not empty currentResult}">
            <p>Numero giusto in posizione esatta ${posizioneEsatta}<br>
                Numero giusto in posizione errata ${numeroEsatto}<br>
                Numero tentativi rimasti : ${nTentativo}</p>
        </c:when>
        <c:otherwise>
            <p>Numero tentativi rimasti : ${nTentativo}</p>
        </c:otherwise>
    </c:choose>
    <button type="submit" name="invia">Invia</button>
</form:form>
</body>
</html>
