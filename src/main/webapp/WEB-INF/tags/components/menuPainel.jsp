<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<div class="" style="margin-top:100px;">
	<div class="container " >
		<div class="bg-red row" style="width: 250px; margin: 3px;border: 0px;border-radius: 6px; padding: 10px;">
		<h5 class="text-light text-center col-12">Painel</h5>
		
			<hr class="featurette-divider" style="width: 70%;">
		
		<a class="text-light col-12"	style="text-decoration:none; padding:5px;" href="/bordeau/usuarios/painel/#dadosUsuario">Dados do Usuario</a> 
		<a class="text-light col-12"	style="text-decoration:none; padding:5px;" href="/bordeau/usuarios/painel/#dadosPodcast">Dados do Podcast</a> 
			
			<hr class="featurette-divider" style="width: 70%;">
		<security:authorize access="hasRole('ROLE_CRIADOR')">
		<a class="text-light col-12"	style="text-decoration:none; padding:5px;" href="/bordeau/podcast/episodio/novo">Novo Episódio</a>
		<a class="text-light col-12"	style="text-decoration:none; padding:5px;" href="/bordeau/podcast/meusEpisodios/">Meus Episódios</a> 
		</security:authorize> 
		
			<hr class="featurette-divider" style="width: 70%;">
		
		<a class="text-light col-12"	style="text-decoration:none; padding:5px;" href="">Excluir conta</a> 
		</div>	
	</div>
</div>