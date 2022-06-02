<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset='utf-8'>
	<meta http-equiv='X-UA-Compatible' content='IE=edge'>
	<title>Stargazer • Jeux</title>
	<meta name='viewport' content='width=device-width, initial-scale=1'>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel='stylesheet' type='text/css' media='screen' href='/css/main.css'>
</head>
<body>
	<h1 class="font-game text-uppercase">Liste des Jeux</h1>
	<table class="table">
		<thead class="thead thead-dark">
			<tr>
				<th scope="col">#</th>
				<th scope="col">Image</th>
				<th scope="col">Nom de Jeu <a href="" title=""><img class="icon icon-s" src="/img/sort.png" alt="Trier"></a></th>
				<th scope="col">Éditeur <a href="" title=""><img class="icon icon-s" src="/img/sort.png" alt="Trier"></a></th>
				<th scope="col">Opérations</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${jeux}" var="jeu" varStatus="boucle">
				<tr>
					<th scope="row">${boucle.count}</th>
					<td>${jeu.image}</td>
					<td>${jeu.nom}</td>
					<td>${jeu.editeur.nom}</td>
					<td>
						<a href="#" title="Voir">Visualiser</a>
						<a href="#" title="Modifier">Modifier</a>
						<a href="#" title="Téléverser une Image">Téléverser une Image</a>
						<a href="#" title="Supprimer">Supprimer</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<ul class="list-group list-group-horizontal">
		<li class="list-group-item"><a href="/jeux/ajouter" title="Ajouter un Jeu">Ajouter un Jeu</a></li>
		<li class="list-group-item"><a href="/avis" title="Liste des Avis">Liste des Avis</a></li>
	</ul>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>