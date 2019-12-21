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

<title>Admin</title>
</head>
<body>
	<!-- Inclure le header -->
	<%@include file="../../../template/header.html"%>
	
	
	<h2>Administration des Destinations</h2>
	
	<%@include file="../../../template/footer.html"%>
</body>
</html>