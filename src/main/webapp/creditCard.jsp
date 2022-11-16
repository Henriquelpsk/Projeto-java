<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<%@ include file="components/header.jsp" %>
	<title>Adicionar Cartão</title>
</head>

<body>
	<div class="container-fluid h-100">
		<div class="row second-bg h-100">
			<div class="container-conta ps-4 pe-4">
				<div class="alinhamento d-flex justify-content-between ps-2 pe-2 mt-3">
					<a href="dashboard"><img class="nav-img-size" src="./resources/img/account/return.svg"></a>
					<h1 class="fs-21 txt-white pe-2">Adicionar Cartão</h1>
				</div>

				<div class="alinhamento">
					<div class="card mt-5">
						<form class="px-3 py-2" action="cartao" method="post">
							<input type="hidden" value="cadastrar" name="acao">
							<label for="nomeCartao" class="row ms-2 mt-3 fw-semibold txt-primary">Nome do cartão</label>
							<div class="d-flex p-2">
								<img class="me-3" src="./resources/img/account/name.svg" alt="">
								<input id="nomeCartao" name="nome" class="form-control" type="text" placeholder="Digite o nome da cartão" value="${categoria.nome }">
							</div>

							<label for="banco" class="row ms-2 mt-3 fw-semibold txt-primary">Numero do cartão</label>
							<div class="d-flex p-2">
								<img class="me-3" src="./resources/img/creditCard/card.svg" alt="">
							<input id="numero" name="numero" class="form-control" type="text" placeholder="0000000000000000">
							</div>	

							<label for="dataFecha" class="row ms-2 mt-3 fw-semibold txt-primary">Data de fechamento</label>
							<div class="d-flex p-2">
								<img class="me-3" src="./resources/img/creditCard/date.svg" alt="">
							<input id="dataFecha" name="dataFecha" class="form-control" type="text" placeholder="00/00/0000">
							</div>

							<label for="dataVence" class="row ms-2 mt-3 fw-semibold txt-primary">Data de Vencimento</label>
							<div class="d-flex p-2">
								<img class="me-3" src="./resources/img/creditCard/date.svg" alt="">
							<input id="dataVence" name="dataVence" class="form-control" type="text" placeholder="00/00/0000">
							</div>

							<label for="limite" class="row ms-2 mt-3 fw-semibold txt-primary">Limite</label>
							<div class="d-flex p-2">
								<img class="me-3" src="./resources/img/account/money.svg" alt="">
							<input id="limite" name="limite" class="form-control" type="text" placeholder="0000.00">
							</div>	

							<label for="usado" class="row ms-2 mt-3 fw-semibold txt-primary">Valor usado</label>
							<div class="d-flex p-2">
								<img class="me-3" src="./resources/img/account/money.svg" alt="">
							<input id="usado" name="usado" class="form-control" type="text" placeholder="0000.00">
							</div>	

							<div class="d-grid gap-2 mt-3 px-2">
								<button type="submit" id="botao-cria-conta" class="btn btn-primary mt-3 mb-3">Criar Conta</button>

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