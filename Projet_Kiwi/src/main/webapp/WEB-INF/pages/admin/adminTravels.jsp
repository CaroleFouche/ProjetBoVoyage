<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib core de jstl -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- AJouter la lib fmt de jstl qui sert � l'internationalisation de mon application -->
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Admin</title>
</head>
<body>
	<!-- Inclure le header -->
	<%@include file="../../../template/header.html"%>


	<ul class="nav nav-tabs">
		<li role="presentation" ><a
			href="<c:url value = '/admin/clients'/>">Clients</a></li>
		<li role="presentation" class="active"><a
			href="<c:url value = '/admin/travels'/>">Voyages</a></li>
		<li role="presentation" ><a
			href="<c:url value = '/admin/destinations'/>">Destinations</a></li>
		<li role="presentation"><a
			href="<c:url value = '/admin/bookings'/>">Reservations</a></li>
		<li role="presentation"><a
			href="<c:url value = '/admin/agencies'/>">Agences</a></li>
	</ul>


	<h2>Administration des voyages <small><a href="<c:url value='/admin/addTravel'/>"> Nouveau voyage </a></small></h2>


	<!-- Afficher la liste des voyages propos�s -->
	<div class="container">
		<table class="table table-bordered">
			<tr>
				<td>Actions</td>
				<th>Photo</th>
				<th>Destination</th>
				<th>Date de d�part</th>
				<th>Date de retour</th>
				<th>Prix</th>
				<th>Statut</th>
			</tr>

			<c:forEach var="travel" items="${ listTravels }">
				<tr>
					<td>
					<!-- Deux liens pour modifier ou supprimer le voyage depuis l'accueil de l'admin -->
					<a href="<c:url value='/admin/linkedUpdateTravel?pId=${travel.id}'/>">Modifier </a> | 
					<a href="<c:url value='/admin/submitDeleteTravel?pId=${travel.id}'/>"> ${msg} Supprimer </a>
					</td>
					<!-- <td>${travel.pic}</td> A FAIRE -->
					<td>${travel.destination}</td>
					<td><fmt:formatDate value="${travel.startDate}"
							type="date" dateStyle="long"></fmt:formatDate></td>
					<td><fmt:formatDate value="${travel.endDate}"
							type="date" dateStyle="long"></fmt:formatDate></td>
					<td>${travel.price}</td>
					<td>${travel.availability}</td>
				</tr>


			</c:forEach>
		</table>

	</div>

	<%@include file="../../../template/footer.html"%>
</body>
</html>