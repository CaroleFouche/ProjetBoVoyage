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
</head>
<body>
	<!-- Inclure le header -->
	<%@include file="../../../template/header.html"%>

	<ul class="nav nav-tabs">
		<li role="presentation" class="active"><a
			href="<c:url value = '/admin/clients'/>">Clients</a></li>
		<li role="presentation"><a
			href="<c:url value = '/admin/travels'/>">Voyages</a></li>
		<li role="presentation"><a
			href="<c:url value = '/admin/destinations'/>">Destinations</a></li>
		<li role="presentation"><a
			href="<c:url value = '/admin/bookings'/>">Reservations</a></li>
		<li role="presentation"><a
			href="<c:url value = '/admin/agencies'/>">Agences</a></li>
	</ul>
<div class="container">
	<h2>
		Administration des clients
		<small>
			<a href="<c:url value='/admin/addClient'/>"><i
					class="fas fa-plus"></i> Ajouter un client </a>
		</small>
	</h2>
	</div>
	
	
	<!-- Afficher la liste des clients-->
	<div class="container">
		<table class="table table-bordered">
			<tr>
				<td>Actions</td>
				<th>ID</th>
				<th>Nom</th>
				<th>Tel</th>
				<!-- <th>Adresse</th>-->
				<th>Mail</th>
				<th>Age</th>
				<th>Login</th>
				<th>Carte</th>
				<th>Solvabilité</th>
				<th>Statut compte</th>
			</tr>

			<c:forEach var="cl" items="${ listClients }">
				<tr>
					<td>
						<!-- Deux liens pour modifier ou supprimer le client depuis l'accueil de l'admin -->
						<a href="<c:url value='/admin/updateClient?pId=${cl.id}'/>">Modifier </a> | 
						<a href="<c:url value='/admin/deleteClient?pId=${cl.id}'/>">Supprimer </a>
					</td>
					<td>${cl.id}</td>
					<td>${cl.name}</td>
					<td>${cl.phone}</td>
					<!-- <td>${cl.adresse.num} ${cl.adresse.street}, ${cl.adresse.postCode} ${cl.adresse.city} </td>-->
					<td>${cl.mail}</td>
					<td>${cl.age}</td>
					<td>${cl.login}</td>
					<td>${cl.numCard}</td>
					<td>${cl.solvability}</td>
					<td>${cl.active}</td>
				</tr>


			</c:forEach>
		</table>

	</div>
	
	
	<%@include file="../../../template/footer.html"%>
</body>
</html>