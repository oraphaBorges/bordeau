<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<head>
<title>Formulário</title>
<c:url value="/resources" var="resourcePath" />
<link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">
<link href="${resourcePath}/css/episodio.css" rel="stylesheet">
</head>
<tag:template-episodio>
	<jsp:body>
		<div class="mx-auto">
		  <div class="form-signin text-center" style="margin-top: 30px;">
			<a id="nome-criador" class="font-weight-bold" href="https://twitter.com/_pequenospoemas"><h1 class="display-3">${Podcast.nome}</h1></a>
			<h4 id="titulo">${episodio.titulo}</h4>
			<p id="data-postagem">01 de outubro de 2018</p>
			<hr class="featurette-divider" style="width: 40%;">
		  </div>
		 		 		
		<div class="container">
		<div class="row">
		  <div class="row mx-auto">
		  
				<p class="col-12" id="descricao">${episodio.descricao} </p>

				<div class="col-12">
                    <div id="waveform"></div>
                    <div style="text-align: center;">
                      <button class="btn btn-danger" onclick="wavesurfer.play()"><span class="oi oi-media-play"></span> Play</button>
                      <button class="btn btn-danger" onclick="wavesurfer.pause()"><span class="oi oi-media-pause"></span> Pause</button>
                    </div>
				</div>
			  
			  <div class="col-12">
				<label name="c" id="c" >${episodio.htmlComplementar} </label>
				<div id="editor" class="editor height-cc" value="${episodio.htmlComplementar}"></div>
			  </div>
		
		  </div>
	    </div>
	    </div>
	    
	    </div>
	    
	<script src="${resourcePath}/JS/jquery.min.js"></script>
	<script src="${resourcePath}/JS/bootstrap/bootstrap.min.js"></script>
	<script src="${resourcePath}/JS/imagesloaded.pkgd.min.js"></script>
	<script src="${resourcePath}/JS/jquery-imagefill.js"></script>
	<script src="${resourcePath}/JS/quill/quill.min.js"></script>
	<script type="text/javascript">$('#episodio-capa').imagefill();</script>
		
	<script type="text/javascript">
		$(document).ready(		
			function toast(){
				x = new URL(location.href);
				if(x.searchParams.get("new") == "success"){
					document.getElementById('sucesso').innerHTML = '<div class="alert alert-success" role="alert">Episódio criado com sucesso!</div>';
				}
				setTimeout(function(){ document.getElementById('sucesso').innerHTML = ''}, 3000);
    		}
    	);
		var quill = new Quill('#editor', {
			theme: 'bubble',
			readOnly : true,
			modules: {}
		});
		quill.setContents(JSON.parse($('#c').val()));
    </script>
    <!-- player audio -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/wavesurfer.js/1.2.3/wavesurfer.min.js"></script>
    <script type="text/javascript" src="${resourcePath}/JS/player.js" one="/bordeau/${episodio.audio}" ></script>
    
	</jsp:body>
</tag:template-episodio>