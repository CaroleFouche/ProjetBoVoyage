<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib core de jstl -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Ajouter la tagLib de spring -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- AJouter la lib fmt de jstl qui sert à l'internationalisation de mon application -->
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<title>Réserver le voyage Voyage</title>
</head>
<body>
	<!-- Inclure le header -->
	<%@include file="../../../template/header.html"%>

	
	formule : ${booking.assurance }
	<!-- Renseigner les informations client (si différentes du compte client connecté) -->
	<form:form method="POST" action="${pageContext.request.contextPath}/user/setBookingClient"
		modelAttribute="booking" class="container">
		
		<div class="form-group">
			<label for="name">Nom </label>
			<form:input type="text" class="form-control" id="name"
				placeholder="Name" path="client.name" required="true" />
		</div>
		
		TODO : INFORMATIONS RESA : assurance / formule
		<input type="submit" value="Enregistrer"/>
	</form:form>
	
	
	<!-- Indiquer le nombre de passagers a enregistrer -->
	 Nombre de passagers :
	 <form:form method="POST" action="${pageContext.request.contextPath}/user/setBookingNbTravellers"
			modelAttribute="booking" class="container">
		<div class="form-group">
			<label for="name">Nombre de voyageurs </label>
			<form:input type="number" class="form-control" id="name"
				placeholder="Name" path="nbTravellers" required="true" />
		</div>
	</form:form>
	
	
	<!-- affiche un formulaire par voyageur requis ci-dessus -->
	<c:if test="${not empty booking.travellers}">
		Informations Voyageurs :
		<form:form method="POST" action="${pageContext.request.contextPath}/user/reservation"
			modelAttribute="booking" class="container">
			
			<c:forEach items="${booking.travellers}" var="currentTraveller" varStatus="loop">
				
					voyageur ${loop.index + 1}: <br/>
					<div class="form-group">
						<label for="name">Nom </label>
						<form:input type="text" class="form-control" id="name"
							placeholder="Name" path="travellers[${loop.index}].name" required="true" />
					</div>
					<br/>
					
			</c:forEach>
			
				
			<input type="submit" value="Réserver"/>
		
		</form:form>
	</c:if>
	
	

	<%@include file="../../../template/footer.html"%>
</body>
</html>