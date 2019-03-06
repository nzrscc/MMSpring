<%@ page import="it.mastermind.mmspring.models.TryModel" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <p>
        La soluzione era: ${soluzione}
    </p>
</head>
<body>
    <% List<TryModel> list = (List<TryModel>) request.getSession().getAttribute("classificaTry"); %>
<br><br>
<% int i;%>
<table>
    <table border=?1?>
        <tr>
            <td>Numero tentativo</td>
            <td>Numeri inseriti</td>
            <td>Numeri giusti in posizione esatta</td>
            <td>Numeri giusti in posizione errata</td>
        </tr>
        <% for (i = 0; i < list.size(); i++) { %>
        <tr>
            <td><%out.println(list.get(i).getN_tentativi()); %></td>
            <td><%out.println(list.get(i).getValori_inseriti()); %></td>
            <td><%out.println(list.get(i).getPos_esatta()); %></td>
            <td><%out.println(list.get(i).getNum_esatto()); %></td>
        </tr>
        <% } %>
    </table>

</table>
    <br><br>
    <form action="/" method="post">
        <button type="submit" id= "rinizia" name="rinizia" value="rinizia">Inizia una nuova partita</button>
    </form>
</body>
</html>
