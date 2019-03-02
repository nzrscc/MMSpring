<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Home</title>
    <h1>Benvenuto su Master Mind!</h1>
</head>
<body>
<form action="/scelta" method="get">
    <br>
    Cosa si vuole fare?
    <select name="scelta">
        <option name="MasterMind" value="MasterMind">Giocare a MasterMind</option>
        <option name="Classifica User" value="Classifica User">Classifica User</option>
        <option name="Classifica Tentativi" value="Classifica Tentativi">Classifica Tentativi</option>
    </select>
    <br><br>
    <button type="submit" name="invia">Invia</button>
</form>

</body>
</html>