<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Stargazer</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel='stylesheet' type='text/css' media='screen' href='/css/main.css'>
	<link rel="icon" type="image/x-icon" href="/img/favicon.png">
</head>
<body>
	<div class="wrapper index d-flex justify-content-center align-items-center h-100">
	    <form method="post" action="/connexion" class="form-modal m-3">
	    	<p><c:if test="${param.erreur ne null}">${param.erreur}</c:if></p>
	        
	        <div class="form-group mx-3 mb-3">
	        	<input type="text" name="pseudo" placeHolder="Pseudo" class="form-control" required>
	        </div>
	        
	        <div class="form-group mx-3 mb-3">
	        	<input type="password" name="motDePasse" placeHolder="Mot de Passe" class="form-control" required>
	        </div>
	        
	        <div class="form-group mx-3 mb-3">
	        	<input class="btn btn-primary font-game font-size-custom text-uppercase w-100" type="submit" value="Connexion" >
	        </div>
	        
	        <div class="form-group mx-3 mb-3">
	        	<a class="btn btn-secondary font-game font-size-custom text-uppercase w-100" href="/inscription" title="Créer un Nouveau Compte Stargazer.">Inscription</a>
	        </div>
	    </form>
	</div>
</body>
</html>