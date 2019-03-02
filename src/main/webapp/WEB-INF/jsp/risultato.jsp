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
    <%List<TryModel> list = (List<TryModel>) request.getSession().getAttribute("classificaTry");%>
<br><br>
<% int i = 0;%>
<table> <!? Inizia la tabella ?>
    <table border=?1?>
        <tr> <!? Inizia la prima riga ?>
            <td>Numero tentativo</td>
            <!? Prima colonna ?>
            <td>Numeri inseriti</td>
            <!? Seconda colonna ?>
            <td>Numeri giusti in posizione esatta</td>
            <!? Terza colonna ?>
            <td>Numeri giusti in posizione errata</td>
            <!? Quarta colonna ?>
        </tr>
        <!? Fine della prima riga ?>
        <%
            for (i = 0; i < list.size(); i++) {
        %>
        <tr>
            <td><%out.println(list.get(i).getN_tentativi()); %></td>
            <td><%out.println(list.get(i).getValori_inseriti()); %></td>
            <td><%out.println(list.get(i).getPos_esatta()); %></td>
            <td><%out.println(list.get(i).getNum_esatto()); %></td>
        </tr>
        <% } %>
    </table>
    <!? Fine della tabella ?>
</table>
    <br><br>
    <form action="/" method="post">
        <button type="submit" id= "rinizia" name="rinizia" value="rinizia">Inizia una nuova partita</button>
    </form>
</body>
</html>
