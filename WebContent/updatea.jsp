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
				<li><a href="lista">Albumes</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<h3>EDITAR ALBUM</h3>
		</div>
		<div class="row">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li class="active"><a href="panela.html" data-toggle="tab">Albumes</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<h3>Editar Albumes</h3>
		</div>


		<div class="row">
			<form class="form-horizontal" action="updatea" method="post">

				<div class="control-group">
					<label class="control-label">CODIGO</label>
					<div class="controls">
						<input type="text" name="cod_album" id="cod_album"
							value="${requestScope.album.cod_album}" readonly />
					</div>
				</div>
				
				
				<div class="control-group">
					<label class="control-label">TITULO</label>
					<div class="controls">
						<input type="text" name="titulo" id="titulo"
							value="${requestScope.album.titulo}" readonly />
					</div>
				</div>

				<div class="control-group">
					<label class="control-label">DESCRIPCION</label>
					<div class="controls">
						<input type="text" name="descripcion" id="descripcion"
							value="${requestScope.album.descripcion}" readonly />
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label">DURACION</label>
					<div class="controls">
						<input type="text" name="duracion" id="duracion"
							value="${requestScope.album.duracion}" readonly />
					</div>
				</div>


				<div class="control-group">
					<label class="control-label">CANCIONES</label>
					<div class="controls">
						<input type="text" name="can" id="can"
							placeholder="Ingresar canciones"
							value="${requestScope.album.can.nombre_cancion}" /> 
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label">ARTISTA</label>
					<div class="controls">
						<input type="text" name="art" id="art"
							placeholder="Ingresar artista"
							value="${requestScope.album.art.nombre_artista}" /> 
					</div>
				</div>
				
				<div class="form-actions">
					<button type="submit" class="btn btn-success">Actualizar</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="btn" href="lista">Cancelar</a>
				</div>
			</form>
		</div>
	</div>

</body>
</html>
