<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Stargazer • Ajouter un Avis</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel='stylesheet' type='text/css' media='screen' href='/css/main.css'>
</head>
<body>
    <form method="post" action="/avis/ajouter">
    	<p><c:if test="${param.erreur ne null}">${param.erreur}</c:if></p>
        
       	<label for="selectJeu">Jeu</label>
        <select id="selectJeu" name="jeu">
        	<c:forEach items="${jeux}" var="jeu">
        		<option value="${jeu.id}">${jeu.nom}</option>
        	</c:forEach>
        </select>
        
        <label for="description">Description</label>
        <textarea id="description" name="description" placeHolder="Votre avis doit contenir au moins huit caractères."></textarea>
        
        <label for="selectNote">Note</label>
        <select name="note" id="selectNote">
        	<c:forEach var="i" begin="0" end="20">
        		<option value="${i}">${i}</option>
        	</c:forEach>
        </select>
        
        <input type="submit" value="Valider">
    </form>
</body>
</html>