<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib core de jstl -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- AJouter la lib fmt de jstl qui sert à l'internationalisation de mon application -->
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Accueil</title>
</head>
<body>
	<!-- Inclure le header -->
	<%@include file="../../template/header.html"%>

	<!-- Carousel -->
<!-- 	<div id="carousel-accueil" class=" carousel slide" -->
<!-- 		data-ride="carousel"> -->
<!-- 		<!-- Indicators --> 
<!-- 		<ol class="carousel-indicators"> -->

<!-- 			<li data-target="#carousel-accueil" data-slide-to="0" class="active"></li> -->
<!-- 			<li data-target="#carousel-accueil" data-slide-to="1"></li> -->
<!-- 			<li data-target="#carousel-accueil" data-slide-to="2"></li> -->
<!-- 		</ol> -->

<!-- 		<!-- Wrapper for slides --> 
<!-- 		<div class="carousel-inner" role="listbox"> -->
<!-- 			<div class="item active"> -->
<!-- 				<img src="" />" alt="..." > -->
<!-- 				<div class="carousel-caption"> -->
<!-- 					<h2>Image 1</h2> -->
<!-- 					<p>Caption</p> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="item"> -->
<!-- 				<img src="" alt="..." height="345" width="460"> -->
<!-- 				<div class="carousel-caption"> -->
<!-- 					<h2>Image 2</h2> -->
<!-- 					<p>Caption</p> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="item"> -->
<!-- 				<img src="" alt="..." height="345" width="460"> -->
<!-- 				<div class="carousel-caption"> -->
<!-- 					<h2>Image 1</h2> -->
<!-- 					<p>Caption</p> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->

<!-- 		<!-- Controls --> 
<!-- 		<a class="left carousel-control" href="#carousel-accueil" -->
<!-- 			role="button" data-slide="prev"> <span class=".icon-prev" -->
<!-- 			aria-hidden="true"></span> <span class="sr-only">Precedent</span> -->
<!-- 		</a> <a class="right carousel-control" href="#carousel-accueil" -->
<!-- 			role="button" data-slide="next"> <span class=".icon-next" -->
<!-- 			aria-hidden="true"></span> <span class="sr-only">Suivant</span> -->
<!-- 		</a> -->
<!-- 	</div> -->
	
	<div class="container">
	<h2>Accueil </h2>
	
	<h3>Coucou les petits kiwis</h3>
	
	<small> P.S : J'espere que vous appreciez ce magnifique theme</small>
	</div>

	<%@include file="../../template/footer.html"%>
</body>
</html>