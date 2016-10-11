<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<a class="navbar-brand" href="#">Spot Musics</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="panele.jsp">Home</a></li>
				<li><a href="listc">Canciones</a></li>
				<li><a href="lista">Álbumes</a></li>
				<li><a href="listr">Artistas</a></li>

			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<h3>DETALLE DE CANCION</h3>
		</div>
		<div class="row">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#" data-toggle="tab">Canciones</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<h3>Detalle de Cancion</h3>
		</div>


		<div class="row">
			<div class="form-horizontal">


				<div class="control-group">
					<label class="control-label"><b>NOMBRE</b></label>
					<div class="controls">
						<label>${requestScope.cancion.nombre_cancion}</label>
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label"><b>PRECIO</b></label>
					<div class="controls">
						<label>${requestScope.cancion.precio_cancion}</label>
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label"><b>DURACION</b></label>
					<div class="controls">
						<label>${requestScope.cancion.duracion_cancion}</label>
					</div>
				</div>

				<div class="form-actions">
					<a class="btn" href="listc">Regresar</a>
				</div>
			</div>

		</div>
	</div>
</body>
</html>
