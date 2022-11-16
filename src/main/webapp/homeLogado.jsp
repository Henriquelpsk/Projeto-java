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
						<h1 class="mb-2 fs-21 text-center">${user}</h1>
						<h1 class="mb-4 fs-21 text-center">conectado com sucesso!</h1>
					</div>
				</div>
				
				


				<div class=" row mb-5">
					<div class="col">
						<div class="d-grid gap-2">
							 <c:if test="${not empty user }">
							 	<a href="dashboard" class="btn btn-primary mb-3 text-white">Entrar</a>
	    						<a href="login" class="btn btn-outline-primary mb-3" >Sair</a>
    						</c:if>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
<%@ include file="components/footer.jsp" %>
</body>
</html>