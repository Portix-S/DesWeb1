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
   		<input type="hidden" name="CPF" value="${cliente.getCPF()}" />
   	</c:if>
   	<tr>
   		<td colspan="2" align="center"><label for="CPF">CPF ${cliente.getCPF()}</label></td>
   	</tr>
   	<tr>
   		<td><label for="sexo">Sexo</label></td>
   		<td><input type="text" id="sexo" name="sexo" size="45" required
   			value="${cliente.getSexo()}" /></td>
   	</tr>
   	<tr>
   		<td><label for="email">Email</label></td>
   		<td><input type="text" id="email" name="email" size="5" required
   			value="${cliente.getEmail()}" /></td>
   	</tr>
   	<tr>
   		<td><label for="nome">Nome</label></td>
   		<td><input type="text" id="nome" name="nome" required
   			value="${cliente.getNome()}" /></td>
   	</tr>
       <tr>
        <td><label for="telefone">Telefone</label></td>
        <td><input type="text" id="telefone" name="telefone" required
            value="${cliente.getTelefone()}" /></td>
    </tr>
		<tr>
		<td><label for="data_nascimento">Data de Nascimento</label></td>
		<td><input type="text" id="data_nascimento" name="data_nascimento" required
			value="${cliente.getDataNascimento()}" /></td>
	</tr>
	</tr>
		<tr>
		<td><label for="papel">Papel do Usuário</label></td>
		<td><input type="text" id="papel" name="papel" required
		value="${cliente.getPapel()}" /></td>
	</tr>
	<tr>
        <td><label for="senha">Senha de Usuário</label></td>
        <td><input type="text" id="senha" name="senha" required
            value="${cliente.getSenha()}" /></td>
    </tr>
   	<tr>
   		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
   	</tr>
</table>