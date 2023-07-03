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
		<h1>Gerenciamento de Locadoras</h1>
		<h2>
			<a href="/<%=contextPath%>/logado/admin/index.jsp">Menu Principal</a> &nbsp;&nbsp;&nbsp; <a
				href="/<%=contextPath%>/locadoras/cadastro">Adicione Nova Locadora</a>
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption>Lista de Locadoras</caption>
			<tr>
				<th>CNPJ</th>
				<th>Cidade</th>
				<th>Email</th>
				<th>Nome</th>
				<th>Senha</th>
				<th>Papel</th>
			</tr>
			<c:forEach var="locadora" items="${requestScope.listaLocadoras}">
				<tr>
					<td>${locadora.getCNPJ()}</td>
					<td>${locadora.getCidade()}</td>
					<td>${locadora.getEmail()}</td>
					<td>${locadora.getNome()}</td>
					<td>${locadora.getSenha()}</td>
					<td>${locadora.getPapel()}</td>
					<td><a href="/<%= contextPath%>/locadoras/edicao?CNPJ=${locadora.CNPJ}">Edição</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/<%= contextPath%>/locadoras/remocao?CNPJ=${locadora.CNPJ}"
						onclick="return confirm('Tem certeza de que deseja excluir este item?');">
							Remoção </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>