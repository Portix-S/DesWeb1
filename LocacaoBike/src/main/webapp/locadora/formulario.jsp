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
	<div align="center">
		<h1><fmt:message key="greeting24" bundle="${bundle}"/></h1>
		<h2>
			<a href="lista"><fmt:message key="greeting15" bundle="${bundle}"/></a>
		</h2>
	</div>
	<div align="center">
		<c:choose>
			<c:when test="${locadora != null}">
				<form action="atualizacao" method="post">
					<%@include file="campos.jsp"%>
				</form>
			</c:when>
			<c:otherwise>
				<form action="insercao" method="post">
					<%@include file="campos.jsp"%>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
	<c:if test="${!empty requestScope.mensagens}">
		<ul class="erro">
			<c:forEach items="${requestScope.mensagens}" var="mensagem">
				<li>${mensagem}</li>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>