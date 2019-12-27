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

<title>My Reservations</title>
</head>
<body>
	<!-- Inclure le header -->
	<%@include file="../../../template/header.html"%>

	<h2>Afficher les reservations effectuées par le client</h2>


	<div class="container">
		<table class="table table-bordered">
			<tr>
				<td>Actions</td>
				<th>Numéro de réservation</th>
				<th>Assurance</th>
				<th>Formule</th>
				<th>Statut</th>

			</tr>

			<c:forEach var="b" items="${ listBooking }">
				<tr>
					<td></td>
					<td>${b.id}</td>
					<td><c:if test="${b.isAssurance()}">Oui</c:if> <c:if
							test="${!b.isAssurance()}">Non</c:if></td>
					<td>${b.getFormula().getDisplayName()}</td>
					<td>${b.getStatus().getDisplayName()}</td>


				</tr>
			</c:forEach>
		</table>

	</div>


	<%@include file="../../../template/footer.html"%>
</body>
</html>