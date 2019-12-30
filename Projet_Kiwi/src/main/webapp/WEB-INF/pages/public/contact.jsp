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
<title>Contact</title>
</head>
<body>
	<!-- Inclure le header -->
	<%@include file="../../../template/header.html"%>
	<br />
	
	 <div class="container">
 <h1 >Un petit mot ? Une remarque ? Contactez-nous ! </h1>
<hr class="f4"/>
</div>
	<div class="row">
	<form:form class="container form-inline" method="POST"
		modelAttribute="contact" action="contact/sendSimpleEmail">
		<label class="col-md-2" for="name">Nom :</label>
		<form:input class="col-md-10" id="name" path="name" />
		<br />
		<br />
		<label class="col-md-2" for="email">E-mail :</label>
		<form:input class="col-md-10" id="email" path="email" />
		<br />
		<br />
		<label class="col-md-2" for="subject">Objet :</label>
		<form:input class="col-md-10" id="subject" path="subject" />
		<br />
		<br />
		<label class="col-md-2" for="message">Votre message :</label>
		<form:textarea class=" col-md-10" id="message" rows="5"
			path="text"></form:textarea>
		<br />
		<br />
		<br />
		<br />	<br />
		<br />
	
		<div class="col-md-2"></div>
		<div class="col-md-1">
		<input type="submit" value="Envoyer"></div>

	</form:form>
</div>
	

	<%@include file="../../../template/footer.html"%>
</body>
</html>