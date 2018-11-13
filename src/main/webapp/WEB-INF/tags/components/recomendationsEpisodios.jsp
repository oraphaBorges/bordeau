<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<section style="margin: 20px;">
	<c:forEach items="${recomendados}" var="episodioRecomendado">
		<a href="${s:mvcUrl('EC#exibirPagina').arg(0,episodioRecomendado.id).build()}">
			<div class="card"
				style="min-width: 150px; min-height: 160px; margin-top: 10px;">
				<div class="card-body bg-light">
					<div class="row">
						<img class="card-img-top col-5" src="/bordeau/${episodioRecomendado.capa}" alt="Card image cap" style="height: 100px;width: 170px;" data-holder-rendered="true" >
						<div class="col-7 small">
							<h5 class="card-title">${episodioRecomendado.titulo}</h5>
							<p class="card-text">${episodioRecomendado.descricao}.</p>
						</div>
					</div>
				</div>
			</div>
		</a>
	</c:forEach>
</section>