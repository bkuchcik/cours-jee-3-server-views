<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Une page affichant l'heure courante</title>
</head>
<body>
<p>
    Au moment de la g�n�ration de cette page, il est
    <%=request.getAttribute("currentDateAsString")%>
</p>
</body>
</html>