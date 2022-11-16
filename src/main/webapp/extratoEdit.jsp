<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Edição</title>
	<%@ include file="components/header.jsp" %>
    
  </head>
  <body>
    <div class="container-fluid h-100">
      <div class="row second-bg h-100">
        <div class="container-conta ps-4 pe-4">
          <div class="alinhamento d-flex justify-content-between ps-2 pe-2 mt-3">
            <a href="extrato?acao=listar"><img class="nav-img-size" src="./resources/img/account/return.svg"></a>
            <h1 id="receitaMsg" class="fs-21 txt-white pe-2">Editar Despesa</h1>
          </div>
  
          <div class="alinhamento">
            <div class="card mt-5">
              <form action="extrato" method="post" class="ps-3 pe-3 pb-2">
              	<input type="hidden" value="editar" name="acao">
              	<input type="hidden" value="${lancamento.codigo}" name="codigoLancamento">
                <div class="text-center p-2">
                  <p class="txt-purple  mt-3 mb-1">VALOR</h1>
                  <input name="valor" id="valor "type="text" class="fs-21 fw-bold form-control text-center" value="${lancamento.valor }"></input>
                </div>

                <div class="btn-group d-flex p-2" role="group" aria-label="Basic radio toggle button group">
                  <input type="radio" class="btn-check" name="btnradio" id="btnradio1" value="Débito" autocomplete="off" checked>
                  <label class="btn btn-outline-primary" for="btnradio1">Despesa</label>
                
                  <input type="radio" class="btn-check" name="btnradio" id="btnradio2" value="Crédito" autocomplete="off">
                  <label class="btn btn-outline-primary" for="btnradio2">Receita</label>
              
                </div>

                <div class="d-flex p-2">
                  <img src="./resources/img/newData/Calendário.svg" class="me-3">
                  <input placeholder="dd/mm/aaaa" class="textbox-n form-control" type="text" id="date" name="date" value='<fmt:formatDate value="${lancamento.data.time }" pattern="dd/MM/yyyy"/>'>
                </div>

                <div class="d-flex p-2">
                  <img src="./resources/img/newData/Group 3.svg" class="me-3">
                  <input id="descricao" name="descricao" class="form-control" type="text" placeholder="Descrição" value="${lancamento.descricao }">
                </div>

                <div class="d-flex p-2">
                  <img src="./resources/img/newData/etiqueta.svg" class="me-3">
                  <select id="selectCategoria" name="categoria" class="form-select" aria-label="Default select example">
                  	<c:forEach items="${listaCategoria }" var="categoria">
                  		<option value="${categoria.codigo }">${categoria.nome }</option>
                  	</c:forEach>
                  </select>
                </div>

                <div class="d-flex p-2">
                  <img src="./resources/img/newData/carteira.svg" class="me-3">
                  <!-- <input id="conta" class="form-control" type="text" placeholder="Conta"> -->
                  <select id="lista" name="select" class="form-select" aria-label="Default select example">
                  	<c:forEach items="${lista }" var="lista">
                  		<option value="${lista.codigo }">${lista.nome }</option>
                  	</c:forEach>
                  </select>
                </div>


                <div class="d-grid gap-2">
                  <button type="submit" id="botao-cria-receita" class="btn btn-primary my-3 mx-2">Salvar</button>
                </div>
                
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>

	<%@ include file="components/nav.jsp" %>
  
	<%@ include file="components/footer.jsp" %>
	<script type="text/javascript" src="./resources/js/extratoEdit.js"></script>
  </body>
</html>