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

<title>travels</title>
</head>
<body>
	<!-- Inclure le header -->
	<%@include file="../../../template/header.html"%>

	<h2>Nos voyages</h2>
<!-- Les voyages propos�s -->
	<div class="row" style="margin-left:5%; margin-right:5%">
		<c:forEach var="travel" items="${ listTravels }">
			<div class="col-sm-7 col-md-3">
				<div class="thumbnail">
					<img src="<c:url value="/assets/images/imageTest.jpg" />">
					<div class="caption">
						<h3>Destination</h3>
						<p>Courte description</p>
						<p>
							Du
							<fmt:formatDate value="${travel.startDate}" type="date"
								dateStyle="long"></fmt:formatDate>
							au
							<fmt:formatDate value="${travel.endDate}" type="date"
								dateStyle="long"></fmt:formatDate>
						</p>
						<p>
							${travel.price} | <a href="/reserve" class="btn btn-primary"
								role="button">Reserver</a>
						</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>


	<%@include file="../../../template/footer.html"%>
</body>
</html>