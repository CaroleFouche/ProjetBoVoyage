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

<title>Destinations</title>
</head>
<body>
	<!-- Inclure le header -->
	<%@include file="../../../template/header.html"%>

<h2>Nos destinations</h2>
	<div class="row container">
		<c:forEach var="destination" items="${ list }">
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img src="<c:url value="/assets/images/imageTest - Copie.jpg" />" alt="...">
						<div class="caption">
							<h3>${destination.continent} - ${destination.pays }</h3>
							<p>Bla bla bla</p>

						</div>
					</div>
				</div>
		</c:forEach>
		</div>


	<%@include file="../../../template/footer.html"%>
</body>
</html>