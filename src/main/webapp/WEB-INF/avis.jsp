<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Stargazer • Avis</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel='stylesheet' type='text/css' media='screen'
	href='/css/main.css'>
</head>
<body>
	<h1>Salutations, ${sessionScope.joueur.pseudo} !</h1>
	<table class="table">
		<thead class="thead thead-dark">
			<tr>
				<th scope="col">#</th>
				<th scope="col">Date Envoi <a href="" title=""><img class="icon icon-s" src="/img/sort.png" alt="Trier"></a></th>
				<th scope="col">Nom de Jeu <a href="" title=""><img class="icon icon-s" src="/img/sort.png" alt="Trier"></a></th>
				<th scope="col">Pseudo du Joueur <a href="" title=""><img class="icon icon-s" src="/img/sort.png" alt="Trier"></a></th>
				<th scope="col">Note <a href="" title=""><img class="icon icon-s" src="/img/sort.png" alt="Trier"></a></th>
				<th scope="col">Image</th>
				<th scope="col">Statut</th>
				<th scope="col">Opération</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">1</th>
				<td>01/06/2022</td>
				<td>Spyro</td>
				<td>Chong</td>
				<td>18</td>
			</tr>
			
			<tr>
				<th scope="row">2</th>
				<td>01/06/2022</td>
				<td>Rayman</td>
				<td>Bien Phu</td>
				<td>17</td>
			</tr>
			
			<tr>
				<th scope="row">3</th>
				<td>01/06/2022</td>
				<td>Soul Worker</td>
				<td>Newonche</td>
				<td>19</td>
			</tr>
		</tbody>
	</table>
	<ul class="list-group list-group-horizontal">
		<li class="list-group-item"><a href="/avis/ajouter" title="Ajouter un Avis">Ajouter un Avis</a></li>
		<li class="list-group-item"><a href="/deconnexion" title="Déconnexion">Déconnexion</a></li>
	</ul>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>