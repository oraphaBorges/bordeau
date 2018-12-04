<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<section style="margin: 20px;">
	<p>Recomendações de Podcasts:</p>
	<c:forEach items="${PodcastsRecomendados}" var="podcastRecomendado">
		<a class="bg-white text-dark" href="${s:mvcUrl('PC#exibirPagina').arg(0,podcastRecomendado.id).build()}"  >
			<div class="card " style="min-width: 150px; min-height: 160px; margin-top: 10px;">
				<div class="card-body bg-light">
					<div class="row">
						<img class="card-img-top col-5" src="/bordeau/${podcastRecomendado.capaPath}" alt="Card image cap" style="height: 100px;width: 170px;" data-holder-rendered="true" >
						<div class="col-7 small">
							<p class="card-title small">${podcastRecomendado.nome}</p>
							<p class="card-text small">${podcastRecomendado.descricao}.</p>
						</div>
					</div>
				</div>
			</div>
		</a>
	</c:forEach>
</section>