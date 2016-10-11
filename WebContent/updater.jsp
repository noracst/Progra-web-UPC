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
				<li><a href="listr">Artistas</a></li>
				<li><a href="listc">Canciones</a></li>
				<li><a href="lista">Álbumes</a></li>

			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<h3>EDITAR ARTISTA</h3>
		</div>
		<div class="row">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li class="active"><a href="panelr.html" data-toggle="tab">Artistas</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<h3>Editar Artistas</h3>
		</div>


		<div class="row">
			<form class="form-horizontal" action="updater" method="post">

				<div class="control-group">
					<label class="control-label">CODIGO</label>
					<div class="controls">
						<input type="text" name="codigo" id="cod_artista"
							value="${requestScope.artista.cod_artista}" readonly />
					</div>
				</div>


				<div class="control-group">
					<label class="control-label">NOMBRE</label>
					<div class="controls">
						<input type="text" name="nombre_artista" id="nombre_artista"
							placeholder="Ingresar nombre"
							value="${requestScope.artista.nombre_artista}" /> 
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label">PAIS</label>
					<div class="controls">
						<input type="text" name="pais_artista" id="pais_artista"
							placeholder="Ingresar pais"
							value="${requestScope.artista.pais_artista}" /> 
					</div>
				</div>

				<div class="form-actions">
					<button type="submit" class="btn btn-success">Actualizar</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="btn" href="listr">Cancelar</a>
				</div>
			</form>
		</div>
	</div>

</body>
</html>


