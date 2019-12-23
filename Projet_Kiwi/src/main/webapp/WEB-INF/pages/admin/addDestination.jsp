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
<title>Ajouter une destination</title>
</head>
<body>
	<!-- Inclure le header -->
	<%@include file="../../../template/header.html"%>

	<form:form method="POST" action="submitAddDestination"
		modelAttribute="destination" class="container">

		<div class="form-group">
			<label for="continent">Continent </label>
			<form:input type="text" class="form-control" id="continent"
				placeholder="Continent" path="continent" required="true" />
		</div>

		<div class="form-group">
			<label for="pays">Pays</label>
			<form:input type="text" class="form-control" id="pays"
				placeholder="Pays" path="pays" />
		</div>
		<input type="submit" value="Ajouter" />
	</form:form>

	<h4 style="color: red">${msg}</h4>

	<%@include file="../../../template/footer.html"%>
</body>
</html>