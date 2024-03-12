<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
	<meta content="width=device-width, initial-scale=1.0" name="viewport">
	<title>Registrar Usuario - Imperium HelpDesk</title>
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
  
  <div id="main" class="main bg-light mt-2 pl-5 pr-5">
  	<div class="container-fluid mt-5 mb-5 pt-3 pb-3 pl-4 pr-4 bg-white">
		<a href="ControladorUsuario?accion=listar" class="btn btn-danger text-white p-2 text-decoration-none" style="cursor:pointer;"><i class="fa-solid fa-rotate-left"></i> Volver al Lista Usuario</a>
		<h1 class="mt-3">Registrar Usuario</h1>
		<p>Desde esta ventana podrá generar nuevos Usuario</p>
		
		
		<form action="ControladorUsuario" class="row" method="POST">

		  <div class="form-group col-sm-6">
		    <label for="titulo">Nombre</label>
		    <input type="text" class="form-control" id="nombre" name="nombre" required>
		  </div>
		  
		  <div class="form-group col-sm-6">
		    <label for="titulo">Usuario</label>
		    <input type="text" class="form-control" id="username" name="username" required>
		  </div>
		  
		  <div class="form-group col-sm-6">
		    <label for="titulo">Apellido Paterno</label>
		    <input type="text" class="form-control" id="apellido_paterno" name="apellido_paterno" required>
		  </div>
		  
		  <div class="form-group col-sm-6">
		    <label for="titulo">Apellido Materno</label>
		    <input type="text" class="form-control" id="apellido_materno" name="apellido_materno" required>
		  </div>
		  
		  <div class="form-group col-sm-4">
		    <label for="titulo">DNI</label>
		    <input type="text" class="form-control" id="dni" name="dni" required>
		  </div>
		  
		  <div class="form-group col-sm-4">
		    <label for="titulo">Contraseña</label>
		    <input type="text" class="form-control" id="password" name="password" required>
		  </div>
		  		  
		  <div class="form-group col-sm-4">
		    <label for="titulo">Rol ID</label>
		    <input type="text" class="form-control" id="role_id" name="role_id" required>
		  </div>
		  
		  <button type="submit" class="btn btn-primary col-sm-4 ml-3"  name="accion" value="registrar"><i class="fa-solid fa-floppy-disk"></i> Registrar Usuario</button>
		</form>
	</div>
  </div>
  <!-- Archivos JS -->
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.6.1.slim.js" integrity="sha256-tXm+sa1uzsbFnbXt8GJqsgi2Tw+m4BLGDof6eUPjbtk=" crossorigin="anonymous"></script>
  <script src="assets/js/menu.js"></script>
  <!-- End Archivos JS -->
</body>
</html>
