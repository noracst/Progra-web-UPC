<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<title>Spot Music</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Spot Music</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="panele.jsp">Home</a></li>
				<li><a href="listg">Generos</a></li>
				<li><a href="listc">Canciones</a></li>

			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<h3>EDITAR CANCION</h3>
		</div>
		<div class="row">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li class="active"><a href="panelc.html" data-toggle="tab">Canciones</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<h3>Editar Canciones</h3>
		</div>


		<div class="row">
			<form class="form-horizontal" action="updatec" method="post">

				<div class="control-group">
					<label class="control-label">CODIGO</label>
					<div class="controls">
						<input type="text" name="cod_cancion" id="cod_cancion"
							value="${requestScope.cancion.cod_cancion}" readonly />
					</div>
				</div>


				<div class="control-group">
					<label class="control-label">NOMBRE</label>
					<div class="controls">
						<input type="text" name="nombre_cancion" id="nombre_cancion"
							placeholder="Ingresar nombre"
							value="${requestScope.cancion.nombre_cancion}" /> 
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label">PRECIO</label>
					<div class="controls">
						<input type="text" name="precio_cancion" id="precio_cancion"
							placeholder="Ingresar precio"
							value="${requestScope.cancion.precio_cancion}" /> 
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label">DURACION</label>
					<div class="controls">
						<input type="text" name="duracion_cancion" id="duracion_cancion"
							placeholder="Ingresar duracion"
							value="${requestScope.cancion.duracion_cancion}" /> 
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label">GENERO</label>
					<div class="controls">
						<input type="text" name="gen" id="gen"
							placeholder="Ingresar genero"
							value="${requestScope.cancion.gen.cod_genero}" /> 
					</div>
				</div>

				<div class="form-actions">
					<button type="submit" class="btn btn-success">Actualizar</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="btn" href="listc">Cancelar</a>
				</div>
			</form>
		</div>
	</div>

</body>
</html>
