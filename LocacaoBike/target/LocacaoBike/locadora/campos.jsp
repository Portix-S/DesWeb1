<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table border="1">
	<caption>
   		<c:choose>
   			<c:when test="${locadora != null}">
                               Edição
                           </c:when>
   			<c:otherwise>
                               Cadastro
                           </c:otherwise>
   		</c:choose>
	</caption>
 	<c:choose>
		<c:when test="${locadora != null }">
			<input type="hidden" name="CNPJ" value="${locadora.getCNPJ()}" />
			<tr>
				<td colspan="2" align="center"><label for="CNPJ">CNPJ ${locadora.CNPJ}</label></td>
			</tr>
		</c:when>
		<c:otherwise>
		<tr>
			<td><label for="CNPJ">CNPJ</label></td>
			<td><input type="text" id="CNPJ" name="CNPJ" size="45"
               required value="${locadora.getCNPJ()}" /></td>
        </tr>
        </c:otherwise>
    </c:choose>
   	<tr>
   		<td><label for="cidade">Cidade</label></td>
   		<td><input type="text" id="cidade" name="cidade" size="45" required
   			value="${locadora.cidade}" /></td>
   	</tr>
   	
   	<tr>
   		<td><label for="nome">Nome</label></td>
   		<td><input type="text" id="nome" name="nome" required
   			value="${locadora.nome}" /></td>
   	</tr>
	   <tr>
		<td><label for="email">Email</label></td>
		<td><input type="text" id="email" name="email" size="5" required
			value="${locadora.email}" /></td>
	</tr>
	<tr>
        <td><label for="senha">Senha de Usuário</label></td>
        <td><input type="text" id="senha" name="senha" required
            value="${locadora.senha}" /></td>
    </tr>
   	<tr>
   		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
   	</tr>
</table>