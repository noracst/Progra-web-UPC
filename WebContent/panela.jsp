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
				<a class="navbar-brand" href="#">Spot Music</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="panela.jsp">Home</a></li>
				<li><a href="listg">Generos</a></li>
				<li><a href="listc">Canciones</a></li>
				<li><a href="lista">Albumes</a></li>

			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<h3>MANTENIMIENTO DE ALBUMES</h3>
		</div>
		<div class="row">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#" data-toggle="tab">Albumes</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<p style="text-align: right;">
				<a href="newa" class="btn btn-success">Agregar</a>

			</p>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>cod_album</th>
						<th>cod_cancion</th>
						<th>cod_artista</th>
						<th>titulo</th>
						<th>descripcion</th>
						<th>duracion_album</th>
					</tr>
				</thead>
				<tbody>



					<c:forEach var="a" items="${requestScope.lisalbumes}">
						<tr>
							<td>${a.cod_album}</td>
							<td>${a.cod_cancion}</td>
							<td>${a.cod_artista}</td>
							<td>${a.titulo}</td>
							<td>${a.descripcion}</td>
							<td>${a.duracion_album}</td>
							<td width=350><a class="btn" href="reada?id=${a.cod_album}">Detalle</a>
								&nbsp; <a class="btn btn-success" href="edita?id=${a.cod_album}">Editar</a>
								&nbsp; <a class="btn btn-danger" href="removea?id=${a.cod_album}">Eliminar</a>
					</c:forEach>

				</tbody>
			</table>
		</div>

		<div class="row">
			<c:if test="${!empty requestScope.mensaje}">
				<div>${requestScope.mensaje }</div>
			</c:if>
		</div>
	</div>
	<!-- /container -->
</body>
</html>

