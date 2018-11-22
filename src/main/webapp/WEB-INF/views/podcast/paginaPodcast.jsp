<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<tag:template-podcast>
	<jsp:body>
	<div class="mx-auto">
		  <div class="form-signin text-center" style="margin-top: 30px;">
			<a id="nome-criador" class="font-weight-bold" ><h1 class="display-3">${podcast.nome}</h1></a>
			<h4 id="titulo"></h4>
			<hr class="featurette-divider" style="width: 40%;">
		  </div>
		  			<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
				    <h1 class="display-4">Episodios</h1>
					<hr class="featurette-divider" style="width: 40%;">
					<div class="album py-5 bg-light">
				        <div class="container">
				          <div class="row">
				          <c:forEach items="${podcast.episodios}" var="episodio">
				          	<a href="${s:mvcUrl('EC#exibirPagina').arg(0,episodio.id).build()}">
				            <div class="col-md-4">
				              <div class="card mb-4 shadow-sm">
				                <img class="card-img-top" src="${episodio.capaPath}" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" data-holder-rendered="true">
				                <div class="card-body">
				                  <a href="" class="text-dark"><h4 class="text-dark">${episodio.titulo}</h4></a>
				                  <p class="card-text">${novoEpisodio.descricao}</p>
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
		  
	</div>	
	</jsp:body>
</tag:template-podcast>