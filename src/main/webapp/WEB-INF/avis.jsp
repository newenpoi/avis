<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset='utf-8'>
	<meta http-equiv='X-UA-Compatible' content='IE=edge'>
	<title>Stargazer • Avis</title>
	<meta name='viewport' content='width=device-width, initial-scale=1'>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel='stylesheet' type='text/css' media='screen' href='/css/main.css'>
</head>
<body>
	<h1 class="font-game text-uppercase">Liste des Avis</h1>
	<table class="table">
		<thead class="thead thead-dark">
			<tr>
				<th scope="col">#</th>
				<th scope="col">Date Envoi <a href="/avis?sort=dateEnvoi" title=""><img class="icon icon-s" src="/img/sort.png" alt="Trier"></a></th>
				<th scope="col">Nom de Jeu <a href="/avis?sort=jeu.nom" title=""><img class="icon icon-s" src="/img/sort.png" alt="Trier"></a></th>
				<th scope="col">Pseudo du Joueur <a href="/avis?sort=joueur.pseudo" title=""><img class="icon icon-s" src="/img/sort.png" alt="Trier"></a></th>
				<th scope="col">Note <a href="/avis?sort=note" title=""><img class="icon icon-s" src="/img/sort.png" alt="Trier"></a></th>
				<th scope="col">Image</th>
				<th scope="col">Statut</th>
				<th scope="col">Opération</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${avis.content}" var="item" varStatus="boucle">
				<tr>
					<th scope="row">${boucle.count}</th>
					<td>${item.dateEnvoi}</td>
					<td>${item.jeu.nom}</td>
					<td>${item.joueur.pseudo}</td>
					<td>${item.note}</td>
					<td>${item.jeu.image}</td>
					<td>
						<c:if test="${item.dateModeration eq null}">En Attente...</c:if>
						<c:if test="${item.dateModeration ne null}">Modéré Par ${item.moderateur}</c:if>
					</td>
					<td><a href="#" title="Voir cet Avis">Visualiser</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<ul class="list-group list-group-horizontal">
		<li class="list-group-item"><a href="/avis/ajouter" title="Ajouter un Avis">Ajouter un Avis</a></li>
		<li class="list-group-item"><a href="/jeux" title="Voir la Liste des Jeux">Liste des Jeux</a></li>
		<li class="list-group-item"><a href="/deconnexion" title="Déconnexion">Déconnexion</a></li>
		<li class="list-group-item"><c:if test="${sessionScope.utilisateur ne null}">Salutations, ${sessionScope.utilisateur.pseudo} !</c:if></li>
	</ul>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>