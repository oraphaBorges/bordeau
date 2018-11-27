<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<div class="form-signin text-center">
	<h1 class="display-5">Podcast</h1>
	<p class="lead">Preencha todos os dados para a criação do seu
		Podcast</p>
	<hr class="featurette-divider" style="width: 40%;">
</div>
<div class="card-body">
	<table class="list-unstyled mt-3 mb-4 ">
			<form:hidden path="podcast.id" />
			<div class="form-group row">
				<label class="font-weight-bold font-red">Nome: </label>
				<form:input value="${podcast.nome}" path="podcast.nome" cssClass="form-control" placeholder="Nome completo" required="required" />
			</div>
			<div class="form-group row">
				<label class="font-weight-bold font-red">Descrição: </label>
				<form:textarea value="${podcast.descricao}" rows="4" path="podcast.descricao" cssClass="form-control" placeholder="Descrição" required="required" />
			</div>

			<div class="form-group row">
				<label class="col-form-label font-weight-bold font-red">Enviar imagem da capa do episódio:</label> 
				<input value="" name="files" type="file" class="form-control-file btn btn-outline-danger" accept="image/*">
			</div>
	</table>
</div>
