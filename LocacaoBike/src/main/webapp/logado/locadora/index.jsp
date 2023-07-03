<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="messages" var="bundle" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="greeting13" bundle="${bundle}"/></title>
    </head>
    <body>
        <h1><fmt:message key="greeting16" bundle="${bundle}"/></h1>
        <p><fmt:message key="greeting14" bundle="${bundle}"/> ${sessionScope.usuarioLogado.nome}</p>

        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/locadoras"><fmt:message key="greeting15" bundle="${bundle}"/></a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/locacoes"><fmt:message key="greeting17" bundle="${bundle}"/></a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/logout.jsp"><fmt:message key="greeting18" bundle="${bundle}"/></a>
            </li>
        </ul>
    </body>
</html>