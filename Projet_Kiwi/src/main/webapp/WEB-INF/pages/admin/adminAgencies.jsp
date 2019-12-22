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


	<h2>
		Administration des Agences<small><a
			href="<c:url value='/admin/addAgencie'/>"> Nouvelle agence </a></small>
	</h2>


	<!-- Afficher la liste des agences proposés -->
	<div class="container">
		<table class="table table-bordered">
			<tr>
				<td>Actions</td>
				<th>Agence</th>
				<th>Localisation</th>
				<th>Numéro de tel</th>
			</tr>

			<c:forEach var="agencie" items="${ listAgences }">
				<tr>
					<td>
						<!-- Deux liens pour modifier ou supprimer l'agence depuis l'accueil de l'admin -->
						<a
						href="<c:url value='/admin/linkedUpdateAgence?pId=${agencie.id}'/>">Modifier </a> | <a
						href="<c:url value='/admin/submitDeleteAgencie?pId=${agencie.id}'/>"> Supprimer </a>
					</td>
					<td>${agencie.name}</td>
					<td>${agencie.localisation }</td>
					<td>${agencie.phoneNumber}</td>
				</tr>


			</c:forEach>
		</table>

	</div>




	<%@include file="../../../template/footer.html"%>
</body>
</html>