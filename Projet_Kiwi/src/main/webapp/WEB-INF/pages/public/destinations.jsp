<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib core de jstl -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<title>Destinations</title>
</head>
<body>
	<!-- Inclure le header -->
	<%@include file="../../../template/header.html"%>
	
	
	<h1>Afficher toutes les destinations ici</h1>
	
	
	<div class="container">
		<table class="table table-bordered">
				<tr>	
					<td>Action</td>
					<th>id</th>
					<th>Pays</th>
					<th>Continent</th>
				</tr>
				
			<c:forEach var="destination" items="${ list }">
				<tr>
					<td></td>
					<td>${destination.id}</td>
					<td>${destination.pays}</td>
					<td>${destination.continent}</td>
				</tr>
				
  	
			</c:forEach>
		</table>
			
	</div>
	
	
	
	
	
	

	<%@include file="../../../template/footer.html"%>
</body>
</html>