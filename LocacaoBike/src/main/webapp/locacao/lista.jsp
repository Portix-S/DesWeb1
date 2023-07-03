<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Locação Virtual</title>
</head>

<body>
	<c:if test="${mensagens.existeErros}">
	    <div id="erro">
	        <ul>
           		<c:forEach var="erro" items="${mensagens.erros}">
               		<li> ${erro} </li>
              	</c:forEach>
	        </ul>	
	    </div>
    </c:if>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<div align="center">
		<h1>Gerenciamento de Locações</h1>
		<h2>
			<c:if test="${usuarioLogado != null }">
				<c:if test="${usuarioLogado.getPapel() == 'cliente'}">
					<a href="/<%=contextPath%>/loginCliente/">Menu Cliente</a>
				</c:if>
				<c:if test="${usuarioLogado.getPapel() == 'locadora'}">
					<a href="/<%=contextPath%>/loginLocadora/">Menu locadora</a>
				</c:if>
			</c:if>
		</h2>
	</div>

	

	<div align="center">
		<table border="1">
			<caption>Lista de locacao</caption>
			<tr>
				<th>CPF</th>
				<th>CNPJ</th>
				<th>Data Locação</th>
				<th>Hora Locação</th>
			</tr>
			<c:forEach var="locacao" items="${requestScope.listaLocacoes}">
				<tr>
					<td>${locacao.getCPF()}</td>
					<td>${locacao.getCNPJ()}</td>
					<td>${locacao.getDataLocacao()}</td>
					<td>${locacao.getHorarioLocacao()}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>