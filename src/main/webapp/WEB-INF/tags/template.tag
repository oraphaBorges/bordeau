<%@ tag language="java"%>
<%@ tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="header" fragment="true"%>

<head>
	<c:url value="/resources" var="resourcePath" />
	<link rel="stylesheet" href="${resourcePath}/css/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="${resourcePath}/css/textMenu.css">
	
	<title>Bordeau</title>
</head>
<html>
<body>
<%@include file="components/header.jsp"%>
<div class="container">
	<jsp:doBody />
</div>
<%@include file="components/footer.jsp"%>
<script src="${resourcePath}/JS/bootstrap/bootstrap.min.js"></script>

</body>