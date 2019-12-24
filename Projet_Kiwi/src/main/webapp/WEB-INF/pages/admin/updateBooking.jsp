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
<title>Modifier reservation</title>
</head>
<body>
	<!-- Inclure le header -->
	<%@include file="../../../template/header.html"%>

	<form:form method="POST" action="updateBooking"
		modelAttribute="booking" class="container">

		<div class="form-group">
			<label for="id">ID</label>
			<form:input type="text" class="form-control" id="id" placeholder="ID"
				path="id" required="true" />
		</div>
		<div class="form-group">
			<label>Assurance :</label>
			<form:radiobutton path="assurance" value="0" />
			Non
			<form:radiobutton path="assurance" value="1" />
			Oui
		</div>

		<div class="form-group">
			<label>Formule : </label>
			<form:select path="formula" items="${enumFormula}" />
		</div>

		<div class="form-group">
			<label>Statut : </label>
			<form:select path="status" items="${enumStatus}" />
		</div>

		<input type="submit" value="Modifier" />
	</form:form>


	<%@include file="../../../template/footer.html"%>
</body>
</html>