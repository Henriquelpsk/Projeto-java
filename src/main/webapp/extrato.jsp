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
	<title>Extrato</title>
</head>

<body>
	<div class="container-fluid h-100">
		<div class="row second-bg h-100">
			<div class="container-conta ps-4 pe-4">
				<div class="alinhamento d-flex justify-content-between ps-2 pe-2 mt-3">
					<a href="dashboard"><img class="nav-img-size" src="./resources/img/account/return.svg"></a>
					<h1 class="fs-21 txt-white pe-2">Extrato</h1>
				</div>
				<div class="alinhamento">
					<div class="card mt-5">
						<div class="table-responsive-sm">
							<table class="table">
								<tr class="table-primary align-middle">
									<th class="th-extrato">Descrição</th>
									<th class="th-extrato">Valor</th>
									<th class="th-extrato">Data</th>
									<th class="th-extrato">Categoria</th>
									<th class="th-extrato">Opções</th>
								</tr>
								
								<c:forEach items="${listaLancamento }" var="lancamento">							
									<tr class="align-middle">
										<td>${lancamento.descricao }</td>
										<c:if test="${lancamento.tipo == 'Débito' }">
											<td class="txt-red">
												<fmt:formatNumber value="${lancamento.valor }" type="currency" />
											</td>
										</c:if>
										<c:if test="${lancamento.tipo == 'Crédito' }">
											<td class="txt-green">
												<fmt:formatNumber value="${lancamento.valor }" type="currency" />
											</td>
										</c:if>
										<td>
											<fmt:formatDate value="${lancamento.data.time }" pattern="dd/MM/yyyy"/>
										</td>
										<td>${lancamento.categoria }</td>
										<td class="pe-0">
										<c:url value="extrato" var="link">
												<c:param name="acao" value="abrir-form-edicao"/>
												<c:param name="codigo" value="${lancamento.codigo }"/>
												<c:param name="tipo" value="conta"/>
											</c:url>
											<a class="btn btn-primary btn-edicao mb-1 text-white" href="${link }">Editar</a>
											<button class="btn btn-danger btn-edicao mb-1" data-bs-toggle="modal" data-bs-target="#excluirModal" onclick="codigoExcluir.value = ${lancamento.codigo}">excluir</button>
										</td>
									</tr>
								</c:forEach>
								
								<c:forEach items="${listaLancamentoCartao }" var="lancamentoCartao">							
									<tr class="align-middle">
										<td>${lancamentoCartao.descricao }</td>
										<c:if test="${lancamentoCartao.tipo == 'Débito' }">
											<td class="txt-red">
												<fmt:formatNumber value="${lancamentoCartao.valor }" type="currency" />
											</td>
										</c:if>
										<c:if test="${lancamentoCartao.tipo == 'Crédito' }">
											<td class="txt-green">
												<fmt:formatNumber value="${lancamentoCartao.valor }" type="currency" />
											</td>
										</c:if>
										<td>
											<fmt:formatDate value="${lancamentoCartao.data.time }" pattern="dd/MM/yyyy"/>
										</td>
										<td>${lancamentoCartao.categoria }</td>
										<td class="pe-0">
											<c:url value="extrato" var="link">
												<c:param name="acao" value="abrir-form-edicao"/>
												<c:param name="codigo" value="${lancamentoCartao.codigo }"/>
												<c:param name="tipo" value="cartao"/>
											</c:url>
											<a class="btn btn-primary btn-edicao mb-1 text-white" href="${link }">Editar</a>
											<button class="btn btn-danger btn-edicao mb-1" data-bs-toggle="modal" data-bs-target="#excluirModal" onclick="codigoExcluir.value = ${lancamentoCartao.codigo}">excluir</button>
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

<%@ include file="components/footer.jsp" %>

<!-- Modal -->
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
        		Deseja realmente excluir o lancamento?
      </div>
      <div class="modal-footer">
      	<form action="extrato" method="post">
      		<input type="hidden" name="acao" value="excluir">
      		<input type="hidden" name="codigo" id="codigoExcluir">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
	        <button type="submit" class="btn btn-danger">Excluir</button>
        </form>
      </div>
    </div>
  </div>
</div>
</body>
</html>