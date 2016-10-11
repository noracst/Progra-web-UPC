<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
<title>Spot Music</title>
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
				<li><a href="lista">Álbumes</a></li>
				<li><a href="listc">Canciones</a></li>
				<li><a href="listr">Artistas</a></li>
				

			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<h3>NUEVO ALBUM</h3>
		</div>
		<div class="row">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li class="active"><a href="panelc.html" data-toggle="tab">Canciones</a></li>
					<li class="active"><a href="panelr.html" data-toggle="tab">Artistas</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<h3>Agregar Álbum</h3>
		</div>
		<div class="row">
			<form class="form-horizontal" action="insertr" method="post">

				<div class="control-group">
					<label class="control-label">TITULO</label>
					<div class="controls">
						<input type="text" name="titulo" id="titulo"
							placeholder="Ingresar titulo" value="">
					</div>
				</div>

				<div class="control-group">
					<label class="control-label">DESCRIPCION</label>
					<div class="controls">
						<input type="text" name="descripcion" id="descripcion"
							placeholder="Ingresar descripcion" value="">
					</div>
				</div>

				<div class="control-group">
					<label class="control-label">DURACION</label>
					<div class="controls">
						<input type="text" name="duracion_album" id="duracion_album"
							placeholder="Ingresar duracion" value="">
					</div>
				</div>


				<div class="control-group">

					<label class="control-label">ARTISTA:</label>
					<div class="controls">

						<select name="artista" id="cod_artista">
							<c:forEach var="a" items="${requestScope.lisartistas}">
								<option value="${a.cod_artista}">${a.nombre_artista}</option>
							</c:forEach>
						</select>


					</div>

				</div>
				
				<div class="control-group">

					<label class="control-label">CANCIONES:</label>
					<div class="controls">

						<select name="canciones" id="cod_cancion">
							<c:forEach var="c" items="${requestScope.liscanciones}">
								<option value="${c.cod_cancion}">${a.nombre_cancion}</option>
							</c:forEach>
						</select>


					</div>

				</div>

				<div class="form-actions">
					<button type="submit" class="btn btn-success">Agregar</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="btn" href="lista">Cancelar</a>
				</div>
			</form>
		</div>
	</div>

</body>
</html>
