<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table border="1">
	<caption>
   		<c:choose>
   			<c:when test="${cliente != null}">
                               Edição
                           </c:when>
   			<c:otherwise>
                               Cadastro
                           </c:otherwise>
   		</c:choose>
	</caption>
 	<c:if test="${cliente != null}">
   		<input type="hidden" name="CPF" value="${cliente.CPF}" />
   	</c:if>
   	<tr>
   		<td><label for="CPF">CPF</label></td>
   		<td><input type="text" id="CPF" name="CPF" size="45"
   			required value="${cliente.CPF}" /></td>
   	</tr>
   	<tr>
   		<td><label for="sexo">Sexo</label></td>
   		<td><input type="text" id="sexo" name="sexo" size="45" required
   			value="${cliente.sexo}" /></td>
   	</tr>
   	<tr>
   		<td><label for="email">Email</label></td>
   		<td><input type="text" id="email" name="email" size="5" required
   			min="1500" value="${locadora.email}" /></td>
   	</tr>
   	<tr>
   		<td><label for="nome">Nome</label></td>
   		<td><input type="text" id="nome" name="nome" required
   			min="0.01" step="any" size="5" value="${locadora.nome}" /></td>
   	</tr>
       <tr>
        <td><label for="telefone">Telefone</label></td>
        <td><input type="text" id="telefone" name="telefone" required
            min="0.01" step="any" size="5" value="${cliente.telefone}" /></td>
    </tr>
    <tr>
        <td><label for="data_nascimento">Data de Nascimento</label></td>
        <td><input type="date" id="data_nascimento" name="data_nascimento" required
            min="0.01" step="any" size="5" value="${cliente.data_nascimento}" /></td>
    </tr>
   	<tr>
   		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
   	</tr>
</table>