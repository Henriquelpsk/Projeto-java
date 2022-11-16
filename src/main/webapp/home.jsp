<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
	<title>Fintech App</title>
	<%@ include file="components/header.jsp" %>
</head>

<body>
	<div class="container-md h-100">
		<div class="row align-items-center h-100">
			<div class="col">

				<div class="row">
					<div class="col mt-4 mb-5">
						<img src="./resources/img/login/Logo.svg" alt="logo" class="mx-auto d-block">
					</div>
				</div>
				<div class="row">
					<div class="col">
						<h1 class="mb-4 fs-21 text-center">Faça Login</h1>
							<span class="navbar-text text-success" style="margin-right:10px" >
	        					${msg }
	  						</span>	
	    					<span class="navbar-text text-danger" style="margin-right:10px" >
	        					${erro }
	  						</span>	
						<form action="login" method="post">
						<input type="text" class="form-control mb-2" placeholder="Digite seu email"
							aria-label="Username" name="email" id="username">
						<span class="input-text"></span>
						<input type="password" class="form-control mb-4" placeholder="Digite sua senha" aria-label="Password" name="senha" id="password">
						<div class="d-grid gap-2">
							<button type="submit" id="botao-conectar" class="btn btn-primary mb-3">Conectar</button>
						</div>
						</form>

					</div>
				</div>

				<div class="row">
					<div class="col mb-1">
						<p class="text-center"><a href="">Esqueceu a senha?</a></p>
					</div>
				</div>

				<div class="row">
					<div class="col mb-3">
						<p class="text-center">Ou conectar ultilizando</p>
						<div class="connect-container text-center">
							<img src="./resources/img/login/Google.svg" class="connectLogo me-2" alt="Google logo">
							<img src="./resources/img/login/Facebook.svg" class="connectLogo me-2" alt="Facebook Logo">
							<img src="./resources/img/login/Apple.svg" class="connectLogo" alt="Apple logo">
						</div>
					</div>
				</div>

				<div class=" row mb-5">
					<div class="col">
						<div class="d-grid gap-2">
							<a href="registro" class="btn btn-outline-primary">Criar Conta</a>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
<%@ include file="components/footer.jsp" %>
</body>
</html>