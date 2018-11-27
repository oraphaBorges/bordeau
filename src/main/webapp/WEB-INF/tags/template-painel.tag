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
<div class="media">
	<div class="align-self-start">
		<%@include file="components/menuPainel.jsp"%>
	</div>
	<div class="align-self-start">
		<jsp:doBody />
	</div>
</div>
<%@include file="components/footer.jsp"%>
<script src="${resourcePath}/JS/bootstrap/bootstrap.min.js"></script>

</body>