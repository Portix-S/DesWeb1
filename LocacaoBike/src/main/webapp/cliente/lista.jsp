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
	<c:if test="${usuarioLogado.getPapel() == 'admin'}">

	<div align="center">
		<h1>Gerenciamento de Clientes</h1>
		<h2>
			<a href="/<%=contextPath%>/logado/admin/index.jsp">Menu Admin</a> &nbsp;&nbsp;&nbsp; <a
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
				<th>Senha</th>
                <th>Telefone</th>
                <th>Data de Nascimento</th>
                <th>Papel</th>
			</tr>
			<c:forEach var="cliente" items="${requestScope.listaClientes}">
				<tr>
					<td>${cliente.getCPF()}</td>
					<td>${cliente.getSexo()}</td>
					<td>${cliente.getEmail()}</td>
					<td>${cliente.getNome()}</td>
					<td>${cliente.getSenha()}</td>
                    <td>${cliente.getTelefone()}</td>
					<td>${cliente.getDataNascimento()}</td>
					<td>${cliente.getPapel()}</td>
					<td><a href="/<%= contextPath%>/clientes/edicao?CPF=${cliente.getCPF()}">Edição</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/<%= contextPath%>/clientes/remocao?CPF=${cliente.getCPF()}"
						onclick="return confirm('Tem certeza de que deseja excluir este item?');">
							Remoção </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</c:if>
	<c:if test="${usuarioLogado.getPapel() != 'admin'}">
		<h1>Você não tem acesso à essa pagina</h1>
			<a href="/<%=contextPath%>/pagInicial.jsp">Menu Principal</a>
	</c:if>
</body>
</html>