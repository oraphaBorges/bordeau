<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<tag:template-painel>
	<jsp:body>
		<div class="d-block mx-auto text-center " style="margin-top:10%">
			<div class="form-signin text-center">
				<h1 class="display-3">Meus Episódios</h1>
				<p class="lead"></p>
				<hr class="featurette-divider" style="width: 40%;">
			</div>		
		</div>
		<div class="pricing-header mx-auto text-center">
				    <h4 class="display-4">Episódios Em Alta</h4>
					<hr class="featurette-divider" style="width: 40%;">
					<div class="album py-5 bg-light">
				       <div class="container">
				         <div class="row">

						<c:forEach items="${episodios}" var="episodioEmAlta">
						  <a href="${s:mvcUrl('EC#exibirPagina').arg(0,episodioEmAlta.id).build()}">
				          <div class="col-md-4">
				              <div class="card mb-4 shadow-sm">
				                <img class="card-img-top" src="/bordeau/${episodioEmAlta.capa}" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;"  data-holder-rendered="true">
				                <div class="card-body">
				                  <a href="" class="text-dark"><h4 class="text-dark">${episodioEmAlta.titulo}</h4></a>
				                  <p class="card-text">${episodioEmAlta.descricao}</p>
				                  <div class="d-flex justify-content-between align-items-center">
				                    <div class="btn-group">
				                      <a href="" class="text-dark"><button type="button" class="btn btn-sm btn-outline-secondary">conheça o podcast</button></a>
				                    </div>
				                    <small class="text-muted"> 5 / 5 Estrelas </small>
				                  </div>
				                </div>
				              </div>
				            </div>
				            </a>
				          </c:forEach>


				          </div>
				        </div>
				      </div>
				</div>
	</jsp:body>
</tag:template-painel>