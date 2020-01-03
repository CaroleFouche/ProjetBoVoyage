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

<title>Login</title>
<link rel="icon" type="image/png" href="<c:url value="/assets/images/kiwi-sized.png"/>" />
</head>
<body>
	<!-- Inclure le header -->
	<%@include file="../../../template/header.html"%>


	<h2>Veuillez vous connecter</h2>

<h4 style="color:red"> ${msg} </h4>

	<form class="form-horizontal container" action="connexion" method="post">
		<div class="form-group">
			<label for="login" class="col-sm-2 control-label">Login</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="login"
					placeholder="Login" name="j_username">
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">Password</label>
			<div class="col-sm-4">
				<input type="password" class="form-control" id="password"
					placeholder="Password" name="j_password">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Sign in</button>
			</div>
		</div>
	</form>
	
	<a href="signup" title="Sign up"><i
						class="fas fa-users-cog"></i> Sign up</a>



</body>
</html>