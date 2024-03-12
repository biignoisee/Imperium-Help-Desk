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
	<title>Registrar Incidencia - Imperium HelpDesk</title>
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
		<a href="Lobby.jsp" class="btn btn-danger text-white p-2 text-decoration-none" style="cursor:pointer;"><i class="fa-solid fa-house"></i> Volver al Inicio</a>
		<h1 class="mt-3">Registrar Indidencias</h1>
		<p>Desde esta ventana podrá generar nuevas incidencias</p>
		<form action="incidencias" method="POST" enctype="multipart/form-data">
		  <div class="form-group">
		    <label for="titulo">Título</label>
		    <input type="text" class="form-control" id="titulo" name="titulo" required>
		  </div>
		  <div class="form-group row">
		  	<div class="col-6">
		  		<label for="categoria">Categoría</label>
		    	<select class="custom-select" id="categoria" required>
			      <option selected disabled value="">--Seleccione--</option>
			      <c:forEach var="categoria" items="${categorias}">
			      	<option value="${categoria.id}"><c:out value="${categoria.nombre}"></c:out></option>
			      </c:forEach>
			  	</select>
		  	</div>
		  	<div class="col-6">
		  		<label for="subcategoria">Subcategoria</label>
		    	<select class="custom-select" id="subcategoria" name="subcategoria" required>
			      <option selected disabled value="">--Seleccione--</option>
			    </select> 
		  	</div>
		  </div>
		  <div class="form-group row">
		  	<div class="col-6">
		  		<label for="prioridad">Prioridades</label>
		    	<select class="custom-select" id="prioridad" name="prioridad" required>
			      <option selected disabled value="">--Seleccione--</option>
			      <c:forEach var="prioridad" items="${prioridades}">
			      	<option value="${prioridad.id}"><c:out value="${prioridad.nombre}"></c:out></option>
			      </c:forEach>
			  	</select>
		  	</div>
		  	<div class="col-6">
		  		<label for="documentos">Documentos Adicionales</label>
		  		<input class="form-control" type="file" id="documentos" name="documentos" multiple accept=".pdf">
		  	</div>
		  </div>
		  <div class="form-group">
		    <label for="imagenes">Imágenes</label>
		    <input class="form-control" type="file" id="imagenes" name="imagenes" multiple accept=".jpg,.png,.jpge">
		  </div>
		  <div class="form-group">
		    <label for="descricpion">Descripción</label>
		    <textarea class="form-control" id="descricpion" name="descripcion" rows="10" required></textarea>
		  </div>
		  <button type="submit" class="btn btn-primary" name="accion" value="cp"><i class="fa-solid fa-floppy-disk"></i> Guardar</button>
		</form>
	</div>
  </div>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  <script src="assets/js/menu.js"></script>
  <script src="assets/js/incidencia.js"></script>
</body>
</html>