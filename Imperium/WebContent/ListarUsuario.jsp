<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
	<meta content="width=device-width, initial-scale=1.0" name="viewport">
	<title>Listar Usuarios - Imperium HelpDesk</title>
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
		<h2 class="mb-3 mt-3">Listado de Usuarios</h2>
		<div class="table-responsive">
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th scope="col">Código</th>
			      <th scope="col">Nombre</th>
			      <th scope="col">Apellido Paterno</th>
			      <th scope="col">Apellido Materno</th>
			      <th scope="col">DNI</th>
			      <th scope="col">Username</th>
			      <th scope="col">ID Rol</th>
			      <th scope="col">Estado</th>
			      <th scope="col">Eliminar</th>
			      <th scope="col">Editar</th>
			    </tr>
			  </thead>
			  <tbody>	
			  	<c:forEach var="usuario" items="${listadousuarios}">
			  		<tr>
			  			<td><c:out value = "${usuario.id}"></c:out></td>
						<td><c:out value = "${usuario.nombre}"></c:out></td>
						<td><c:out value = "${usuario.apellido_paterno}"></c:out></td>
						<td><c:out value = "${usuario.apellido_materno}"></c:out></td>
						<td><c:out value = "${usuario.dni}"></c:out></td>
						<td><c:out value = "${usuario.username}"></c:out></td>
						<td><c:out value = "${usuario.role_id}"></c:out></td>
						<td><c:out value = "${usuario.estado}"></c:out></td>
						<td><a href = "ControladorUsuario?accion=eliminar&id=${usuario.id}"><i class="fa-solid fa-trash p-2 bg-danger text-white rounded"></i></a></td>
						<td><a href = "ControladorUsuario?accion=actualizar&id=${usuario.id}"><i class="fa-solid fa-pen-to-square p-2 bg-warning text-white rounded"></i></a></td>
			  		</tr>	
			  	</c:forEach>
			  </tbody>
			</table>
			<a href="RegistrarUsuario.jsp" class="btn btn-primary text-white p-2 text-decoration-none" style="cursor:pointer;"><i class="fa-solid fa-plus"></i> Crear usuario</a>
		</div>
	</div> 
  </div>
  <!-- Archivos JS -->
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.6.1.slim.js" integrity="sha256-tXm+sa1uzsbFnbXt8GJqsgi2Tw+m4BLGDof6eUPjbtk=" crossorigin="anonymous"></script>
  <script src="assets/js/menu.js"></script>
  <!-- End Archivos JS -->
</body>
</html>