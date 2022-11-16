const botaoGerenciar = document.getElementById("botao-gerenciar");
const botaoCadastro = document.getElementById("botao-cadastro");
const botaoCartao = document.getElementById("botao-cartao");
const botaoEditor = document.getElementById("botao-categoria");

botaoGerenciar.onclick = function () {
	location.href = "account.html";
};

botaoCadastro.onclick = function () {
	location.href = "newData.html";
};

botaoCartao.onclick = function(){
	location.href = "creditCard.html";
};

botaoEditor.onclick = function(){
	location.href = "category.html";
};