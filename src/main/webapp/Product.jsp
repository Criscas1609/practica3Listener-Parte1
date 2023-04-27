<%--
  Created by IntelliJ IDEA.
  User: Cristhian
  Date: 18/04/2023
  Time: 2:05 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html>
    <head>
        <title>Formulario básico</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
    <h1>Buscar Producto por Id</h1>
    <form action="${pageContext.request.contextPath}/ProductServlet" method="POST">
        <label >Id del producto a buscar: </label>
        <input type="text" name="id"><br>
        <button type="submit">Enviar</button>
    </form>
    </body>
    </html>
