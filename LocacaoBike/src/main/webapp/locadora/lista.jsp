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
		<h1>Gerenciamento de Locadora</h1>
		<h2>
			<c:if test="${usuarioLogado != null }">
				<c:if test="${usuarioLogado.getPapel() == 'cliente'}">
					<a href="/<%=contextPath%>/loginCliente/">Menu Cliente</a>
				</c:if>
				<c:if test="${usuarioLogado.getPapel() == 'locadora'}">
					<a href="${pageContext.request.contextPath}/loginLocadora/">Menu Locadora</a>
				</c:if>
				<c:if test="${usuarioLogado.getPapel() == 'admin'}">
					<a href="${pageContext.request.contextPath}/locadoras/cadastro">Adcionar Locadora</a>
				</c:if>
			</c:if>
		</h2>
	</div>

	

	<div align="center">
	<input type="text" id="modelFilter" onkeyup="filterFunction()" placeholder ="Procure pela cidade">
		<table id="cidade" border="1">
			<caption>Lista de Locadoras</caption>
			<tr>
				<th>CNPJ</th>
				<th>Cidade</th>
				<th>Email</th>
				<th>Nome</th>
				<c:if test="${usuarioLogado.getPapel() == 'admin'}">
					<th>Senha</th>
					<th>Papel</th>
				</c:if>
			</tr>
			<c:forEach var="locadora" items="${requestScope.listaLocadoras}">
				<tr>
					<td>${locadora.getCNPJ()}</td>
					<td>${locadora.getCidade()}</td>
					<td>${locadora.getEmail()}</td>
					<td>${locadora.getNome()}</td>
					<c:if test="${usuarioLogado.getPapel() == 'admin'}">
					<td>${locadora.getSenha()}</td>
					<td>${locadora.getPapel()}</td>
						<td><a href="/<%= contextPath%>/locadoras/edicao?CNPJ=${locadora.CNPJ}">Edição</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="/<%= contextPath%>/locadoras/remocao?CNPJ=${locadora.CNPJ}"
							onclick="return confirm('Tem certeza de que deseja excluir este item?');">
								Remoção </a></td>
					</c:if>
					<c:if test="${usuarioLogado.getPapel() == 'cliente'}">
						<td><a href="/<%= contextPath%>/locacoes/cadastro?CNPJ=${locadora.getCNPJ()}&Email=${usuarioLogado.getEmail()}">Fazer Locação</a>
					</c:if>


				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>