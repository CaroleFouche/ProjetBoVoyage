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


<h2>${agence.name}</h2>

Vous pouvez nous retrouver à ${agence.localisation} <br/>

Nous sommes ouverts du lundi au vendredi de 9h à 17h30. <br/>

Nous sommes également joignables au ${agence.phoneNumber} tous les jours de 8h à 18h.

<nav aria-label="...">
  <ul class="pager">
    <li class="previous"><a href="<c:url value='/agencies/'/>"><span aria-hidden="true">&larr;</span>Agences</a></li>
  </ul>
</nav>



	<%@include file="../../../template/footer.html"%>
</body>
</html>