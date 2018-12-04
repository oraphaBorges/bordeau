<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<section style="margin: 20px;">
	<p>Recomendações de Episódios:</p>
	<c:forEach items="${EpisodiosRecomendado}" var="episodioRecomendado">
		<a class="text-dark" href="${s:mvcUrl('EC#exibirPagina').arg(0,episodioRecomendado.id).build()}">
			<div class="card " style="min-width: 150px; min-height: 160px; margin-top: 10px;">
				<div class="card-body bg-white">
					<div class="row">
						<img class="card-img-top col-5" src="/bordeau/${episodioRecomendado.capa}" alt="Card image cap" style="height: 100px;width: 170px;" data-holder-rendered="true" >
						<div class="col-7 small">
							<p class="card-title small">${episodioRecomendado.titulo}</p>
							<p class="card-text small" >${episodioRecomendado.descricao}.</p>
						</div>
					</div>
				</div>
			</div>
		</a>
	</c:forEach>
</section>