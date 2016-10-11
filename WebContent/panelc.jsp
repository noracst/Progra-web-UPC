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
				<li class="active"><a href="panele.jsp">Home</a></li>
				<li><a href="listg">Generos</a></li>
				<li><a href="listc">Canciones</a></li>

			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<h3>MANTENIMIENTO DE CANCIONES</h3>
		</div>
		<div class="row">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#" data-toggle="tab">Canciones</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<p style="text-align: right;">
				<a href="newc" class="btn btn-success">Agregar</a>

			</p>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>cod_cancion</th>
						<th>nombre_cancion</th>
						<th>precio_cancion</th>
						<th>duracion_cancion</th>
						<th>gen</th>
					</tr>
				</thead>
				<tbody>



					<c:forEach var="c" items="${requestScope.liscanciones}">
						<tr>
							<td>${c.cod_cancion}</td>
							<td>${c.nombre_cancion}</td>
							<td>${c.precio_cancion}</td>
							<td>${c.duracion_cancion}</td>
							<td>${c.gen.cod_genero}</td>
							<td width=350><a class="btn" href="readc?id=${c.cod_cancion}">Detalle</a>
								&nbsp; <a class="btn btn-success" href="editc?id=${c.cod_cancion}">Editar</a>
								&nbsp; <a class="btn btn-danger" href="removec?id=${c.cod_cancion}">Eliminar</a>
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


