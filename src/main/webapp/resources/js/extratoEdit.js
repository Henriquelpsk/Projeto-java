const receitaMsg = document.getElementById("receitaMsg");
const btnRadio1 = document.getElementById("btnradio1");
const btnRadio2 = document.getElementById("btnradio2");


btnRadio1.addEventListener("click", e => {
	receitaMsg.innerHTML = "Editar Despesa"
});

btnRadio2.addEventListener("click", e => {
	receitaMsg.innerHTML = "Editar Receita"
})