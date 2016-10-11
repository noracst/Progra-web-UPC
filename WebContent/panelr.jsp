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
	<c:if test="${sessionScope.empleado != null}">
		<jsp:forward page="index.jsp" />
	</c:if>
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
			<h3>MANTENIMIENTO DE ARTISTAS</h3>
		</div>
		<div class="row">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#" data-toggle="tab">Artistas</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<p style="text-align: right;">
				<a href="newr" class="btn btn-success">Agregar</a>

			</p>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>CODIGO</th>
						<th>NOMBRE</th>
						<th>PAIS</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="r" items="${requestScope.listartistas}">
						<tr>
							<td>${r.cod_artista}</td>
							<td>${r.nombre_artista}</td>
							<td>${r.pais_artista}</td>
							<td width=350><a class="btn" href="readr?codigo=${r.cod_artista}">Detalle</a>
								&nbsp; <a class="btn btn-success" href="editar?codigo=${r.cod_artista}">Editar</a>
								&nbsp; <a class="btn btn-danger" href="remover?codigo=${r.cod_artista}">Eliminar</a>
						</tr>
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

