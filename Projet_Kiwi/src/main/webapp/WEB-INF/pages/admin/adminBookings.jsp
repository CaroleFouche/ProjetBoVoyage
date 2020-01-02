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
		<li role="presentation" ><a
			href="<c:url value = '/admin/travels'/>">Voyages</a></li>
		<li role="presentation" ><a
			href="<c:url value = '/admin/destinations'/>">Destinations</a></li>
		<li role="presentation" class="active"><a
			href="<c:url value = '/admin/bookings'/>">Reservations</a></li>
		<li role="presentation"><a
			href="<c:url value = '/admin/agencies'/>">Agences</a></li>
	</ul>
	<div class="container">
	<h2>
		Administration des Reservations  <small> <a
			href="<c:url value='/admin/addBooking'/>"> <i
					class="fas fa-plus"></i> Ajouter une
				reservation </a>
		</small>
	</h2>
	</div>

	

	<!-- Afficher la liste des resas-->
	<div class="container">
		<table class="table table-bordered">
			<tr>
				<td>Actions</td>
				<th>Id</th>
				<th>Assurance</th>
				<th>Formule</th>
				<th>Statut</th>
			</tr>

			<c:forEach var="b" items="${ listBookings }">
				<tr>
					<td>
						<!-- Deux liens pour modifier ou supprimer la reservation depuis l'accueil de l'admin -->
						<a href="<c:url value='/admin/updateBooking?pId=${b.id}'/>">Modifier
					</a> | <a href="<c:url value='/admin/deleteBooking?pId=${b.id}'/>">Supprimer
					</a>
					</td>
					<td>${b.id}</td>
					<td><c:if test="${b.isAssurance()}">Oui</c:if> <c:if
							test="${!b.isAssurance()}">Non</c:if></td>
					<!-- Rajouter des if et faire tous les cas pour retirer le camelCase de l'affichage ?  -->
					<td>${b.getFormula().getDisplayName()}</td>
					<td>${b.getStatus().getDisplayName()}</td>
				</tr>


			</c:forEach>
		</table>

	</div>


	<%@include file="../../../template/footer.html"%>
</body>
</html>