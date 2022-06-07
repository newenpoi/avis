<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset='utf-8'>
	<meta http-equiv='X-UA-Compatible' content='IE=edge'>
	<title>${jeu.nom}</title>
	<meta name='viewport' content='width=device-width, initial-scale=1'>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel='stylesheet' type='text/css' media='screen' href='/css/main.css'>
</head>
<body>
	<div class="card border-0 mb-3">
		<div class="card-img-wrapper">
			<img class="card-img-top rounded-0" src="/img/jeux/<c:if test="${jeu.image eq null}">nopreview.gif</c:if>" alt="Image du Jeu">
		</div>
		<div class="card-body">
			<h5 class="card-title">${jeu.nom}</h5>
			<p class="card-text">${jeu.description}</p>
			<p class="card-text">
				<small class="text-muted">Sorti le ${jeu.dateSortie}</small>
			</p>
			<a href="/jeux" title="Retour">Revenir aux Jeux</a>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>