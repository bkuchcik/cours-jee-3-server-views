<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1" %>
<%@page import="java.time.LocalDateTime" %>
<%@page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<%
    final DateTimeFormatter formatteur = DateTimeFormatter.ofPattern("HH:mm:ss 'le' dd/MM/yyyy");
    final String currentDateAsString = formatteur.format(LocalDateTime.now());
%>
<p>
    Au moment de la génération de cette page, il est
    <%=currentDateAsString%>
</p>
</body>
</html>