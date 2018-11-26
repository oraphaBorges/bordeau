<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<tag:template-index>
	<jsp:body>
	<div class="d-block mx-auto jumbotron text-center" style="width: 400px; margin-top:10%">
		<h3>Cadastro de Usuario</h3>
		<form:form servletRelativeAction="${s:mvcUrl('UC#grava').build()}" method="post"	modelAttribute="usuario">
			<div class="form-group">
				<input name="nome" type="text" class="form-control" placeholder="Nome"/>
			</div>
			<div class="form-group">
				<input name="email" type="text" class="form-control" placeholder="E-mail">
			</div>
			<div class="form-group">
				<input name="senha" type="password" class="form-control" placeholder="Senha">
			</div>
			<button type="submit" class="btn btn-dark">Cadastrar</button>
			<security:authorize access="isAuthenticated()">    
			<a href="/bordeau/usuarios" class="btn btn-dark">Lista de Usuários</a>
			</security:authorize>
		</form:form>
	</div>
	</jsp:body>
</tag:template-index>