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
<link rel="icon" type="image/png" href="<c:url value="/assets/images/kiwi-sized.png"/>" />
</head>
<body>
	<!-- Inclure le header -->
	<%@include file="../../../template/header.html"%>

		<div class="container">
		<h1>Mon compte - Mes réservations</h1>
		<hr class="f4" />
	</div>

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
					<td>
						<!-- Deux liens pour modifier ou supprimer la reservation depuis l'accueil de l'admin -->
						<c:if
							test="${b.getStatus().getDisplayName() ne 'Accepté'}">
							<a href="<c:url value='/user/updateBooking?pId=${b.id}'/>">Modifier
							</a>
							<c:if
								test="${cl.isSolvability()}">
								<a href="<c:url value='/user/payBooking?pId=${b.id}'/>"> | Payer
								</a>
							</c:if>
						</c:if>
						
						<c:if test="${cl.isSolvability() &&
						b.getStatus().getDisplayName() ne 'Accepté' && 
						b.isAssurance() && b.getStatus().getDisplayName() eq 'Accepté' ||
						b.getStatus().getDisplayName() eq 'En Cours'}">
						 | </c:if>
						 
						<c:if
							test="${b.isAssurance() && b.getStatus().getDisplayName() eq 'Accepté' || b.getStatus().getDisplayName() eq 'En Cours'}">
							<a href="<c:url value='/user/delBooking?pId=${b.id}'/>">Annuler
							</a>
						</c:if>
						
					</td>
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