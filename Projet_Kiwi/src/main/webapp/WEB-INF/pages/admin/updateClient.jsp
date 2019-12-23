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
<title>Modifier Client</title>
</head>




<body>
	<!-- Inclure le header -->
	<%@include file="../../../template/header.html"%>
	
	
	<form:form method="POST" action="updateClient"
		modelAttribute="client" class="container">
		
		<div class="form-group">
			<label for="id" >ID</label>
			<form:input type="text" class="form-control"
				id="id" placeholder="ID" path="id" required="true"/>
		</div>
		
		<div class="form-group">
			<label for="name" >Nom du client</label>
			<form:input type="text" class="form-control"
				id="name" placeholder="Name" path="name" />
		</div>
		
		<div class="form-group">
			<label for="phone" >Telephone</label>
			<form:input type="text" class="form-control"
				id="phone" placeholder="Tel" path="phone" />
		</div>
		
		<div class="form-group">
			<label for="mail" >Mail</label>
			<form:input type="text" class="form-control"
				id="mail" placeholder="Email" path="mail" />
		</div>
		
		<div class="form-group">
			<label for="age" >Age</label>
			<form:input type="text" class="form-control"
				id="age" placeholder="Age" path="age" />
		</div>
		
		<div class="form-group">
			<label for="login" >Login</label>
			<form:input type="text" class="form-control"
				id="login" placeholder="Login" path="login" />
		</div>
		
		<div class="form-group">
			<label for="numCard" >Numéro de carte</label>
			<form:input type="number" class="form-control"
				id="numCard" placeholder="numero" path="numCard" />
		</div>

		<input type="submit" value="Modifier" />
	</form:form>

	<%@include file="../../../template/footer.html"%>
</body>
</html>