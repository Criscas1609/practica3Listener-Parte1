<%--
  Created by IntelliJ IDEA.
  User: Cristhian
  Date: 18/04/2023
  Time: 3:10 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cerrar sesión</title>
</head>
<body>
<form method="get" action="${pageContext.request.contextPath}/LogoutServlet">
    <label>Confirme si quiere cerrar sesión</label>
    <button type="submit">Cerrar sesión</button>
</form>
</body>
</html>
