<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<tag:template-index>
	<jsp:body>
		<div class="form-signin d-block mx-auto jumbotron text-center" style="width: 400; margin-top:30px;">
			<div class="form-signin text-center">
				<h1 class="display-5">Login</h1>
				<p class="lead">Bordeau, uma só plataforma, muito mais conteúdo!</p>
				<hr class="featurette-divider" style="width: 40%;">
			</div>
	        <form:form servletRelativeAction="/login" method="POST">
			    <div class="form-group">
			        <input name="username" type="text" class="form-control" placeholder="Usuário"/>
			    </div>
			    <div class="form-group">
			        <input name="password" type="password" class="form-control" placeholder="Senha" />
			    </div>
			    <button type="submit" class="btn btn-dark">Logar</button>
			    <a href="/bordeau/usuarios/cadastro" class="btn btn-danger">Cadastrar Usuários</a>
			    <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
			</form:form>
		</div>
		
		<security:authorize access="isAuthenticated()"> 
		<c:redirect url="/" />
		</security:authorize>
	
	</jsp:body>
</tag:template-index>