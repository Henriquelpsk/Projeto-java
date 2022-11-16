<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Dashboard</title>
	<%@ include file="components/header.jsp" %>
</head>

<body>
	<div class="container-fluid p-0 h-100">
		<div class="h-100 second-bg">
			<div class="container-teste">
				<div class="row pt-4 pb-5 headerAlign d-flex main-bg">

					<div class="col-10 ps-0">
						<div class="row">
							<img src="./resources/img/user-svgrepo-com 1.png" alt="perfil" class="fit col-4 ">
							<div class="col-8 mt-2">
								<p class="mb-0 txt-white">Olá, ${nome}!</p>
								<p class="mb-0 txt-white fs-10"><a href="login" class="text-white">Desconectar</a></p>
							</div>
						</div>
					</div>

					<div class="col-1 pe-0 ms-2 mt-3">
						<img src="./resources/img/Vector.svg" alt="sino">
					</div>
				</div>
			</div>

				<div class="alinhamento px-2">
					<div class="row card mt-3 ms-3 me-3 mt-n4 px-2">
						<div>
							<p class="mb-0 mt-3 txt-grey">Saldo geral</p>
							<p class="fs-21 fw-bold pb-2 border-bottom txt-purple">R$ 1651,00</p>
						</div>
						<div>
							<p class="mt-2 mb-3">Minhas contas</p>
						</div>

							<c:forEach items="${listaConta }" var="conta">
								<div class="row">
									<div class="col-2">
										<img class="bandeira" src="./resources/img/bandeiraBanco/carteiraSimbolo.svg">
									</div>
							
									<div class="col-6 pe-0">
										<p class="mb-0">${conta.nome }</p>
										<p class="fs-7 txt-grey">Ag.${conta.agencia } C/C ${conta.conta }</p>
									</div>
									<div class="col-4 ps-2 pe-0 text-end">
										<p class="txt-purple">
											<fmt:formatNumber value="${conta.saldo }" type="currency" />
										</p>
									</div>
								</div>
							</c:forEach>
							
						<div class="d-grid gap-2">
							<a href="conta?acao=abrir-cadastro-conta" class="btn btn-primary mb-3 mt-3 text-white">Adicionar Contas</a>
						</div>
					</div>

					<div class="row ms-3 me-3 mt-3 mb-0">
						<a class="btn btn-info mb-3 text-white" href="extrato?acao=abrir-form-cadastro">Cadastrar despesa ou receita</a>
					</div>

					<div class="row card mt-0 ms-3 me-3 px-2">
						<div>
							<p class="mt-3">Cartões de crédito</p>
						</div>
						
							<c:forEach items="${listaCartao }" var="lc">
						<div class="row">
							<div class="col-2">
								<img class="bandeira" src="./resources/img/bandeiraBanco/carteiraSimbolo3.svg">
							</div>
							<div class="col-6 pe-0">
								<p class=" mb-0">${lc.nome }</p>
								<p class="fs-7 txt-grey">
									<fmt:formatNumber type="number" pattern="**** **** **** ####" maxIntegerDigits="4" value="${lc.numero }"/>
								</p>
							</div>
							<div class="col-4 ps-2 pe-0 text-end">
								<p class="txt-orange">
									<fmt:formatNumber value="${lc.usado }" type="currency" />
								</p>
							</div>
							</div>
							</c:forEach>
						
						<div class="d-grid gap-2">
							<a href="cartao?acao=abrir-cadastro-cartao" class="btn btn-primary mb-3 mt-3 text-white">Adicionar Cartões</a>
						</div>
					</div>

					<div class="row card mt-3 ms-3 me-3 px-2">
						<div>
							<p class="mt-3">Categorias</p>
						</div>
							<c:forEach items="${listaCategoria }" var="categoria">
							<div class="row mt-3 ps-25">
							<img class="bandeira p-0 col-2" src="./resources/img/Ícone.svg" alt="icone de categoria">
							<p class="mb-0 col-10">${categoria.nome }</p>
							<div class="row">
								<p class="mt-n2 ps-5 fs-12 txt-grey"></p>
							</div>
						</div>
							</c:forEach>
						<div class="d-grid gap-2">
							<a href="categoria?acao=abrir-cadastro-categoria" class="btn btn-primary mb-3 mt-3 text-white">Adicionar Categoria</a>
						</div>
					</div>

				</div>

				<div class="spacing"></div>


		<%@ include file="components/nav.jsp" %>
		</div>
	</div>

<%@ include file="components/footer.jsp" %>
</body>
</html>