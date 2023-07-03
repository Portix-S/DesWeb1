<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<style>
    .centered-link {
        text-align: center;
        font-size: 25px;
    }
</style>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Locacao Virtual</title>
    </head>
    <body>
        <%
        String contextPath = request.getContextPath().replace("/", "");
        %>
    <h1 style="text-align:center;">Bem-vindo ao sistema de locação virtual de bicicletas!</h1>
    <h3 style="text-align:center;">Listagem de todas as locadoras disponíveis para aluguel de bicicletas: </h3>
    <div class="centered-link">
    	<a href="/<%=contextPath%>/locadoras/lista">Listar Locadoras</a>
    </div>
	<h3 style="text-align:center;">Realize login para acessar mais opções:</h3>
	<div class="centered-link">
    	<a href="login.jsp">Login</a>
    </div>
    </body>
</html>