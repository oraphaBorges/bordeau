<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<head>
<title>Formulário</title>
<c:url value="/resources" var="resourcePath" />
<link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">
</head>
<tag:template>
	<jsp:body>
<div class="container" style="padding: 50px;">
	<div class="mx-auto">
	  <div class="form-signin text-center">
		<h1 class="display-3">Episódio</h1>
		<p class="lead">Preencha todos os dados para dar um upload em seu episódio</p>
		<hr class="featurette-divider" style="width: 40%;">
	  </div>
      <form method="post" action="/bordeau/podcast/episodio/submit" class="row">
      
		<div class="form-group col-md-4">
		  <label for="titulo" class="font-weight-bold font-red">Titulo</label>
		  <input type="text" class="form-control" id="titulo" placeholder="Título">
		</div>

		<div class="form-group col-md-8">
		    <label for="descricao" class="font-weight-bold font-red">Descrição</label>
		    <textarea class="form-control" id="descricao" rows="2" placeholder="Digite aqui o título do seu episódio"></textarea>
		 </div>
		
		
		<div class="form-group col-md-6">
			<label for="capa" class=" col-form-label font-weight-bold font-red">Enviar imagem da capa do episódio:</label>
			<input type="file" class="form-control-file btn btn-outline-danger" id="capa"	accept="image/*">
		</div>
		<div class="form-group col-md-6">
			<label for="audio" class="col-form-label font-weight-bold font-red">Enviar o podcast do episódio:</label>
			<input type="file" class="form-control-file btn btn-outline-danger" id="audio"	accept="audio/*" required>
		</div>
				
      <div class="form-group col-md-12">
            <label class="font-weight-bold font-red">Conteúdo complementar:</label>
            <div class="height-cc">
               <div class="quill-wrapper">
                <div id="toolbar" class="toolbar">
                <span class="ql-formats">
                <select class="ql-font">
                <option selected=""></option>
                <option value="serif"></option>
                <option value="monospace"></option>
                </select>
                <select class="ql-size">
                <option value="small"></option>
                <option selected=""></option>
                <option value="large"></option>
                <option value="huge"></option>
                </select>
                </span>
                <span class="ql-formats">
                <button class="ql-bold"></button>
                <button class="ql-italic"></button>
                <button class="ql-underline"></button>
                <button class="ql-strike"></button>
                </span>
                <span class="ql-formats">
                <select class="ql-color"></select>
                <select class="ql-background"></select>
                </span>
                <span class="ql-formats">
                <button class="ql-list" value="ordered"></button>
                <button class="ql-list" value="bullet"></button>
                <select class="ql-align">
                <option selected=""></option>
                <option value="center"></option>
                <option value="right"></option>
                <option value="justify"></option>
                </select>
                </span>
                <span class="ql-formats">
                <button class="ql-link"></button>
                <button class="ql-image"></button>
                </span>
                </div>
                <input type="text" name="c" id="c" hidden>
                <div id="editor" class="editor"></div>
                </div>
            </div>
        </div>


    	<div class="form-group col-md-12" style="
			    margin-top: 70px;
			">
	       	<button class="btn btn-danger" type="submit"><span class="oi oi-check"></span> Concluir</button>
        </div>
      </form>
	</div>
    </div>
    <script src="${resourcePath}/JS/quill/quill.min.js"></script>
	<script type="text/javascript" src="${resourcePath}/JS/formulario.js"></script>
	<script>
		function submit(btn){
			document.getElementById('c').value = JSON.stringify(quill.getContents());
			btn.form.submit();
		}
	</script>
	</jsp:body>
</tag:template>