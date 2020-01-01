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
<!--  lier le fichier css à ma page car boostrap ne se trouve pas dans le même fichier que ma page -->
<link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.css"/>" />
<!-- Lier les fichier Javascript pour que boostrap fonctionne correctement -->
<script type="text/javascript"
	src="<c:url value="/assets/js/bootstrap.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/assets/js/jquery-3.4.1.js"/>"></script>
<title>Voyage</title>
</head>
<body>
	<!-- Inclure le header -->
	<%@include file="../../../template/header.html"%>

	<div class="container">
		<h1>Voyage à destination de ${travel.destination.pays }</h1>
		<hr class="f4" />
	</div>

	<div class="container">
		<%-- 		${travel.destination.pays} - ${travel.destination.continent } <br /> --%>
		<!-- 		Date & prix <br /> -->
		<%-- 		<fmt:formatDate value="${travel.startDate}" type="date" --%>
		<%-- 			dateStyle="long"></fmt:formatDate> --%>
		<%-- 		<fmt:formatDate value="${travel.endDate}" type="date" dateStyle="long"></fmt:formatDate> --%>
		<!-- 		<img -->
		<%-- 			src="${pageContext.request.contextPath}/travels/img?pId=${travel.id}"> --%>


		<div class="row container">
			<div class="col-md-6">
				<div>
					<h3 style="text-decoration: underline;">Informations du voyage
					</h3>
					<br /> <br />
					<p id="para">Envolez vous à destination du
						${travel.destination.pays }</p>
					<br />
					<p id="para">
						Nous vous proposons de partir du
						<fmt:formatDate value="${travel.startDate}" type="date"
							dateStyle="long"></fmt:formatDate>
						au
						<fmt:formatDate value="${travel.endDate}" type="date"
							dateStyle="long"></fmt:formatDate>
						pour un séjour inoubliable.
					</p>
					<br /> <br />
					<p style="text-align: right;">
						A partir de <span style="color: red;"> ${travel.price } </span><i
							class="fas fa-euro-sign"></i> | <a
									href="<c:url value = '/travels/reservation?pId=${travel.id}'/>"
									class="btn btn-success" role="button">Réserver</a>
					</p>
				</div>
			</div>

			<div class="col-md-6">
				<img style="position: center"
					src="${pageContext.request.contextPath}/travels/img?pId=${travel.id}">
			</div>
	<br/><br/><br/><br/>
		<div class="col-md-6">
			<h3 style="text-decoration: underline;">Details du voyage</h3>
			<br /> <br /> Différentes formules vous sont proposées pour passer
			un agréable séjour : <br /> <br />
			<ul>
				<li><i class="fas fa-plane-departure"></i></li>
				<li><i class="fas fa-concierge-bell"></i></li>
				<li><i class="fas fa-plane-departure"></i> + <i
					class="fas fa-concierge-bell"></i></li>
				<li><i class="fas fa-plane-departure"></i> + <i
					class="fas fa-car"></i></li>
				<li><i class="fas fa-plane-departure"></i> + <i
					class="fas fa-concierge-bell"></i> + <i class="fas fa-car"></i></li>
			</ul>
		</div>

		<div class="col-md-6">
			<br /> <br /> Concernant les préstations de l'hebergement : <br />
			<br /> Vous avez le choix entre :
			<ul>
				<li>L'hebergement seul : les frais de repas sont à votre
					charge.</li>
				<li>La formule petit dejeuné inclus : le petit dejeuné est
					servi de 6h à 11h.</li>
				<li>La formule demi-pension : le dinner au restaurant de
					l'hotel est inclus à votre séjour.</li>
				<li>La pension complète : laissez-vous chouchouter par nos
					équipes, ne vous occupez de rien !</li>

			</ul>
		</div>
	</div>

	<nav aria-label="...">
		<ul class="pager">
			<li class="previous"><a href="<c:url value='/travels/'/>"><span
					aria-hidden="true">&larr;</span> Voyages</a></li>
		</ul>
	</nav><br/><br/><br/><br/>
	</div>
	<%@include file="../../../template/footer.html"%>
</body>
</html>