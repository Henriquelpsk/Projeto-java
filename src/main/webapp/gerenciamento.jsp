<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<%@ include file="components/header.jsp" %>
	<title>Gerenciamento</title>
</head>

<body>
	<div class="container-fluid h-100">
		<div class="row second-bg h-100">
			<div class="container-conta ps-4 pe-4">
				<div class="alinhamento d-flex justify-content-between ps-2 pe-2 mt-3">
					<a href="dashboard"><img class="nav-img-size" src="./resources/img/account/return.svg"></a>
					<h1 class="fs-21 txt-white pe-2">Gerenciamento</h1>
				</div>
					
						<div class="alinhamento">
							<div class="card mt-5">

								<div class="table-responsive">
									<table class="table">
										<div class="nome-tabela align-middle">
											<p class="mt-2">Contas</p>
										</div>
										<tr class="table-primary align-middle">
											<th class="tabela-gerenciamento">Nome</th>
											<th class="tabela-gerenciamento">Numero</th>
											<th class="tabela-gerenciamento">Opções</th>
										</tr>
										
										<c:forEach items="${listaConta }" var="conta">
											<tr class="align-middle">
												<td class="tabela-gerenciamento">${conta.nome }</td>
												<td class="tabela-gerenciamento">${conta.conta }</td>
												<td class="pe-0 tabela-gerenciamento">
													<c:url value="conta" var="link">
														<c:param name="acao" value="abrir-edicao-conta"/>
														<c:param name="codigo" value="${conta.codigo }"/>
													</c:url>
													<a class="btn btn-primary btn-edicao mb-1 text-white" href="${link }">Editar</a>
													<button class="btn btn-danger btn-edicao mb-1" data-bs-toggle="modal" data-bs-target="#excluirModal" onclick="codigoExcluir.value = ${conta.codigo}">excluir</button>
												</td>
											</tr>
										</c:forEach>
									</table>
								</div>

								<div class="table-responsive">
									<table class="table">
										<div class="nome-tabela align-middle">
											<p class="mt-2">Cartões de crédito</p>
										</div>
										<tr class="table-primary align-middle">
											<th class="tabela-gerenciamento">Nome</th>
											<th class="tabela-gerenciamento">Numero</th>
											<th class="tabela-gerenciamento">Opções</th>
										</tr>
										<c:forEach items="${listaCartao }" var="cartao">
										<tr class="align-middle">
											<td class="tabela-gerenciamento">${cartao.nome }</td>
											<td class="tabela-gerenciamento">
												<fmt:formatNumber type="number" pattern="**** **** **** ####" maxIntegerDigits="4" value="${cartao.numero }"/>
											</td>
											<td class="pe-0 tabela-gerenciamento">
												<c:url value="cartao" var="link">
														<c:param name="acao" value="abrir-edicao-cartao"/>
														<c:param name="codigo" value="${cartao.codigo }"/>
													</c:url>
													<a class="btn btn-primary btn-edicao mb-1 text-white" href="${link }">Editar</a>
												<button class="btn btn-danger btn-edicao mb-1" data-bs-toggle="modal" data-bs-target="#excluirModal2" onclick="codigoExcluir2.value = ${cartao.codigo}">excluir</button>
											</td>
										</tr>
										</c:forEach>
									</table>
								</div>
								
								<div class="table-responsive">
									<table class="table">
										<div class="nome-tabela align-middle">
											<p class="mt-2">Categorias</p>
										</div>
										<tr class="table-primary align-middle">
											<th class="tabela-gerenciamento">Nome</th>
											<th class="tabela-gerenciamento"></th>
											<th class="tabela-gerenciamento">Opções</th>
										</tr>
											
											<c:forEach items="${listaCategoria }" var="categoria">
												<tr class="align-middle">
													<td class="tabela-gerenciamento">${categoria.nome }</td>
													<td class="tabela-gerenciamento"></td>
													<td class="pe-0 tabela-gerenciamento">
														<c:url value="categoria" var="link">
														<c:param name="acao" value="abrir-edicao-categoria"/>
														<c:param name="codigo" value="${categoria.codigo }"/>
													</c:url>
													<a class="btn btn-primary btn-edicao mb-1 text-white" href="${link }">Editar</a>
													<button class="btn btn-danger btn-edicao mb-1" data-bs-toggle="modal" data-bs-target="#excluirModal3" onclick="codigoExcluir3.value = ${categoria.codigo}">excluir</button>
													</td>
												</tr>
											</c:forEach>								
									</table>
								</div>
								<div class="espacamento"></div>
							</div>
						</div>

				</div>
			</div>
		</div>

<%@ include file="components/nav.jsp" %>


<%@ include file="components/footer.jsp" %>>

<div class="modal fade" id="excluirModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        		Deseja realmente excluir a conta? <br> Todos os lançamentos ligados à conta também serão removidos!
      </div>
      <div class="modal-footer">
      	<form action="conta" method="post">
      		<input type="hidden" name="acao" value="excluir">
      		<input type="hidden" name="codigoConta" id="codigoExcluir">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
	        <button type="submit" class="btn btn-danger">Excluir</button>
        </form>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="excluirModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        		Deseja realmente excluir o cartão? <br> Todos os lançamentos ligados ao cartão também serão removidos!
      </div>
      <div class="modal-footer">
      	<form action="cartao" method="post">
      		<input type="hidden" name="acao" value="excluir">
      		<input type="hidden" name="codigoCartao" id="codigoExcluir2">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
	        <button type="submit" class="btn btn-danger">Excluir</button>
        </form>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="excluirModal3" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        		Deseja realmente excluir a categoria? <br> Todos os lançamentos ligados a categoria ficarão nulos!
      </div>
      <div class="modal-footer">
      	<form action="categoria" method="post">
      		<input type="hidden" name="acao" value="excluir">
      		<input type="hidden" name="codigoCategoria" id="codigoExcluir3">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
	        <button type="submit" class="btn btn-danger">Excluir</button>
        </form>
      </div>
    </div>
  </div>
</div>

</body>

</html>