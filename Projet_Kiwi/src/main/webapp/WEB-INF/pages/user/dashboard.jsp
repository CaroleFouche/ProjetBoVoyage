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


<title>Dashboard</title>
<link rel="icon" type="image/png" href="<c:url value="/assets/images/kiwi-sized.png"/>" />
</head>
<body>
	<!-- Inclure le header -->
	<%@include file="../../../template/header.html"%>

	<h2>Afficher les infos pour le client ici (dossier, resas, liens
		pour les autres pages etc) <small><a href="<c:url value='/user/myReservations?pId=${logedClient.id}'/>"> Mes voyages </a></small></h2>
	<!-- Afficher la liste des clients-->
	<div class="container">
		<table class="table table-bordered">
			<tr>
				<td>Actions</td>
				<th>Numéro Client</th>
				<th>Nom</th>
				<th>Tel</th>
				<th>Mail</th>
				<th>Age</th>
				<th>Login</th>
				<th>Password</th>
				<th>Carte</th>
				
			</tr>

			<tr>
				<td>
					<!-- Deux liens pour modifier ou supprimer le client depuis l'accueil de l'admin -->
					<a href="<c:url value='/user/updateClient?pId=${logedClient.id}'/>">Modifier
				</a> 
				</td>
				<td>${logedClient.id}</td>
				<td>${logedClient.name}</td>
				<td>${logedClient.phone}</td>
				<td>${logedClient.mail}</td>
				<td>${logedClient.age}</td>
				<td>${logedClient.login}</td>
				<td>${logedClient.mdp}</td>
				<td>${logedClient.numCard}</td>
				
			</tr>


		</table>

	</div>

	<%@include file="../../../template/footer.html"%>
</body>
</html>