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
 <div class="wrapper">
	<!-- Inclure le header -->
	<%@include file="../../template/header.html"%>


	
    <div class="container">
      <div class="header clearfix">

        
      <h3 class="text-muted" style="float: none; color: rgb(128, 64, 0);"></h3></div>

      <div class="jumbotron" style="background-color: 	rgb(211, 211, 211);">
        <h1 class="display-3">Agence BoVoyage</h1>
        <p class="lead">Bienvenue sur notre nouveau site internet dédié à la réservation de voyages&nbsp;</p>
        <p><a class="btn btn-lg btn-default" href="<c:url value = '/travels'/>" role="button" style="background-color: rgb(144, 238, 144); color: rgb(0, 0, 0);">Nos voyages</a></p>
      </div>

      <div class="row marketing">
        <div class="col-lg-6">
          <h4>Subheading</h4>
          <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>
        </div>

        <div class="col-lg-6">
          <h4>Subheading</h4>
          <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>
          
        </div>
      </div>


    </div>
  
    <div class="push"></div>
  </div>

	<%@include file="../../template/footer.html"%>

</body>
</html>