<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Menú</title>
    <style>
        body {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 100vh;
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
        margin: 0;
        padding: 0;
    }

    h1 {
        color: #1e88e5;
        font-size: 24px;
        margin: 0;
        padding: 0;
        margin-bottom: 20px;
    }

    a {
        color: #7c4caf;
        text-decoration: none;
        margin-right: 10px;
    }

    button[type="submit"] {
        background-color: #673ab7;
        color: white;
        border: none;
        padding: 10px;
        border-radius: 5px;
        cursor: pointer;
        margin-bottom: 10px;
        transition: all 0.2s ease-in-out;
    }

    button[type="submit"]:hover {
        background-color: #512da8;
    }

    .button-container {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        margin-top: 20px;
        padding: 20px;
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0px 5px 10px rgba(0,0,0,0.2);
    }

    </style>
</head>
<body>
<h1><%= "Menú" %></h1>
<div class="button-container">
    <form method="Get" action="${pageContext.request.contextPath}/NewServlet">
        <button type="submit">Probar Cabeceras HTTP Request</button>
    </form><br>
    <form method="Get" action="${pageContext.request.contextPath}/productos.html">
        <button type="submit">Mostrar los productos</button>
    </form><br>
    <form method="Get" action="${pageContext.request.contextPath}/HoraServlet">
        <button type="submit">Hora</button>
    </form><br>
    <a href="Login.jsp" >Login</a><br>
    <a href="Product.jsp" >Producto id</a><br>
    <a href="Filter.jsp" >Filtro</a><br>
    <br>
    <form method="GET" action="${pageContext.request.contextPath}/ListenerServlet">
        <button type="submit" class="btn btn-primary">Probar Listener</button>
    </form><br>
</div>
</body>
</html>
