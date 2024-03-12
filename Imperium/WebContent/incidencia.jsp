<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
	<meta content="width=device-width, initial-scale=1.0" name="viewport">
	<title>Detalle Incidencia - Imperium HelpDesk</title>
	 <!-- ======= Head Include ======= -->
     <jsp:include page="assets/partials/head.jsp" />    
     <!-- ======= End Head Include ======= -->
</head>
<body class="bg-light">
  <!-- ======= Header Include ======= -->
  <jsp:include page="assets/partials/header.jsp" />    
  <!-- ======= End Header Include ======= -->
  
  <!-- ======= Sidebar ======= -->
  <jsp:include page="assets/partials/sidebar.jsp" />  
  <!-- ======= End Sidebar ======= -->
        
  <div id="main" class="main bg-light pl-5 pr-5">
		<div class="container mt-1 mb-1 pt-3 pb-3 pl-4 pr-4 bg-white">
			<a href="incidencias?accion=r" class="btn btn-danger text-white p-2 text-decoration-none" style="cursor:pointer;"><i class="fa-solid fa-rotate-left"></i> Volver al listado</a>
			<h1 class="mt-3">Detalle Incidencia</h1>
			<div class="row">
				<div class="col-12 mb-3 p-3" style="border-bottom:2px solid #eee">
					<i class="fa-solid fa-user text-primary"></i>
					<span>
						<c:out value="${(incidencia.nombreSoporte == null) ?'Sin Asignar' :incidencia.nombreSoporte}"></c:out>
					</span>
				</div>
				<div class="col-12">
					<div class="row">
						<div class="col-2">
							<p><fmt:formatDate value="${incidencia.fechaRegistro}" pattern="dd/MM/yyyy"/></p>
						</div>
						<div class="col-10">
							<p><c:out value="${incidencia.titulo}"></c:out></p>
							<p><c:out value="${incidencia.descripcion}"></c:out></p>
							<div>
								<strong>Documentos Adicionales</strong>
								<c:choose>
				  					<c:when test="${documentos == null}">
				  						<p>No existen documentos registrados</p>
				  					</c:when>
				  					<c:otherwise>
										<table class="table table-striped border mt-1">
											<thead>
												<tr>
													<th scope="col">Nombre</th>
													<th scope="col">Opcion</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="documento" items="${documentos}">
													<tr>
														<td><c:out value="${documento}"></c:out></td>
														<td><a href="${pageContext.request.contextPath}/documentos/${documento}" class="bg-primary rounded text-white pr-3 pl-3 pt-1 pb-1 text-decoration-none" target="_blank">Ver</a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>									
				  					</c:otherwise>
			  					</c:choose>
							</div>
							<div>
								<strong>Imágenes Adicionales</strong>
								<c:choose>
				  					<c:when test="${imagenes == null}">
										<p>No existen imágenes registradas</p>
				  					</c:when>
				  					<c:otherwise>
										<table class="table table-striped border mt-1">
											<thead>
												<tr>
													<th scope="col">Nombre</th>
													<th scope="col">Opcion</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="imagen" items="${imagenes}">
													<tr>
														<td><c:out value="${imagen}"></c:out></td>
														<td><a href="${pageContext.request.contextPath}/imagenes/${imagen}" class="bg-primary rounded text-white pr-3 pl-3 pt-1 pb-1 text-decoration-none" target="_blank">Ver</a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>									
				  					</c:otherwise>
			  					</c:choose>
							</div>
						</div>
					</div>
				</div>
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