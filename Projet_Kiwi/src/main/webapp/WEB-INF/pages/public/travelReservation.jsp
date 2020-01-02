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
<link rel="icon" type="image/png" href="<c:url value="/assets/images/kiwi-sized.png"/>" />
</head>
<body>
	<!-- Inclure le header -->
	<%@include file="../../../template/header.html"%>

<!-- Renseigner les informations client (si différentes du compte client connecté) -->
	<form:form method="POST" action="${pageContext.request.contextPath}/user/setBookingInfos"
		modelAttribute="booking" class="container col-md-8 col-md-offset-2">
		<div class="panel panel-success col-md-8 col-md-offset-2">
			<div class="panel-heading ">
			    <h3 class="panel-title">Informations de facturation</h3>
			</div>
			<div class="panel-body">
			
				
				<div class="form-group">
					<label for="name">Nom Acheteur</label>
					<form:input type="text" class="form-control" id="name"
						placeholder="Name" path="client.name" required="true" />
				</div>
				
				<div class="form-group">
					<label>Assurance :</label>
					<form:radiobutton  class="custom-control-input" path="assurance" value="0" />
					Non
					<form:radiobutton  class="custom-control-input" path="assurance" value="1" />
					Oui
				</div>
				
				<div class="form-group">
					<label>Formule : </label>
					<form:select path="formula" items="${enumFormula}" />
				</div>
				
				<input type="submit" class="btn-success" value="Enregistrer"/>
					
			</div>
		</div>
	</form:form>
	
	
	<!-- Indiquer le nombre de passagers a enregistrer -->
	 <form:form method="POST" action="${pageContext.request.contextPath}/user/setBookingNbTravellers"
					modelAttribute="booking" class="container col-md-8 col-md-offset-2">
		<div class="panel panel-warning col-md-8 col-md-offset-2">
			<div class="panel-heading ">
			    <h3 class="panel-title">Nombre de passagers : ${booking.nbTravellers} </h3>
			</div>
			<div class="panel-body">
		 
					<div class="form-group">
						<div class="custom-control custom-radio custom-control-inline">
							<form:radiobutton path="nbTravellers" value="1" checked="${booking.nbTravellers == 1 ? 'checked' : '' }"/>1
							<form:radiobutton path="nbTravellers" value="2" checked="${booking.nbTravellers == '2' ? 'checked' : '' }"/>2
							<form:radiobutton path="nbTravellers" value="3" checked="${booking.nbTravellers == '3' ? 'checked' : '' }"/>3
							<form:radiobutton path="nbTravellers" value="4" checked="${booking.nbTravellers == '4' ? 'checked' : '' }"/>4
							<form:radiobutton path="nbTravellers" value="5" checked="${booking.nbTravellers == '5' ? 'checked' : '' }"/>5
					<input type="submit" class="btn-success" value="Valider"/>
						</div>
					</div>
			</div>
		</div>
	</form:form>
	
	<!-- affiche un formulaire par voyageur requis ci-dessus -->
	<c:if test="${not empty booking.travellers}">
				
		<form:form method="POST" action="${pageContext.request.contextPath}/user/reservation"
			modelAttribute="booking" class="container col-md-8 col-md-offset-2">
			<div class="panel panel-success col-md-8 col-md-offset-2">
				<div class="panel-heading">
				    <h3 class="panel-title">Renseignements Voyageurs :</h3>
				</div>
				<div class="panel-body">
					
					<c:forEach items="${booking.travellers}" var="currentTraveller" varStatus="loop">
						<label> voyageur ${loop.index + 1}: <br/></label>
						<div class="form-group">
							<label for="name">Nom </label>
							<form:input type="text" class="form-control" id="name"
								placeholder="Name" path="travellers[${loop.index}].name" required="true" />
						</div>
					</c:forEach>
					
					<c:if test="${booking.id == '0'}">	
						<input type="submit" class="btn-success" value="Réserver"/>
					</c:if>
					<c:if test="${booking.id != '0'}">	
						<input type="submit" class="btn-success" value="Mettre à jour"/>
					</c:if>
				</div>
			</div>
		</form:form>
	</c:if>
			

	<%-- <%@include file="../../../template/footer.html"%> --%>
</body>
</html>