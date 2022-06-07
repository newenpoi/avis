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
	<link rel="icon" type="image/x-icon" href="/img/favicon.png">
</head>
<body>
	<header class="d-flex justify-content-between p-4 bg-blue">
		<h1 class="font-game text-uppercase m-0"><a href="/jeux" title="Liste des Jeux">Liste des Jeux</a></h1>
		<ul class="list-group list-group-horizontal">
			<li class="list-group-item"><a href="/jeux?numPage=0&sort=${sort}" title="Début">Début</a></li>
			
			<c:if test="${jeux.hasPrevious()}">
				<li class="list-group-item"><a href="/jeux?numPage=${jeux.number - 1}&sort=${sort}" title="Précédent">Jeux Précédents</a></li>
			</c:if>
			
			<li class="list-group-item">Page ${jeux.number + 1}</li>
			
			<c:if test="${jeux.hasNext()}">
				<li class="list-group-item"><a href="/jeux?numPage=${jeux.number + 1}&sort=${sort}" title="Suivant">Jeux Suivants</a></li>
			</c:if>
			
			<li class="list-group-item"><a href="/jeux?numPage=${jeux.getTotalPages() - 1}&sort=${sort}" title="Fin">Fin</a></li>
		</ul>
	</header>
	<div class="wrapper-table">
		<table class="table">
			<thead class="thead thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Image</th>
					<th scope="col">Nom de Jeu <a href="/jeux?sort=nom" title=""><img class="icon icon-s" src="/img/sort.png" alt="Trier"></a></th>
					<th scope="col">Éditeur <a href="/jeux?sort=editeur.nom" title=""><img class="icon icon-s" src="/img/sort.png" alt="Trier"></a></th>
					<th scope="col">Opérations</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${jeux.content}" var="jeu" varStatus="boucle">
					<tr>
						<th scope="row">${boucle.count}</th>
						<td>${jeu.image}</td>
						<td>${jeu.nom}</td>
						<td>${jeu.editeur.nom}</td>
						<td>
							<a href="/jeux/voir?idJeu=${jeu.id}" title="Voir">Visualiser</a>
							
							<c:if test="${sessionScope.utilisateur.getClass().getSimpleName() eq 'Moderateur'}">
								<a href="/jeux/modifier?idJeu=${jeu.id}" title="Modifier">Modifier</a>
								<a href="#" title="Téléverser une Image">Téléverser une Image</a>
								<a href="/jeux/supprimer?idJeu=${jeu.id}" title="Supprimer">Supprimer</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<ul class="list-group list-group-horizontal">
			<c:if test="${sessionScope.utilisateur.getClass().getSimpleName() eq 'Moderateur'}">
				<li class="list-group-item"><a href="/jeux/ajouter" title="Ajouter un Jeu">Ajouter un Jeu</a></li>
			</c:if>
			
			<li class="list-group-item"><a href="/avis" title="Liste des Avis">Liste des Avis</a></li>
		</ul>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>