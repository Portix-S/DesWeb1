<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="messages" var="bundle" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="greeting9" bundle="${bundle}"/></title>
        <link href="${pageContext.request.contextPath}/layout.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1><fmt:message key="greeting9" bundle="${bundle}"/><h1>
        <c:if test="${mensagens.existeErros}">
            <div id="erro">
                <ul>
                    <c:forEach var="erro" items="${mensagens.erros}">
                        <li> ${erro} </li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <form method="post" action="index.jsp">
            <table>
                <tr>
                    <th>Email: </th>
                    <td><input type="text" name="email"
                               value="${param.email}"/></td>
                </tr>
                <tr>
                    <th><fmt:message key="greeting10" bundle="${bundle}"/></th>
                    <td><input type="password" name="senha" /></td>
                </tr>
                <tr>
                    <td colspan="2"> 
                        <input type="submit" name="bOK" value="<fmt:message key="Enter" bundle="${bundle}"/>"/>
                    </td>
                </tr>
            </table>
        </form>
		<a href="pagInicial.jsp"><fmt:message key="greeting12" bundle="${bundle}"/></a>


    </body>
</html>