<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<tag:template-index>
	<jsp:body>
		<div class="form-signin d-block mx-auto jumbotron text-center" style="width: 400; margin-top:30px;">
	        <div class="form-signin text-center">
				<h1 class="display-5">Acesso Negado</h1>
				<p class="lead">Infelizmente seu usuário não possúi permissão de acesso à essa página!</p>
				<p class="lead">Em caso de dúvida entrar em contato com nassa <a href="mailto:suport@bordeau.com">equipe de suport</a></p>
				<hr class="featurette-divider" style="width: 40%;">
				<a class="form-control btn btn-outline-danger col-md-6" href="/bordeau" ><span class="oi oi-home"></span> Home</a>
			</div>
		</div>
			
	</jsp:body>
</tag:template-index>