<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Audio test</title>
</head>
<body>
	<form name="new-audio" action="audio/new" method="post" enctype="multipart/form-data">
		<div>
			<input name="file" type="file" accept="audio/*" />
			<label for="file">Arquivo de áudio</label>
		</div>
		<input type="submit" value="Enviar">
	</form>
</body>
</html>