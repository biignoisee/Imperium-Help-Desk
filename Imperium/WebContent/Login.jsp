<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login - HelpDesk Imperium Center</title>
<link rel="icon" type="image/x-icon" href="Imagenes-icon/favicon.png">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<main>
	<div class="container">
		<section
			class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
		<div class="container">
			<div class="row justify-content-center">
				<div
					class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">
					<!-- Trabajar con el logo del negocio -->
					<div class="d-flex justify-content-center py-4">
						<a href="index.html" class="logo d-flex align-items-center w-auto">
							<img src="Imagenes-icon/favicon.png" alt="" style="width: 50px;">
						</a>
					</div>
					<!-- fin logo -->
					<div class="card mb-3">
						<div class="card-body">
							<div class="pt-4 pb-2">
								<h5 class="card-title text-center pb-0 fs-4">Iniciar Sesion
									en su cuenta</h5>
								<p class="text-center small">Ingrese su nombre de Usuario y
									Contraseña</p>
							</div>
							<form action="ControladorLogin" method="post"
								class="row g-3 needs-validation" novalidate>
								<!-- Input usuario -->
								<div class="col-12">
									<label for="yourUsername" class="form-label">Usuario</label>
									<div class="input-group has-validation">
										<span class="input-group-text">!</span> <input type="text"
											name="usuario" class="form-control" required>
										<div class="invalid-feedback">Ingrese su nombre de
											usuario!</div>
									</div>
								</div>
								<!-- Input contraseña -->
								<div class="col-12 mb-3">
									<label for="yourPassword" class="form-label">Contraseña</label>
									<input type="password" name="password" class="form-control"
										required>
									<div class="invalid-feedback">Ingrese su contraseña</div>
								</div>
								<!-- Boton de login -->
								<div class="col-12">
									<button class="btn btn-primary w-100" type="submit">Iniciar
										Sesión</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		</section>
	</div>
	</main>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

</body>
</html>