<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
						<h1 class="mb-4 fs-21 text-center">Criar conta</h1>
							    <span class="navbar-text text-danger" style="margin-right:10px" >
	        						${msg }
	  							</span>	
						<form action="registro" method="post">

							<label for="name">Nome</label>
							<input type="text" id="name" name="name" class="form-control mb-2" placeholder="Digite seu nome"
								aria-label="Name">

							<label for="email">Email</label>
							<input type="text" id="email" name="email" class="form-control mb-2" placeholder="Usuario@gmail.com"
								aria-label="Email">

							<label for="senha">Senha</label>
							<input type="password" id="senha" name="senha" class="form-control mb-2"
								placeholder="Digite sua senha" aria-label="Password">

							<label for="phone">Telefone</label>
							<input type="text" id="phone" name="phone" class="form-control mb-2" placeholder="Apenas números"
								aria-label="Phone">

							<label for="data">Data de nascimento</label>
							<input type="text" id="data" name="data" class="form-control mb-5" placeholder="00/00/0000"
								aria-label="Password">

								<div class="row d-grid gap-2">
									<a href="login" class="btn btn-outline-primary mb-3">Voltar</a>
									<button type="submit" id="botao-criar" class="btn btn-primary mb-3">Criar</button>
								</div>
						</form>
					</div>
				</div>
				
			</div>
		</div>
	</div>
<%@ include file="components/footer.jsp" %>
</body>

</html>