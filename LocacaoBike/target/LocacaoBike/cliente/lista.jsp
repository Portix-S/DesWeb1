<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="messages" var="bundle" />
<html>
<head>
<title><fmt:message key="greeting25" bundle="${bundle}"/></title>
</head>
<body>
	
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<c:if test="${usuarioLogado.getPapel() == 'admin'}">

	<div align="center">
		<h1><fmt:message key="greeting33" bundle="${bundle}"/></h1>
		<h2>
			<a href="/<%=contextPath%>/logado/admin/index.jsp"><fmt:message key="greeting26" bundle="${bundle}"/></a> &nbsp;&nbsp;&nbsp; <a
				href="/<%=contextPath%>/clientes/cadastro"><fmt:message key="greeting36" bundle="${bundle}"/></a>
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption><fmt:message key="greeting32" bundle="${bundle}"/></caption>
			<tr>
				<th>CPF</th>
				<th>Sexo/Gender</th>
				<th>Email</th>
				<th>Nome/Name</th>
				<th>Senha/Password</th>
                <th>Telefone/Number</th>
                <th>Data de Nascimento/Date of Birth</th>
                <th>Papel/Role</th>
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
					<td><a href="/<%= contextPath%>/clientes/edicao?CPF=${cliente.getCPF()}"><fmt:message key="greeting29" bundle="${bundle}"/></a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/<%= contextPath%>/clientes/remocao?CPF=${cliente.getCPF()}"
						onclick="return confirm('Tem certeza de que deseja excluir este item?');">
						<fmt:message key="greeting37" bundle="${bundle}"/></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</c:if>
	<c:if test="${usuarioLogado.getPapel() != 'admin'}">
		<h1><fmt:message key="greeting11" bundle="${bundle}"/></h1>
			<a href="/<%=contextPath%>/pagInicial.jsp"><fmt:message key="greeting12" bundle="${bundle}"/></a>
	</c:if>
</body>
</html>