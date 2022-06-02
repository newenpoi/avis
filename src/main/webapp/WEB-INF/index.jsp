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
</head>
<body>
    <form method="post" action="/connexion">
    	<p><c:if test="${param.erreur ne null}">${param.erreur}</c:if></p>
        
        <input type="text" name="pseudo" placeHolder="Pseudo" required>
        <input type="password" name="motDePasse" placeHolder="Mot de Passe" required>
        <input type="submit" value="Connexion">
        
        <a href="/inscription" title="Créer un Nouveau Compte Stargazer.">Inscription</a>
    </form>
</body>
</html>