var dados = [];
var selecionado = null;

function envia() {
	
	var metodo = "POST";
	var p = { nome : $("#nome").val(), 
			  categoria : $("#categoria").val(),
			  habilidade : $("#habilidade").val(), 
			  altura : Number($("#altura").val()),
			  peso : Number($("#peso").val()),
			  evolucaoNome : $("#evolucaoNome").val(),
			  tipo : $("#tipo").val().split(","),
			  fraquezas : $("#fraquezas").val().split(","),
			};
	

		if (selecionado) {
			p.id = selecionado.id;
			metodo = "PUT";
		}
	
	$.ajax({ method : metodo, contentType : "application/json", url : "api/pokemon", data : JSON.stringify(p)})
	.done(carrega);
}

function carrega() {
	
	var pokeHtml = [];
	
	$.getJSON("api/pokemon", function(pokemons) {
		
		dados = pokemons;
		
		$.each(pokemons, function(i, p) {
			
			pokeHtml.push( "<tr> " +
						   "<td>" + p.id + "</td>" +
						   "<td>" + p.nome + "</td>" +
						   "<td>" + p.categoria + "</td>" +
						   "<td>" + p.habilidade + "</td>" +
						   "<td>" + p.altura + "</td>"  +
						   "<td>" + p.peso + "</td>" +
						   "<td>" + p.evolucaoNome + "</td>" +
						   "<td>" + p.tipo + "</td>" +
						   "<td>" + p.fraquezas + "</td>" );
			
			pokeHtml.push("<td><button onclick='seleciona(" + i + ")'>Editar</button></td>");
			pokeHtml.push("<td><button onclick='apagar(" + p.id + ")'>X</button></td>");
			pokeHtml.push("</tr>");
			
		});
		
		$("#tblPokemons").html(pokeHtml.join());
		
		limparSelecionado();
});
	
}

function apagar(id) {
	$.ajax({ method : "DELETE", contentType : "application/json", url : "api/pokemon/" + id
	}).done(carrega);
}

function seleciona(i) {
	selecionado = dados[i];
	$("#tituloForm").text("Editar")
	
	$("#nome").val(selecionado.nome);
	$("#categoria").val(selecionado.categoria);
	$("#habilidade").val(selecionado.habilidade);
	$("#altura").val(selecionado.altura);
	$("#peso").val(selecionado.peso);
	$("#evolucaoNome").val(selecionado.evolucaoNome);
	$("#tipo").val(selecionado.tipo);
	$("#fraquezas").val(selecionado.fraquezas);
}

function limparSelecionado() {
	selecionado = null;
	$("#campos input[type=text]").val("");
}

carrega();