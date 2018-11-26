<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

	<div class="form-signin text-center">
		<h1 class="display-5">Dados do Usuario</h1>
		<p class="lead">Preencha todos os dados pessoais</p>
		<hr class="featurette-divider" style="width: 40%;">
	</div>
	<div class="form-group">
		<form:input path="nome" cssClass="form-control" required="required"
			placeholder="Nome completo" />
	</div>
	<div class="form-group">
		<form:input path="email" cssClass="form-control" required="required"
			placeholder="E-mail" />
	</div>
	<div class="form-group">
		<form:password path="senha" cssClass="form-control"
			placeholder="Senha" />
	</div>
