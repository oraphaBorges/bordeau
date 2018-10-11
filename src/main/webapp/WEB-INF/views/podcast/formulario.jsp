<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
	<tag:template>

		<jsp:body>
		
		<div class="card sm-4 box-shadow d-block mx-auto " style="width: 65%;" >
          <div class="card-header">
			<h1>Cadastro Episódio</h1>
          </div>
          <div class="card-body">
			<table class="list-unstyled mt-3 mb-4 ">
				<form:form action="${s:mvcUrl('EC#gravar').build()}" method="POST" modelAttribute="episodio">
					<form:hidden path="id" value="${episodio.id}"/>
					<div class="form-row">
						<div class="form-group col-sm-12 col-md-12">
							<label>Titulo: </label>
							<form:input path="titulo" cssClass="form-control" required="required"/>
						</div>
						<div class="form-group col-sm-12 col-md-12">
							<label>Descrição: </label>
							<form:input path="descricao" cssClass="form-control" required="required"/>
						</div>
					</div>
					<div class="d-block mx-auto"> 
						<button type="submit" class="btn btn-dark">Salvar</button>
					</div>
			</form:form>
			</table>
          </div>
	</jsp:body>
	</tag:template>