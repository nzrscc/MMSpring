<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
    <c:choose>
        <c:when test="${not empty registrazioneTrue}">
        Registrazione effettuata correttamente!!!
        <br><br>
        </c:when>
    </c:choose>
    <c:choose>
        <c:when test="${not empty logInRiprova}">
            Username o password sbagliata!
            <br><br>
        </c:when>
    </c:choose>
Autenticazione:
<br><br>
<form:form action="/logIn" method="post">
    <label for="username">Username</label>
    <input id_try="username" type="text" name="username" required="true">
    <br><br>
    <label for="password">Password </label>
    <input id_try="password" type="password" name="password" required="true">
    <br><br>
    <button type="submit" id_try= "accedi" name="accedi" value="accedi">Accedi</button>
    <br>
    <br>
</form:form>
<form action="/registrati" method="post">
    <button type="submit" id_try= "registrati" name="registrati" value="registrati">Registrati</button>
</form>
</body>