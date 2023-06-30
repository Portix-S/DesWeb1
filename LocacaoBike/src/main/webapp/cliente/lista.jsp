<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Locação Virtual</title>
</head>
<body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<div align="center">
		<h1>Gerenciamento de Clientes</h1>
		<h2>
			<a href="/<%=contextPath%>">Menu Principal</a> &nbsp;&nbsp;&nbsp; <a
				href="/<%=contextPath%>/clientes/cadastro">Adicione Novo Cliente</a>
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption>Lista de Clientes</caption>
			<tr>
				<th>CPF</th>
				<th>Sexo</th>
				<th>Email</th>
				<th>Nome</th>
                <th>Telefone</th>
                <th>Data de Nascimento</th>
			</tr>
			<c:forEach var="cliente" items="${requestScope.listaClientes}">
				<tr>
					<td>${cliente.CPF}</td>
					<td>${cliente.sexo}</td>
					<td>${cliente.email}</td>
					<td>${cliente.nome}</td>
                    <td>${cliente.telefone}</td>
					<td>${cliente.datanascimento}</td>
					<td><a href="/<%= contextPath%>/clientes/edicao?CPF=${cliente.CPF}">Edição</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/<%= contextPath%>/clientes/remocao?CPF=${cliente.CPF}"
						onclick="return confirm('Tem certeza de que deseja excluir este item?');">
							Remoção </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>