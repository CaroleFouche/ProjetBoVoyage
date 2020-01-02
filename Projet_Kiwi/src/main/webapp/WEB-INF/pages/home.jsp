<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib core de jstl -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Ajouter la tagLib de spring -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- AJouter la lib fmt de jstl qui sert à l'internationalisation de mon application -->
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Lier les fichier Javascript pour que boostrap fonctionne correctement -->


<title>Home - BoVoyage</title>
<link rel="icon" type="image/png" href="<c:url value="/assets/images/kiwi-sized.png"/>" />
</head>
<body>

	<div class="wrapper">
		<!-- Inclure le header -->
		<%@include file="../../template/header.html"%>



		<div class="container">
			<div class="header clearfix">
				<h3 class="text-muted" style="float: none; color: rgb(128, 64, 0);"></h3>
			</div>

			<div class="jumbotron">

				<h1 class="display-3">Agence BoVoyage</h1>
				<p class="lead">Bienvenue sur notre nouveau site internet dédié
					à la réservation de voyages&nbsp;</p>
				<p>
					<a class="btn btn-lg btn-default"
						href="<c:url value = '/travels'/>" role="button"
						style="background-color: rgb(144, 238, 144); color: rgb(0, 0, 0);">Nos
						voyages</a>
				</p>
				<!-- Carousel avec météo -->
				<div class=".col-md-4 .col-md-offset-4">
					<div class="container weather-container" style="position: right">
						<div style="text-align: center" id="displayedWeather">Chargement
							Météo...</div>
					</div>
				</div>

			</div>

		</div>
		<div class="container">
		<div class="row marketing">
			<div class="col-lg-6">
				<h4>Réservez vos vacances avec les meilleures offres de voyage
					:</h4>
				<p>
					<i class="fas fa-check"></i> Les meilleurs prix du marché
				</p>
				<p>
					<i class="fas fa-check"></i> Des formules (avion, avion+hotel ...)
					pour tous les gouts!
				</p>
				<p>
					<i class="fas fa-check"></i> Assurance annulation optionnelle
				</p>

			</div>

			<div class="col-lg-6">
				<h4>Pourquoi partir avec BoVoyage ?</h4>
				<p>Parce que nous trouvons le meilleur rapport qualité/prix
					defiant toute concurrence ! Grâce à nos agences de voyage
					partenaires nous vous garantissons les meilleurs tarifs.</p>
			</div>
		</div>
	</div>
	</div>
	<div class="push"></div>
	</div>
	<br />



	<br />
	<br />


	<div class="container" style="position: center">
		<h3 style="text-align: center" id="title">Les offres du moment</h3>
		<br /> <br />



		<c:forEach var="travel" items="${ listTravels }">
			<div class="col-sm-7 col-md-3">
				<div class="thumbnail">
					<img
						src="${pageContext.request.contextPath}/travels/img?pId=${travel.id}">
					<div class="caption">
						<h3>Sejour en ${travel.destination.pays}</h3>
						<p>Nous vous proposons un voyage a destination de
							${travel.destination.pays} en ${travel.destination.continent }</p>

						<p>
							Du
							<fmt:formatDate value="${travel.startDate}" type="date"
								dateStyle="long"></fmt:formatDate>
							au
							<fmt:formatDate value="${travel.endDate}" type="date"
								dateStyle="long"></fmt:formatDate>
						</p>
						<p>
							Prix : ${travel.price} <br /> <br /> <a
								href="<c:url value = '/travels/details?pId=${travel.id}'/>"
								class="btn btn-default">More information</a> | <a
								href="<c:url value = '/travels/reservation?pId=${travel.id}'/>"
								class="btn btn-success" role="button">Réserver</a>

						</p>
					</div>
				</div>
			</div>
		</c:forEach>

	</div>
	<%@include file="../../template/footer.html"%>


	<!-- Weather API ajax script -->
	<link rel="stylesheet"
		href="<c:url value="/assets/css/weatherStyle.css"/>" />

	<script type="text/javascript"
		src="<c:url value="/assets/js/openweathermapJS.js"/>"></script>

</body>
</html>