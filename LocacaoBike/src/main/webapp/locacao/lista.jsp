<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Locação Virtual</title>
</head>

<script>
	function filterFunction() {
	  // Declare variables
	  var input, filter, table, tr, td, i, txtValue;
	  input = document.getElementById("modelFilter");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("cidade");
	  tr = table.getElementsByTagName("tr");
	
	  // Loop through all table rows, and hide those who don't match the search query
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[1];
	    if (td) {
	      txtValue = td.textContent || td.innerText;
	      if (txtValue.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }
	  }
	}
</script>


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
					<a href="${pageContext.request.contextPath}/loginLocadora/">Menu locadora</a>
				</c:if>
			</c:if>
		</h2>
	</div>

	

	<div align="center">
	<input type="text" id="modelFilter" onkeyup="filterFunction()" placeholder ="Procure pela cidade">
		<table id="cidade" border="1">
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