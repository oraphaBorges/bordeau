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
<div class="container" style="padding-top: 50px;">
	<h1 class="text-center" style="padding-bottom: 10px;">Cadastro Episódio Podcast</h1>
	<div class="mx-auto">
      <form method="post" action="/bordeau/podcast/submit" enctype="multipart/form-data">
		<div class="form-group row">
			<label for="titulo" class="col-sm-1 col-form-label font-weight-bold"
						style="color: #800000">Tí­tulo:</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="titulo"
							placeholder="Título do episódio" maxlength="50" required
							onkeyup="contaTitulo();">
				<div class="contador">
					<span id="contador-titulo" style="color: #808080; font-size: 12px">50 caracteres restantes</span>
				</div>
			</div>
		</div>
		<div class="form-group row">
			<label for="descricao" class="col-sm-1 col-form-label font-weight-bold"
						style="color: #800000">Descrição:</label>
			<div class="col-sm-8">
				<textarea class="form-control" id="descricao" rows="3" placeholder="Descrição do episódio" maxlength="240" onkeyup="contaDescricao();"></textarea>
				<div class="contador">
					<span id="contador-desc" style="color: #808080; font-size: 12px">240 caracteres restantes</span>
				</div>
			</div>
		</div>

		<div class="form-group row">
			<label for="capa" class="col-sm-4 col-form-label font-weight-bold"
						style="color: #800000">Enviar imagem da capa do episódio:</label>
			<div class="col-sm-5">
				<input type="file" class="form-control-file" id="capa"
							accept="image/*">
			</div>
		</div>
		<div class="form-group row">
			<label for="audio" class="col-sm-4 col-form-label font-weight-bold"
						style="color: #800000">Enviar o podcast do episódio:</label>
			<div class="col-sm-5">
				<input type="file" class="form-control-file" id="audio"
							accept="audio/*" required>
			</div>
		</div>


        <div class="form-group row">
            <label class="col font-weight-bold" style="color: #800000">Conteúdo complementar:</label>
        </div>
      <div class="form-group row" style="margin-bottom: 75px">
            <div class="col">
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
	<div class="form-group row">
            <div class="col">
                    <button class="btn font-weight-bold" onclick="submit(this)"
							style="background-color: #800000; color: #ffffff" type="button">Concluir</button>
              </div>
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