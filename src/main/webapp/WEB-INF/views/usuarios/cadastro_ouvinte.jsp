<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<tag:template-index>
	<jsp:body>
	<div class="d-block mx-auto text-center" style="margin-top:10%">
		<div class="form-signin text-center">
			<h1 class="display-3">Cadastro de Usuário</h1>
			<p class="lead"></p>
			<hr class="featurette-divider" style="width: 40%;">
		</div>
		<form:form servletRelativeAction="${s:mvcUrl('UC#grava').build()}" method="post"	modelAttribute="ouvinte" enctype="multipart/form-data">
			<div class="container" style="padding: 50px;">
				<div class="mx-auto">
					
					<%@include file="components/dadosUsuario.jsp"%>				
			
					<button type="submit" class="btn btn-danger" style="width: 100%"><span class="oi oi-check"></span> Salvar</button>
					<security:authorize access="isAuthenticated()">    
						<a href="/bordeau/usuarios" class="btn btn-dark">Lista de Usuários</a>
					</security:authorize>
				</div>
			</div>
		</form:form>
	</div>
	</jsp:body>
</tag:template-index>