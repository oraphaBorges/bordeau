<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<tag:template-index>
	<jsp:body>
		<div >
			<div class="form-signin" style="padding:100px;">
				  <form class="form-signin text-center">
					<h1 class="display-3">BORDEAU</h1>
				    <p class="lead">Uma Plataforma Muitos mais Conteúdo</p>
					<div class="row" style="padding-top:20px;">
					    <input class="form-control col-11" type="search" placeholder="Pesquisa" aria-label="Pesquisa">
					    <button class="btn btn-sm btn-outline-danger col-1" type="submit"><i class="material-icons md-18">search</i></button>
					</div>
				  </form>
			</div>
			<div class="" id="podcasts" >

				<div class="pricing-header mx-auto text-center">
			      <p class="lead">Acompanhe o melhor dos podcasts em todo mundo!</p>
			    </div>

			<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center" style="margin-top:150px;">
				    <h1 class="display-4">Podcasts Mais recentes</h1>
					<hr class="featurette-divider" style="width: 40%;">
					<div class="album py-5 bg-light">
				        <div class="container">
				          <div class="row">
				          <c:forEach items="${novosPodcasts}" var="novoPodcast">
				          	<a href="${s:mvcUrl('PC#exibirPagina').arg(0,novoPodcast.id).build()}">
				            <div class="col-md-4">
				              <div class="card mb-4 shadow-sm">
				                <img class="card-img-top" src="${novoPodcast.capaPath}" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" data-holder-rendered="true">
				                <div class="card-body">
				                  <a href="${s:mvcUrl('PC#exibirPagina').arg(0,novoPodcast.id).build()}" class="text-dark"><h4 class="text-dark">${novoPodcast.nome}</h4></a>
				                  <p class="card-text">${novoEpisodio.descricao}</p>
				                  <div class="d-flex justify-content-between align-items-center">
				                    <div class="btn-group">
				                      <a href="${s:mvcUrl('PC#exibirPagina').arg(0,novoPodcast.id).build()}" class="text-dark"><button type="button" class="btn btn-sm btn-outline-secondary">conheça o podcast</button></a>
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

				<div class="pricing-header mx-auto text-center">
				    <h1 class="display-4">Podcasts Em Alta</h1>
					<hr class="featurette-divider" style="width: 40%;">
					<div class="album py-5 bg-light">
				       <div class="container">
				         <div class="row">

						<c:forEach items="${PodcastsEmAlta}" var="podcastEmAlta">
						  <a href="${s:mvcUrl('PC#exibirPagina').arg(0,podcastEmAlta.id).build()}">
				          <div class="col-md-4" >
				              <div class="card mb-4 shadow-sm">
				                <img class="card-img-top" src="${podcastEmAlta.capaPath}" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;"  data-holder-rendered="true">
				                <div class="card-body">
				                  <a href="${s:mvcUrl('PC#exibirPagina').arg(0,podcastEmAlta.id).build()}" class="text-dark"><h4 class="text-dark">${podcastEmAlta.nome}</h4></a>
				                  <p class="card-text">${podcastEmAlta.descricao}</p>
				                  <div class="d-flex justify-content-between align-items-center">
				                    <div class="btn-group">
				                      <a href="${s:mvcUrl('PC#exibirPagina').arg(0,podcastEmAlta.id).build()}" class="text-dark"><button type="button" class="btn btn-sm btn-outline-secondary">conheça o podcast</button></a>
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




				<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
				    <h1 class="display-4">Episódios Mais recentes</h1>
					<hr class="featurette-divider" style="width: 40%;">
					<div class="album py-5 bg-light">
				        <div class="container">
				          <div class="row">
				          <c:forEach items="${novosEpisodios}" var="novoEpisodio">
				          	<a href="${s:mvcUrl('EC#exibirPagina').arg(0,novoEpisodio.id).build()}">
				            <div class="col-md-4">
				              <div class="card mb-4 shadow-sm">
				                <img class="card-img-top" src="${novoEpisodio.capa}" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" data-holder-rendered="true">
				                <div class="card-body">
				                  <a href="${s:mvcUrl('EC#exibirPagina').arg(0,novoEpisodio.id).build()}" class="text-dark"><h4 class="text-dark">${novoEpisodio.titulo}</h4></a>
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

				<div class="pricing-header mx-auto text-center">
				    <h1 class="display-4">Episódios Em Alta</h1>
					<hr class="featurette-divider" style="width: 40%;">
					<div class="album py-5 bg-light">
				       <div class="container">
				         <div class="row">

						<c:forEach items="${EpisodiosEmAlta}" var="episodioEmAlta">
						  <a href="${s:mvcUrl('EC#exibirPagina').arg(0,episodioEmAlta.id).build()}">
				          <div class="col-md-4">
				              <div class="card mb-4 shadow-sm">
				                <img class="card-img-top" src="${episodioEmAlta.capa}" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;"  data-holder-rendered="true">
				                <div class="card-body">
				                  <a href="${s:mvcUrl('EC#exibirPagina').arg(0,episodioEmAlta.id).build()}" class="text-dark"><h4 class="text-dark">${episodioEmAlta.titulo}</h4></a>
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
		</div>
	</jsp:body>
</tag:template-index>
