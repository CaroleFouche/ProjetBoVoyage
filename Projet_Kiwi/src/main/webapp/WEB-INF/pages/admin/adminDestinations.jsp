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


	<h2>Administration des Destinations</h2>
	<br />
	<small> <a href="<c:url value='/admin/addDestination'/>">
			Ajouter une destination </a>
	</small>

	<!-- Afficher la liste des clients-->
	<div class="container">
		<table class="table table-bordered">
			<tr>
				<td>Actions</td>
				<th>Continent</th>
				<th>Pays</th>
			</tr>

			<c:forEach var="dest" items="${ listDestinations }">
				<tr>
					<td>
						<!-- Deux liens pour modifier ou supprimer le client depuis l'accueil de l'admin -->
						<a href="<c:url value='/admin/updateDestination?pId=${dest.id}'/>">Modifier
					</a> | <a href="<c:url value='/admin/deleteDestination?pId=${dest.id}'/>">Supprimer
					</a>
					</td>
					<td>${dest.continent}</td>
					<td>${dest.pays}</td>
				</tr>


			</c:forEach>
		</table>

	</div>

	<%@include file="../../../template/footer.html"%>
</body>
</html>