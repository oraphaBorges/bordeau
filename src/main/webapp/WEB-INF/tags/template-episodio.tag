<%@ tag language="java"%>
<%@ tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="header" fragment="true"%>

<head>
	<c:url value="/resources" var="resourcePath" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="${resourcePath}/css/open-iconic/font/css/open-iconic-bootstrap.css">
	<link rel="stylesheet" href="${resourcePath}/css/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="${resourcePath}/css/textMenu.css">
	<link rel="stylesheet" href="${resourcePath}/css/episodio.css">
	
	<title>Bordeau</title>
</head>
<html>
<body class="bg-light" style="min-height:75%;">
<%@include file="components/header.jsp"%>
<div>
	<div>
		<div id="sucesso" class="col-12"></div>
		<div class="col-sm-12 parallax" id="episodio-capa" style="weight:100%;height: 200px; background-image: url('/bordeau/${episodio.capa}');"></div>
	</div>
	<div class="row mx-auto">
		<section class="col-sm-12 col-md-8 col-lg-8">
			<jsp:doBody />
		</section>
		<section class="col-sm-12 col-md-4 col-lg-4">
			<%@include file="components/recomendationsEpisodios.jsp"%>
			<%@include file="components/recomendationsPodcast.jsp"%>
		</section>
	</div>
</div>
<%@include file="components/footer.jsp"%>
<script src="${resourcePath}/JS/bootstrap/bootstrap.min.js"></script>

</body>