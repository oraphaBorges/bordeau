<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<tag:template-index>
	<jsp:body>
	<div class="d-block mx-auto text-center" style="margin-top:10%">
		<div class="form-signin text-center">
			<h1 class="display-3">Cadastro de Usuário</h1>
			<p class="lead"></p>
			<hr class="featurette-divider" style="width: 40%;">
		</div>
			<div class="container" style="padding: 50px;">
				<div class="mx-auto">
				  <div class="card-deck mb-3 text-center">
			        <div class="card mb-4 shadow-sm">
			          <div class="card-header">
			            <h4 class="my-0 font-weight-normal">Ouvinte</h4>
			          </div>
			          <div class="card-body">
			            <h1 class="card-title pricing-card-title"></h1>
			            <ul class="list-unstyled mt-3 mb-4">
			              <li>Ouças seus podcasts favoritos</li>
			              <li> </li>
			              <li> </li>
			              <li> </li>
			            </ul>
			          </div>
			            <a href="/bordeau/usuarios/cadastroOuvinte" class="btn btn-lg btn-block btn-danger ">Cadastre-se com Ouvinte</a>
			        </div>
			        <div class="card mb-4 shadow-sm">
			          <div class="card-header">
			            <h4 class="my-0 font-weight-normal">Podcast</h4>
			          </div>
			          <div class="card-body">
			            <h1 class="card-title pricing-card-title"></h1>
			            <ul class="list-unstyled mt-3 mb-4">
			              <li>Tenha todas as vantagens do Ouvinte</li>
			              <li>Gerenciamento do seu canal de Podcast</li>
			              <li>Adicione Conteúdos Complementares (textos, imagens, links)</li>
			              <li>  	</li>
			            </ul>
			          </div>
			            <a href="/bordeau/usuarios/cadastroCriadordeConteudo" class="btn btn-lg btn-block btn-danger ">Cadastre-se com Podcast</a>
			        </div>
			      </div>
				</div>
			</div>
	</div>
	</jsp:body>
</tag:template-index>