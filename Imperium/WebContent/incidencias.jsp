<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.0/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.3.0/css/responsive.dataTables.min.css">
	<meta content="width=device-width, initial-scale=1.0" name="viewport">
	<title>Incidencias - Imperium HelpDesk</title>
	<!-- ======= Head Include ======= -->
	<jsp:include page="assets/partials/head.jsp" />    
	<!-- ======= End Head Include ======= -->
</head>
<body>
  <!-- ======= Header Include ======= -->
  <jsp:include page="assets/partials/header.jsp" />    
  <!-- ======= End Header Include ======= -->

  <!-- ======= Sidebar ======= -->
  <jsp:include page="assets/partials/sidebar.jsp" />  
  <!-- ======= End Sidebar ======= -->

  <div id="main" class="main bg-light pl-5 pr-5">
	<div class="container-fluid mt-0 p-3 bg-white">
		<c:if test="${param.mensaje != null}">
			<div class="alert alert-success alert-dismissible fade show" role="alert">
			  <c:out value="${param.mensaje}"></c:out>
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>			
		</c:if>
		<a href="Lobby.jsp" class="btn btn-danger text-white p-2 text-decoration-none" style="cursor:pointer;"><i class="fa-solid fa-house"></i> Volver al Inicio</a>
		<h2 class="mb-3 mt-3">Listado de Incidencias</h2>
		
		<!-- Formulario Filtros -->
		<form action="incidencias?accion=rf" method="POST">
			<div class="row">
				<div class="col-12 col-md-6">
					<div class="row">
						<div class="form-group col-12 col-md-6">
						    <label for="titulo">Categoría</label>
						    <select class="custom-select" id="categoria" name="categoria" required>
						      <option selected value="0">Escoge una opción</option>
						      <c:forEach var="categoria" items="${categorias}">
							      <c:choose>
				  					<c:when test="${categoriaId == categoria.id}">
				  						<option value="${categoria.id}" selected><c:out value="${categoria.nombre}"></c:out></option>
				  					</c:when>
				  					<c:otherwise>
				  						<option value="${categoria.id}"><c:out value="${categoria.nombre}"></c:out></option>
				  					</c:otherwise>
				  				  </c:choose>
						      </c:forEach>
						  	</select> 	
						</div>	
						<div class="form-group col-12 col-md-6">
						    <label for="titulo">Prioridad</label>
						    <select class="custom-select" id="prioridad" name="prioridad" required>
						      <option selected value="0">Escoge una opción</option>
						      <c:forEach var="prioridad" items="${prioridades}">
						      	<c:choose>
				  					<c:when test="${prioridadId == prioridad.id}">
				  						<option value="${prioridad.id}" selected><c:out value="${prioridad.nombre}"></c:out></option>
				  					</c:when>
				  					<c:otherwise>
				  						<option value="${prioridad.id}"><c:out value="${prioridad.nombre}"></c:out></option>
				  					</c:otherwise>
				  				</c:choose>
						      </c:forEach>
						  	</select> 	
						</div>									
					</div>
				</div>
				<div class="col-12 col-md-6 d-flex justify-content-center align-items-center">
					<div class="row justify-content-center justify-content-md-end w-100 mt-3">
						<button type="submit" class="btn btn-primary col-12 col-md-4 rounded mr-2 mb-2 mb-md-0"><i class="fa-solid fa-filter"></i> Filtrar</button>
					    <a href="incidencias?accion=r" class="btn btn-primary col-12 col-md-4 rounded mr-2"><i class="fa-solid fa-globe"></i> Ver Todo</a> 									
					</div>
				</div>
			</div>
		</form>
		<!-- Final Formulario Filtros -->
		
		<!-- Tabla incidencias -->
		<div class="table-responsive">
			<table class="table table-striped mt-4" id="incidencias">
			  <thead>
			    <tr>
			      <th scope="col">Id</th>
			      <th scope="col">Categoría</th>
			      <th scope="col">Título</th>
			      <th scope="col">Prioridad</th>
			      <th scope="col">Estado</th>
			      <th scope="col">Fecha Creación</th>
			      <th scope="col">Fecha Asignación</th>
			      <th scope="col">Fecha Cierre</th>
			      <th scope="col">Soporte</th>
			      <th scope="col">Ver</th>
			      <th scope="col">Editar</th>
			    </tr>
			  </thead>
			  <tbody>	
			  	<c:forEach var="incidencia" items="${incidencias}">
			  		<tr>
			  			<td><c:out value="${incidencia.id}"></c:out></td>
			  			<td><c:out value="${incidencia.categoria}"></c:out></td>
			  			<td><c:out value="${incidencia.titulo}"></c:out></td>
			  			<td><c:out value="${incidencia.prioridad}"></c:out></td>
			  			<td>
			  				<c:choose>
			  					<c:when test="${incidencia.fechaCierre == null}">
			  						<p class="bg-success pl-3 pr-3 pt-1 pb-1 text-light rounded text-center">Abierto</p>
			  					</c:when>
			  					<c:otherwise>
			  						<p class="bg-danger pl-3 pr-3 pt-1 pb-1 text-light rounded text-center">Cerrado</p>
			  					</c:otherwise>
			  				</c:choose>
			  			</td>
			  			<td><fmt:formatDate value="${incidencia.fechaCreacion}" pattern="dd/MM/yyyy"/></td>	
			  			<td>
			  				<c:choose>
			  					<c:when test="${incidencia.fechaAsignacion == null}">
			  						<p class="bg-secondary pl-3 pr-3 pt-1 pb-1 text-light rounded text-center">Sin Asignar</p>
			  					</c:when>
			  					<c:otherwise>
			  						<fmt:formatDate value="${incidencia.fechaAsignacion}" pattern="dd/MM/yyyy"/>
			  					</c:otherwise>
			  				</c:choose>
			  			</td>
			  			<td>
			  				<c:choose>
			  					<c:when test="${incidencia.fechaCierre == null}">
			  						<p class="bg-secondary pl-3 pr-3 pt-1 pb-1 text-light rounded text-center">Sin Cerrar</p>
			  					</c:when>
			  					<c:otherwise>
			  						<fmt:formatDate value="${incidencia.fechaCierre}" pattern="dd/MM/yyyy"/>
			  					</c:otherwise>
			  				</c:choose>
			  			</td>
			  			<td>
			  				<c:choose>
			  					<c:when test="${incidencia.fechaAsignacion == null}">
			  						<p class="bg-warning pl-3 pr-3 pt-1 pb-1 text-light rounded text-center">Sin Asignar</p>
			  					</c:when>
			  					<c:otherwise>
			  						<p class="bg-secondary pl-3 pr-3 pt-1 pb-1 text-light rounded text-center">Asignado</p>
			  					</c:otherwise>
			  				</c:choose>
			  			</td>
			  			<td>
				  			<a href="incidencias?accion=ri&incidenciaId=${incidencia.id}">
				  				<i class="fa-solid fa-eye bg-primary text-light p-2 rounded" style="cursor:pointer;"></i>
				  			</a>
			  			</td>
			  			<td>
			  				<div class="btn-group" role="group">
							    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
							      <i class="fa-solid fa-pen-to-square"></i>
							    </button>
							    <div class="dropdown-menu">
							      <c:if test="${incidencia.fechaAsignacion == null}">
								      <a class="dropdown-item asignar-soporte" href="#" data-toggle="modal" data-target="#asignarSoporte" 
								      	id="${(incidencia.usuario != null) ?incidencia.usuario :0}" data-incidencia="${incidencia.id}">Asignar Soporte</a>							      
							      </c:if>
							      <form action="incidencias?accion=dui" method="POST">
							      	<input type="hidden" name="incidenciaId" value="${incidencia.id}">
							      	<a class="dropdown-item eliminar-soporte" href="#" data-toggle="modal" id="${(incidencia.usuario != null) ?incidencia.usuario :0}">Eliminar Soporte</a>
							      </form>
							      <a class="dropdown-item" href="#">Documentos</a>
							      <a class="dropdown-item" href="#">Imagenes</a>
							    </div>
							</div>
			  			</td>
			  		</tr>	
			  	</c:forEach>
			  </tbody>
			</table>
		</div>
		<!-- Final Tabla incidencias -->
		
		<!-- Modal Asignar Soporte -->
		<div class="modal fade" id="asignarSoporte" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Asignar Soporte</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		      	<form action="incidencias?accion=aui" method="POST" id="formAsignarSoporte">
		      		<table class="table table-striped display responsive nowrap" style="width:100%" id="soporte">
					  <thead class="thead-dark">
					    <tr>
					      <th scope="col">Elegir</th>
					      <th scope="col">Id</th>
					      <th scope="col">Nombre</th>
					      <th scope="col">Apellido Paterno</th>
					      <th scope="col">Apellido Materno</th>
					      <th scope="col">Incidencias Asignadas</th>
					    </tr>
					  </thead>
					  <tbody>
					  	<c:forEach var="usuarioSoporte" items="${usuariosSoporte}">
						    <tr>
						      <td class="text-center"><input type="radio" name="usuarioId" class="usuarioId" value="${usuarioSoporte.id}"></td>
						      <th><c:out value="${usuarioSoporte.id}"></c:out></th>
						      <td><c:out value="${usuarioSoporte.nombre}"></c:out></td>
						      <td><c:out value="${usuarioSoporte.apellidoPaterno}"></c:out></td>
						      <td><c:out value="${usuarioSoporte.apelidoMaterno}"></c:out></td>
						      <td><c:out value="${usuarioSoporte.cantidadIncidencias}"></c:out></td>
						    </tr>					  		
					  	</c:forEach>
					  </tbody>
					</table>
				    <div class="modal-footer">
				      <input type="hidden" name="incidenciaId" value="" id="incidenciaId">
				       <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
				       <button type="submit" class="btn btn-primary">Asignar</button>
				    </div>
		      	</form>
		    </div>
		  </div>
		</div>
	  </div>
	  <!-- Final Modal Asignar Soporte -->
	</div> 
  </div>
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
  <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js"></script>
  <script src="https://cdn.datatables.net/responsive/2.3.0/js/dataTables.responsive.min.js"></script>
  <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Archivos JS -->
  <script src="assets/js/menu.js"></script>
  <!-- End Archivos JS -->
  <script>
	$(document).ready(function() {
		$('#soporte').DataTable({
			"responsive": true,
		    "ordering": false,
			"language": {
		        "lengthMenu": "Mostrar _MENU_ registros por página",
		        "zeroRecords": "No se han encontado registros",
		        "info": "Mostrando la página _PAGE_ de _PAGES_",
		        "infoEmpty": "No hay registros disponibles",
		        "infoFiltered": "(filtrado de _MAX_ total registros totales)",
		        "search": "Buscar:",
		        "paginate": {
		            "next" : "Siguiente",
		            "previous" : "Anterior"
		        }
		    },
		});
		
		$(".eliminar-soporte").on("click", function(e) {
			let value = $(this).attr("id");
			console.log(value);
			let form = $(this).closest("form");
			
			if(value == 0) {
				Swal.fire({
					title: "Esta incidencia no tiene soporte asignado",
					confirmButtonColor: "#0275d8"
				});
			} else {
				Swal.fire({
					  title: '¿Estás seguro que quieres dejar sin asignar a la incidencia?',
					  icon: 'warning',
					  showCancelButton: true,
					  confirmButtonColor: '#0275d8',
					  cancelButtonColor: '#d33',
					  cancelButtonText: "Cancelar",
					  confirmButtonText: 'Sí, elimínalo'
				}).then(function(result) {
				  if (result.isConfirmed) {
					  form.submit();
				  }
				})
			}
		});
		
		$(".asignar-soporte").on("click", function() {
			let inputsUsuarios = Array.from(document.querySelectorAll(".usuarioId"));

			for(i = 0; i < inputsUsuarios.length; i++) {
				inputsUsuarios[i].checked = false;
			}
		
			let value = $(this).attr("data-incidencia");
			$("#incidenciaId").val(value);
		});
		
		$("#formAsignarSoporte").on("submit", function(e) {
			e.preventDefault();
			
			let value = $("input[name=usuarioId]:checked").val();
			
			if(value == undefined) {
				Swal.fire({
					title: "Debes seleccionar una opción",
					confirmButtonColor: "#0275d8"
				});
			} else {
				e.target.submit();	
			}
		});
	});
  </script>
</body>
</html>