function contaTitulo(){
	var titulo = document.getElementById('titulo').value;
	document.getElementById('contador-titulo').innerHTML = 50 - titulo.length + " caracteres restantes";
	};
function contaDescricao(){
	var titulo = document.getElementById('descricao').value;
	document.getElementById('contador-desc').innerHTML = 240 - titulo.length + " caracteres restantes";
};