<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Stargazer â¢ Inscription</title>
</head>
<body>
    <form method="post" action="/inscription">
    	<c:if test="${erreur ne null}">${erreur}</c:if>
    	
        <input type="text" name="pseudo" placeHolder="Pseudo" required>
        <input type="email" name="email" placeHolder="Adresse Electronique" required>
        <input type="password" name="motDePasse" placeHolder="Mot de Passe" required>
        <input type="date" name="dateDeNaissance" placeHolder="Date de Naissance" required>

        <input type="submit" value="Connexion">
    </form>
</body>
</html>