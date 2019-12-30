<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib core de jstl -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- AJouter la lib fmt de jstl qui sert à l'internationalisation de mon application -->
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>travels</title>

<!-- Lier le fichier monStyle.css à ma page -->
<link rel="stylesheet" href="<c:url value="/assets/css/monstyle.css"/>" />
<!-- Lier le fichier monJS.js à ma page -->
<script type="text/javascript"
	src="<c:url value="/assets/js/monJS.js"/>"></script>

</head>
<body>
	<!-- Inclure le header -->
	<%@include file="../../../template/header.html"%>

	<h2>Nos voyages</h2>
	<!-- Les voyages proposés -->
	<div class="row" style="margin-left: 5%; margin-right: 5%">
		<c:forEach var="travel" items="${ listTravels }">
			<div class="col-sm-7 col-md-3">
				<div class="thumbnail">
					<img src="<c:url value="/assets/images/imageTest.jpg" />">
					<div class="caption">
						<h3>Séjour en ${travel.destination.pays}</h3>
						<p>Nous vous proposons un voyage à destination de ${travel.destination.pays} en ${travel.destination.continent } </p>
			
						<p>
							Du
							<fmt:formatDate value="${travel.startDate}" type="date"
								dateStyle="long"></fmt:formatDate>
							au
							<fmt:formatDate value="${travel.endDate}" type="date"
								dateStyle="long"></fmt:formatDate>
						</p>
						<p>
							Prix : ${travel.price} <br /><br /> <a
								href="<c:url value = '/travels/details?pId=${travel.id}'/>"
								class="btn btn-default">More information</a>
								|
							  <a href="<c:url value = '/travels/reservation?pId=${travel.id}'/>" class="btn btn-success" role="button">Réserver</a>

						</p>


					</div>
				</div>
			</div>
		</c:forEach>
	</div>


	<%@include file="../../../template/footer.html"%>
</body>
</html>