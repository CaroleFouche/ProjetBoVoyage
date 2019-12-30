<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib core de jstl -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Ajouter la tagLib de spring -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- AJouter la lib fmt de jstl qui sert � l'internationalisation de mon application -->
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!--  lier le fichier css � ma page car boostrap ne se trouve pas dans le m�me fichier que ma page -->
<link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.css"/>" />
<!-- Lier les fichier Javascript pour que boostrap fonctionne correctement -->
<script type="text/javascript"
	src="<c:url value="/assets/js/bootstrap.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/assets/js/jquery-3.4.1.js"/>"></script>
<title>Home - BoVoyage</title>
</head>
<body>

	<div class="wrapper">
		<!-- Inclure le header -->
		<%@include file="../../template/header.html"%>



		<div class="container">
			<div class="header clearfix">
				<h3 class="text-muted" style="float: none; color: rgb(128, 64, 0);"></h3>
			</div>

			<div class="jumbotron"  >
				<h1 class="display-3">Agence BoVoyage</h1>
				<p class="lead">Bienvenue sur notre nouveau site internet d�di�
					� la r�servation de voyages&nbsp;</p>
				<p>
					<a class="btn btn-lg btn-default"
						href="<c:url value = '/travels'/>" role="button"
						style="background-color: rgb(144, 238, 144); color: rgb(0, 0, 0);">Nos
						voyages</a>
				</p>
			</div>
			<div class="row marketing">
				<div class="col-lg-6">
					<h4>R�servez vos vacances avec les meilleures offres de voyage
						:</h4>
					<p>
						<i class="fas fa-check"></i> Les meilleurs prix du march�
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
					<p>Parce que nous trouvons le meilleur rapport qualit�/prix
						defiant toute concurrence! Grace � nos agences de voyage
						partenaires nous vous garantissons les meilleurs tarifs.</p>
				</div>
			</div>
		</div>
		<div class="push"></div>
	</div>
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
								class="btn btn-success" role="button">R�server</a>

						</p>
					</div>
				</div>
			</div>
		</c:forEach>

	</div>
	<%@include file="../../template/footer.html"%>
</body>
</html>