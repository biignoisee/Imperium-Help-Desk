$(document).ready(function() {
	$("#categoria").on("change", function() {
		readSubcategoriasByIdCategoria();
	})
});
	
function readSubcategoriasByIdCategoria(){
	let valorCategoria = $("#categoria").val();
	
	$.ajax({
		url:"subcategorias",
		type:"GET",
		data:"accion=r&categoriaId=" + valorCategoria,
		success: function(data) {
			$("#subcategoria").empty();
			$('#subcategoria').append('<option selected disabled value="">--Seleccione--</option>');
			
			data.forEach(function(el) {
				$('#subcategoria').append($('<option>', {
					value: el.id,
					text: el.nombre
				}));
			});
		},
		error: function(request, status, error) {
			alert(error);
		}
	});
}