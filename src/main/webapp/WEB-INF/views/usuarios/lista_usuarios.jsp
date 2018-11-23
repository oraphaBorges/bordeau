<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<tag:template-index>
	<jsp:body>
	<h1>Estoque</h1>
	<div>${resultado}</div>
	<a href="${s:mvcUrl('UC#formOuvinte').build()}">Cadastrar Ouvinte</a>
	<a href="${s:mvcUrl('UC#formCreator').build()}">Cadastrar Criador</a>
	<table class="table table-bordered table-striped table-hover">
		<a href="https://bcrypt-generator.com/">BCrypter Calculator</a>
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Senha</th>
			<th>Roles</th>
		</tr>
		<c:forEach items="${usuarios}" var="usuario"> 
		<tr>
			<td>${usuario.nome}</td>
			<td>${usuario.email}</td>
			<td>${usuario.senha}</td>
			<td>
				<c:forEach items="${usuario.roles}" var="role"> 
					<p>${role.nome}</p>
				</c:forEach>
			</td>
		</tr>
		</c:forEach>

	</table>
</jsp:body>
</tag:template-index>
