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
<title>Agence</title>
</head>
<body>
	<!-- Inclure le header -->
	<%@include file="../../../template/header.html"%>
	<div class="container">
 <h1 >Agences - Venez nous voir !</h1>
<hr class="f4"/>
</div>


	<div class="row container" style="margin-left: 5%; margin-right: 5%">
		<c:forEach var="agencie" items="${ listAgences }">
			<div class="col-sm-7 col-md-3">
				<div class="thumbnail">
					<img src="<c:url value="/assets/images/agence.png" />">
					<div class="caption">
						<h3>${agencie.name }</h3>
						<p>${agencie.localisation}</p>
						<p>
							${agencie.phoneNumber} | <a
								href="<c:url value='/agencies/details?pId=${agencie.id}'/>"
								class="btn btn-primary" role="button">More information</a>
						</p>

					</div>
				</div>
			</div>
		</c:forEach>
	</div>



	<%@include file="../../../template/footer.html"%>
</body>
</html>