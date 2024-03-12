
<body>
	<h1 align ="center">Formulario Actualizar SubCategoria</h1>
	
	<form action="ControladorSubCategoria" method="POST">
		<!-- recuperamos el codigo con un input text oculto -->
	
		<input type="hidden" name="id" value="<core:out value="${id}"/>">
	
	
		<table align="center">
			<tr>
				<td>Categoria ID</td><td><input type="text" name="categoria_id"
			value="<core:out value="${categoria_id}"/>"
				></td>
			</tr>
		
			<tr>
				<td>Nombre</td><td><input type="text" name="nombre"
				value="<core:out value="${nombre}"/>"
				></td>
			</tr>
		
			<tr>
				<td>Estado</td><td><input type="text" name="estado"
				value="<core:out value="${estado}"/>"
				></td>
			</tr>
		
			<tr>
				<td colspan="2"><input type="submit" value="Actualizar SubCategoria"></td>
			</tr>
		</table>
		
	</form>
	<a href="ControladorSubCategoria?accion=listar">Volver a Listado</a>	
</body>
</html>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
	<meta content="width=device-width, initial-scale=1.0" name="viewport">
	<title>Actualizar SubCategoria - Imperium HelpDesk</title>
	    <!-- Vendor CSS Files Bootstrap-->
	<link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
	<link href="assets/css/style.css" rel="stylesheet">
	<link rel="icon" type="image/x-icon" href="Imagenes-icon/favicon.png">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> 
</head>
<body>

	<!-- ======= Hacemos uso de icono con la entrada bi y no fas fa-icon 
debido a que estamos haciendo uso de vendors de boostrap y su logica dice que debemos llamar
cada icono con esa nomenclatura ======= -->

  <!-- ======= Header ======= -->
  <header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
      <a href="Lobby.jsp" class="logo d-flex align-items-center">
        <img src="Imagenes-icon/favicon.png" alt="">
        <span class="d-none d-lg-block" style="font-size:20px">Imperium HelpDesk</span>
      </a>
      <!-- Boton de menu desplegable -->
      <i class="bi bi-list toggle-sidebar-btn" id="btnMenu"></i>
    </div><!-- End Logo -->

    <nav class="header-nav ms-auto">
      <ul class="d-flex align-items-center">
      
      <!-- Apartado Profile -->
        <li class="nav-item dropdown pe-3">

          <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
            <i class="bi bi-person-fill"></i>
            <span class="d-none d-md-block dropdown-toggle ps-2" style="font-size:15px">Usuario</span>
          </a><!-- Fin desplegable usuario -->

		

          <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
            <li class="dropdown-header">
            <!-- Como vamos a manejar sesiones, me preguntaba si el nombr del usuario que ingresa 
			se retornara aca? -->
              <h6>Usuario #14355</h6>
              <span>Ingeniero Java</span>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>
            <li>
              <a class="dropdown-item d-flex align-items-center" href="Login.jsp">
                <i class="bi bi-box-arrow-right"></i>
                <span> Cerrar sesión </span>
              </a>
            </li>

          </ul>
        </li> <!-- Fin del apartado Profile -->
      </ul>
    </nav>

  </header>
  <!-- Fin Header -->


  <!-- ======= Sidebar ======= -->
  <aside id="sidebar" class="sidebar menuConfiguracion">

	<!-- ======= Listamos cada punto ======= -->
    <ul class="sidebar-nav" id="sidebar-nav">

      <li class="nav-item">
        <a class="nav-link" href="Lobby.jsp">
          <i class="bi bi-grid"></i>
          <span>Dashboard</span>
        </a>
      </li>

      <li class="nav-item">
        <a class="nav-link collapsed" href="ControladorUsuario?accion=listar"
		style="text-decoration: none">
          <i class="bi bi-person"></i>
          <span>Usuarios</span>
        </a>
      </li>

      <li class="nav-item">
        <a class="nav-link collapsed" href="ControladorPrioridades?accion=listar">
          <i class="bi bi-flag"></i>
          <span>Prioridades</span>
        </a>
      </li>

      <li class="nav-item">
        <a class="nav-link collapsed" href="ControladorCategoria?accion=listar">
          <i class="bi bi-arrow-up-right-square-fill"></i>
          <span>Categorias</span>
        </a>
      </li>

      <li class="nav-item">
        <a class="nav-link collapsed" href="ControladorSubCategoria?accion=listar">
          <i class="bi bi-arrow-up-right-square"></i>
          <span>Subcategorias</span>
        </a>
      </li>

      <li class="nav-item">
        <a class="nav-link collapsed" href="incidencias?accion=r">
          <i class="bi bi-award-fill"></i>
          <span>Incidencias</span>
        </a>
      </li>

      <li class="nav-item">
        <a class="nav-link collapsed" href="incidencias?accion=c">
          <i class="bi bi-award"></i>
          <span>Crear Incidencias</span>
        </a>
      </li>

      <li class="nav-item">
        <a class="nav-link collapsed" href="Login.jsp" style="color:red;">
          <i class="bi bi-box-arrow-in-right" style="color:red;"></i>
          <span>Cerrar Sesión</span>
        </a>
      </li>

    </ul>

  </aside><!-- Fin Sidebar-->
    <!-- Se va a re usar todo el codigo de arriba, porque o sino lo haria como si fuera c# _layout
  pero no hay aca, asi que a copiar -->
  
  <main id="main" class="main bg-light mt-2 pl-5 pr-5">
  	<div class="container-fluid mt-5 mb-5 pt-3 pb-3 pl-4 pr-4 bg-white">
		<a href="ControladorSubCategoria?accion=listar" class="btn btn-danger text-white p-2 text-decoration-none" style="cursor:pointer;"><i class="bi bi-door-open-fill"></i> Volver al Lista SubCategoria</a>
		<h1 class="mt-3">Actualizar Categoria</h1>
		<p>Desde esta ventana podrá actualizar datos de la categoria</p>
		
		
		<form action="ControladorSubCategoria" class="row" method="get">
		<input type = "hidden" name = "id" value = "<c:out value = "${id}"/>">
		
		  <div class="form-group col-sm-4">
		    <label for="titulo">Id Categoria</label>
		    <input type = "text" class="form-control" name = "categoria_id" value = "<c:out value = "${categoria_id}"/>"/>
		  </div>
		
		  <div class="form-group col-sm-4">
		    <label for="titulo">Nombre</label>
		    <input type = "text" class="form-control" name = "nombre" value = "<c:out value = "${nombre}"/>"/>
		  </div>
		  
		  <div class="form-group col-sm-4">
		    <label for="titulo">Estado</label>
		    <input type = "text" class="form-control" name = "estado" value = "<c:out value = "${estado}"/>"/>
		  </div>

		  
		  <button type="submit" class="btn btn-primary col-sm-4 ml-3"  name="accion" value="Actualizar"><i class="fa-solid fa-floppy-disk"></i> Actualizar SubCategoria</button>
		</form>
	</div>
  
  </main>
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" 
integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<script>	
	var btnMenu = document.getElementById("btnMenu")
	var menuConfiguracion = document.querySelector(".menuConfiguracion")
	

	btnMenu.addEventListener('click',e =>{	
		menuConfiguracion.classList.toggle('menuConfiguracion')
	});
	
	if(menuConfiguracion.style.display=="none"){
		console.log("gaaa")
	}	
</script>
</body>
</html>



