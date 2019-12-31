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
<title>Ajouter un voyage</title>
</head>
<body>
	<!-- Inclure le header -->
	<%@include file="../../../template/header.html"%>

	<h3>Formulaire d'ajout</h3>


	<form:form method="POST" action="submitAddTravel"
		modelAttribute="travel" class="container">

		<!-- 		<div class="form-group"> -->
		<!-- 			<label for="destination">Destination</label> -->
		<%-- 			<form:input type="text" class="form-control" --%>
		<%-- 				id="continent" placeholder="Continent" path="destination.continent" /> --%>
		<!-- 			<br /> -->
		<%-- 			<form:input type="text" class="form-control" --%>
		<%-- 				id="pays" placeholder="Pays" path="destination.pays" /> --%>
		<!-- 		</div> -->
	    <div class="form-group">
			<label>Destination : </label>
			<form:select path="destination.id" items="${listDestinations2}" itemValue="id" itemLabel="pays"/>
		</div> 

		<div class="form-group">
			<label for="startDate">Date de depart</label>
			<form:input type="date" class="form-control" id="startDate"
				placeholder="Depart" path="startDate" />
		</div>

		<div class="form-group">
			<label for="endDate">Date de retour</label>
			<form:input type="date" class="form-control" id="endDate"
				placeholder="Retour" path="endDate" />
		</div>
		<!-- 		<div class="form-group"> -->
		<%-- 			<label for="">Statut</label> <form:select path="status"> --%>
		<%-- 				<form:option value="" label="*** Select Option ***" /> --%>
		<%-- 				<form:options path="${travel.status}"></form:options> --%>
		<%-- 			</form:select> --%>
		<!-- 		</div> -->
		<div class="form-group">
			<label for="prix">Prix</label>
			<form:input type="number" class="form-control" id="prix"
				placeholder="Prix" path="price" />
		</div>

		<div class="form-group">
			<label for="dispo">Disponibilité</label>
			<form:input type="text" class="form-control" id="dispo"
				placeholder="Disponibilité" path="availability" />
		</div>

		<!-- 		<div class="form-group"> -->
		<!-- 			<label for="exampleInputFile">File input</label> <input type="file" -->
		<!-- 				id="exampleInputFile"/> -->
		<!-- 		</div> -->

		<input type="submit" value="Ajouter" />
	</form:form>

	<h4 style="color: red">${msg}</h4>

	<%@include file="../../../template/footer.html"%>
</body>
</html>