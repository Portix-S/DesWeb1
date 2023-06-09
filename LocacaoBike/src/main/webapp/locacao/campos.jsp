<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table border="1">
	<caption>
   		<c:choose>
   			<c:when test="${locacao != null}">
                               Edição
                           </c:when>
   			<c:otherwise>
                               Cadastro
                           </c:otherwise>
   		</c:choose>
	</caption>
 	<c:if test="${locacao != null}">
   		<input type="hidden" name="CPF" value="${cliente.getCPF()}" />
   	</c:if>
   	<tr>
   		<td colspan="2" align="center"><label for="CPF">CPF ${cliente.getCPF()}</label></td>
   		</tr><input type="hidden" id="CPF" name="CPF"
	   		value="${cliente.getCPF()}" />
   	<tr>
		<td colspan="2" align="center"><label for="CNPJ" >CNPJ ${locadora.getCNPJ()}</label></td>
		<input type="hidden" id="CNPJ" name="CNPJ"
			value="${locadora.getCNPJ()}" />
   	</tr>
   	<tr>
   		<td><label for="data_locacao">Data Locacao</label></td>
   		<td><input type="text" id="data_locacao" name="data_locacao" size="5" required
   			value="${locacao.getDataLocacao()}" /></td>
   	</tr>
   	<tr>
   		<td><label for="horario_locacao">Horario Locacao</label></td>
   		<td><input type="text" id="horario_locacao" name="horario_locacao" required
   			value="${locacao.getHorarioLocacao()}" /></td>
   	<tr>
   		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
   	</tr>
</table>