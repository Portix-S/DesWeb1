<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="messages" var="bundle" />

<html>
<head>
<title><fmt:message key="greeting25" bundle="${bundle}"/></title>
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
		<h1><fmt:message key="greeting38" bundle="${bundle}"/></h1>
		<h2>
			<c:if test="${usuarioLogado != null }">
				<c:if test="${usuarioLogado.getPapel() == 'cliente'}">
					<a href="/<%=contextPath%>/loginCliente/"><fmt:message key="greeting27" bundle="${bundle}"/></a>
				</c:if>
				<c:if test="${usuarioLogado.getPapel() == 'locadora'}">
					<a href="/<%=contextPath%>/loginLocadora/"><fmt:message key="greeting13" bundle="${bundle}"/></a>
				</c:if>
			</c:if>
		</h2>
	</div>

	

	<div align="center">
		<table border="1">
			<caption><fmt:message key="greeting17" bundle="${bundle}"/></caption>
			<tr>
				<th>CPF</th>
				<th>CNPJ</th>
				<th>Data Locação/Lease date</th>
				<th>Hora Locação/Lease time</th>
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