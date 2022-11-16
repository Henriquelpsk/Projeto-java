<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<%@ include file="components/header.jsp" %>
	<title>Adicionar Conta</title>
</head>

<body>
	<div class="container-fluid h-100">
		<div class="row second-bg h-100">
			<div class="container-conta ps-4 pe-4">
				<div class="alinhamento d-flex justify-content-between ps-2 pe-2 mt-3">
					<a href="dashboard"><img class="nav-img-size" src="./resources/img/account/return.svg"></a>
					<h1 class="fs-21 txt-white pe-2">Adicionar Conta</h1>
				</div>

				<div class="alinhamento">
					<div class="card mt-5">
						<form class="px-3 py-2" action="conta" method="post">
						    <input type="hidden" value="cadastrar" name="acao">
							<label for="nome" class="row ms-2 mt-3 fw-semibold txt-primary">Nome da conta</label>
							<div class="d-flex p-2">
								<img class="me-3" src="./resources/img/account/name.svg" alt="foto nome">
								<input id="nome" name="nome" class="form-control" type="text" placeholder="Digite o nome da conta">
							</div>

							<label for="banco" class="row ms-2 mt-3 fw-semibold txt-primary">Banco</label>
							<div class="d-flex p-2">
								<img class="me-3" src="./resources/img/account/agency.svg" alt="foto banco">
							<input id="banco" name="banco" class="form-control" type="text" placeholder="00	">
							</div>	

							<label for="agencia" class="row ms-2 mt-3 fw-semibold txt-primary">Agência</label>
							<div class="d-flex p-2">
								<img class="me-3" src="./resources/img/account/account.svg" alt="foto agencia">
							<input id="agencia" name="agencia" class="form-control" type="text" placeholder="0000	">
							</div>	

							<label for="conta" class="row ms-2 mt-3 fw-semibold txt-primary">Conta</label>
							<div class="d-flex p-2">
								<img class="me-3" src="./resources/img/account/bank.svg" alt="foto conta">
							<input id="conta" name="conta" class="form-control" type="text" placeholder="00000000">
							</div>

							<label for="saldo" class="row ms-2 mt-3 fw-semibold txt-primary">Saldo da conta</label>
							<div class="d-flex p-2">
								<img class="me-3" src="./resources/img/account/money.svg" alt="foto saldo">
							<input id="saldo" name="saldo" class="form-control" type="text" placeholder="0000.00">
							</div>	

							<div class="d-grid gap-2 mt-3 px-2">
								<button type="submit" id="botao-cria-conta" class="btn btn-primary mt-3 mb-3">Criar Conta</button>
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