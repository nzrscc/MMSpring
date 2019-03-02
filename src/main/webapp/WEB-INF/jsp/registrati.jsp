<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
</head>
<body>
<c:choose>
    <c:when test="${not empty provaRegistrazione}">
        <p>Username già esistente!</p>
    </c:when>
</c:choose>
Registrati:
<br><br>
<form action="/registrazione" method="post">
    <label for="username">Username</label>
    <input id_try="username" type="text" name="username" required="true">
    <br><br>
    <label for="password">Password </label>
    <input id_try="password" type="password" name="password" required="true">
    <br><br>
    <button type="submit" id_try= "registrati" name="registrati" value="registrati">Registrati</button>
    <br>
    <br>
</form>
</body>