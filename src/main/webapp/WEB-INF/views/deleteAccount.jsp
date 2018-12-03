<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<tag:template-painel>
	<jsp:body>
	<div class="container mx-auto">
		<div class="form-signin d-block jumbotron text-center" style="width: 400; margin-top:30px;">
	        <h5>Deletar Conta</h5>
	        <p>Você tem certeza que deseja deletar a sua conta do Bordeau?</p>
	        <div class="row container form-group">
		        <a class="form-control btn btn-outline-danger col-md-6" href="${s:mvcUrl('UC#excluirConta').build()}" ><span class="oi oi-trash"></span> Sim</a>
		        
		        <a class="form-control btn btn-outline-success col-md-6" href="/bordeau" ><span class="oi oi-home"></span> Não</a>
	        </div>
		</div>
	</div>
	</jsp:body>
</tag:template-painel>