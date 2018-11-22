<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<div class="p-2 mx-auto flex-column col-12" style="background-color: rgb(128, 0, 0,0.8);">
	<header class="masthead mb-auto">
		<div class="inner">
			<a style="text-decoration:none;" href="/bordeau/"><h3 class="text-center text-light">BORDEAU</h3></a> 
		</div>
	</header>
</div>
<div class="p-2 flex-column col-12" style="background-color: rgb(128, 0, 0,0.7);">
	<header class="masthead text-left">
		<div class="inner">
			<nav class="nav nav-masthead justify-content-center">
				<security:authorize access="isAuthenticated()">    
					<a class="text-light"	style="text-decoration:none; padding:5px;" href="/bordeau/logout">Sair</a> 
				</security:authorize>
				<security:authorize access="!isAuthenticated()">
					<form:form servletRelativeAction="/login" method="POST">
				    <div class="form-inline">
				        <input name="username" type="text" class="form-control form-control-sm" placeholder="Usu�rio" style="width: 100px;"/>
				        <input name="password" type="password" class="form-control form-control-sm" placeholder="Senha" style="width: 70px;"/>
					    <button type="submit" class="form-control btn btn-danger btn-sm">Logar</button>
				    </div>
					</form:form>					
				</security:authorize>
			</nav>
		</div>
	</header>
</div>
<div class="p-2 mx-auto flex-column col-12" style="background-color: rgb(128, 0, 0,0.7);">
	<header class="masthead mb-auto">
		<div class="inner">
			<nav class="nav nav-masthead justify-content-center">
				<a> atalhos para teste:</a>
				<a class="text-light" style="text-decoration:none; padding:5px;" href="/bordeau/">Home</a> 
				<a class="text-light"	style="text-decoration:none; padding:5px;" href="/bordeau/podcast/episodio/novo">Novo Episodio</a> 
				<a class="text-light"	style="text-decoration:none; padding:5px;" href="/bordeau/usuarios">Usuarios</a> 
				<a class="text-light"	style="text-decoration:none; padding:5px;" href="/bordeau/logout">Sair</a> 
			</nav>
		</div>
	</header>
</div>
