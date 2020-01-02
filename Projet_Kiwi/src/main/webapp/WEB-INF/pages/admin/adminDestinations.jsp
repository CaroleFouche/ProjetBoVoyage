<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib core de jstl -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- AJouter la lib fmt de jstl qui sert à l'internationalisation de mon application -->
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Admin</title>
<link rel="icon" type="image/png" href="<c:url value="/assets/images/kiwi-sized.png"/>" />
</head>
<body>
	<!-- Inclure le header -->
	<%@include file="../../../template/header.html"%>

	<ul class="nav nav-tabs">
		<li role="presentation" ><a
			href="<c:url value = '/admin/clients'/>">Clients</a></li>
		<li role="presentation"><a
			href="<c:url value = '/admin/travels'/>">Voyages</a></li>
		<li role="presentation" class="active"><a
			href="<c:url value = '/admin/destinations'/>">Destinations</a></li>
		<li role="presentation"><a
			href="<c:url value = '/admin/bookings'/>">Reservations</a></li>
		<li role="presentation"><a
			href="<c:url value = '/admin/agencies'/>">Agences</a></li>
	</ul>
	<div class="container">
	<h2>Administration des destinations
	<small> <a href="<c:url value='/admin/addDestination'/>"><i
					class="fas fa-plus"></i>
			Ajouter une destination </a>
	</small></h2>
	</div>


	<!-- Afficher la liste des clients-->
	<div class="container">
		<table class="table table-bordered">
			<tr>
				<td>Actions</td>
				<th>Id</th>
				<th>Continent</th>
				<th>Pays</th>
				<th>Photos</th>
			</tr>

			<c:forEach var="dest" items="${ listDestinations }">
				<tr>
					<td>
						<!-- Deux liens pour modifier ou supprimer le client depuis l'accueil de l'admin -->
						<a href="<c:url value='/admin/updateDestination?pId=${dest.id}'/>">Modifier
					</a> | <a
						href="<c:url value='/admin/deleteDestination?pId=${dest.id}'/>">Supprimer
					</a>
					</td>
					<td>${dest.id}</td>
					<td>${dest.continent}</td>
					<td>${dest.pays}</td>
					<td><c:forEach var="ph" items="${dest.pics}">
							<img src="${ph.photoString}" style="width: 90px; height: 90px" />

						</c:forEach>
					</td>
				</tr>


			</c:forEach>
		</table>

	</div>

	<%@include file="../../../template/footer.html"%>
</body>
</html>