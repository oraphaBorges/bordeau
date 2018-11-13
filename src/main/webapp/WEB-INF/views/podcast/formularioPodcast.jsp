<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<head>
<title>Formulário</title>
<c:url value="/resources" var="resourcePath" />
<link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">
</head>
<tag:template-index>
	<jsp:body>
		<div class="container" style="padding: 50px;">
		<div class="mx-auto">
		  <div class="form-signin text-center">
			<h1 class="display-3">Podcast</h1>
			<p class="lead">Preencha todos os dados para a criação do seu Podcast</p>
			<hr class="featurette-divider" style="width: 40%;">
		  </div>
          <div class="card-body">
			<table class="list-unstyled mt-3 mb-4 ">
				<form:form action="${s:mvcUrl('PC#enviarFormulario').build()}" method="POST" modelAttribute="podcast" enctype="multipart/form-data">
					<form:hidden path="id" value="${podcast.id}"/>
					<div class="form-row">
						<div class="form-group col-sm-12 col-md-12">
							<label class="font-weight-bold font-red">Nome: </label>
							<form:input path="nome" cssClass="form-control" required="required"/>
						</div>
						<div class="form-group col-sm-12 col-md-12">
							<label class="font-weight-bold font-red">Descrição: </label>
							<form:textarea path="descricao" cssClass="form-control" required="required"/>
						</div>

						 <div class="form-group col-sm-12 col-md-6">
					        <label class="col-form-label font-weight-bold font-red">Enviar imagem da capa do episódio:</label>
					        <input name="files" type="file" class="form-control-file btn btn-outline-danger" accept="image/*">
					    </div>

						<button type="submit" class="btn btn-danger" style="width: 100%"><span class="oi oi-check"></span> Salvar</button>
			</form:form>
			</table>
          </div>
        </div>
      </div>
	</jsp:body>
</tag:template-index>
