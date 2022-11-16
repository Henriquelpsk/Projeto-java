<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<%@ include file="components/header.jsp" %>
	<title>Adicionar Categoria</title>
</head>

<body>
	<div class="container-fluid h-100">
		<div class="row second-bg h-100">
			<div class="container-conta ps-4 pe-4">
				<div class="alinhamento d-flex justify-content-between ps-2 pe-2 mt-3">
					<a href="dashboard"><img class="nav-img-size" src="./resources/img/account/return.svg"></a>
					<h1 class="fs-21 txt-white pe-2">Adicionar Cartegoria</h1>
				</div>

				<div class="alinhamento">
					<div class="card mt-5">
						<form class="px-3 py-2" action="categoria" method="post">
						    <input type="hidden" value="cadastrar" name="acao">
							<label for="nomeCategoria" class="row ms-2 mt-3 fw-semibold txt-primary">Nome da categoria</label>
							<div class="d-flex p-2">
								<img class="me-3" src="./resources/img/account/name.svg" alt="">
								<input id="nomeCategoria" name="nomeCategoria" class="form-control" type="text" placeholder="Digite o nome da categoria" value="${categoria.nome }">
							</div>

							<div class="d-grid gap-2 mt-3 px-2">
								<button type="submit" id="botao-cria-conta" class="btn btn-primary mt-3 mb-3">Criar Categoria</button>

								<div class="mt-5"></div>

							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="components/nav.jsp" %>
	<%@ include file="components/footer.jsp" %>
</body>

</html>