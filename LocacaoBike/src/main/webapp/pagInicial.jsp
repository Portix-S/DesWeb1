<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="messages" var="bundle" />


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
        <title><fmt:message key="greeting25" bundle="${bundle}"/></title>
    </head>
    <body>
        <%
        String contextPath = request.getContextPath().replace("/", "");
        %>
    <h1 style="text-align:center;"><fmt:message key="greeting" bundle="${bundle}"/></h1>
     <h3 style="text-align:center;"><fmt:message key="greeting2" bundle="${bundle}"/></h3>
    <div class="centered-link">
    	<a href="/<%=contextPath%>/locadoras/lista"><fmt:message key="greeting3" bundle="${bundle}"/></a>
    </div>
	<h3 style="text-align:center;"><fmt:message key="greeting6" bundle="${bundle}"/></h3>
	<div class="centered-link">
    	<a href="login.jsp"><fmt:message key="greeting7" bundle="${bundle}"/></a>
    </div>
    </body>
</html>