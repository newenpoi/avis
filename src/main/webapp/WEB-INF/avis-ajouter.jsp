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
	<div class="wrapper d-flex justify-content-center align-items-center h-100">
	    <form method="post" action="/avis/ajouter" class="form-modal m-3">
	    	<p><c:if test="${param.erreur ne null}">${param.erreur}</c:if></p>
	        
	        <div class="form-group mx-3 mb-3">
		       	<label for="selectJeu">Jeu</label>
		        <select class="form-control" id="selectJeu" name="jeu">
		        	<c:forEach items="${jeux}" var="jeu">
		        		<option value="${jeu.id}">${jeu.nom}</option>
		        	</c:forEach>
		        </select>
	        </div>
	        
	        <div class="form-group mx-3 mb-3">
	        	<label for="description">Description</label>
	        	<textarea rows="8" class="form-control" id="description" name="description" placeHolder="Votre avis doit contenir au moins huit caractères."></textarea>
	        </div>
	        
	        <div class="form-group mx-3 mb-3">
	        	<label for="selectNote">Note</label>
	        	<input class="form-control" type="number" min="0" step="0.5" max="20" name="note" placeHolder="Ex : 15.5 ou 16.">
	        	<small id="noteHelp" class="form-text text-muted">Spécifiez la note / 20.</small>
	        </div>
	        
	        <div class="form-group mx-3 mb-3">
	        	<input class="btn btn-primary font-game w-100" type="submit" value="VALIDER">
	        </div>
	    </form>
    </div>
</body>
</html>