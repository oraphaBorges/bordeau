<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<tag:template-painel>
	<jsp:body>
	<div class="d-block mx-auto text-center" style="margin-top:10%">
		<div class="form-signin text-center">
			<h1 class="display-3">Painel do Usuário</h1>
			<p class="lead"></p>
			<hr class="featurette-divider" style="width: 40%;">
		</div>
		<form:form servletRelativeAction="${s:mvcUrl('UC#atualiza').build()}" method="post"	modelAttribute="perfil" enctype="multipart/form-data">
			<div class="container" style="padding: 50px;">
				<div class="mx-auto">
				
					<div id="dadosUsuario"><%@include file="components/dadosUsuario.jsp"%></div>
					
					<div id="dadosPodcast"><%@include file="components/dadosPodcast.jsp"%></div>	
					
					<button type="submit" class="btn btn-danger" style="width: 100%"><span class="oi oi-check"></span> Salvar</button>
					
					<security:authorize access="isAuthenticated()">    
						<a href="/bordeau/usuarios" class="btn btn-dark" style="width: 100%">Lista de Usuários</a>
					</security:authorize>
				</div>
			</div>
		</form:form>
	</div>
	</jsp:body>
</tag:template-painel>