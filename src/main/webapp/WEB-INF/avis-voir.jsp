<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Avis de ${avis.joueur.pseudo}.</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel='stylesheet' type='text/css' media='screen' href='/css/main.css'>
	<link rel="icon" type="image/x-icon" href="/img/favicon.png">
</head>
<body>
	<!-- En attente de modération. -->
	<div class="wrapper d-flex justify-content-center align-items-center h-100">
		<fmt:setTimeZone value="GMT+1" />
		<fmt:parseDate value="${avis.dateEnvoi}" pattern="yyyy-MM-dd'T'HH:mm" var="dateEnvoiAnalysee" type="both" />
		<fmt:parseDate value="${avis.dateModeration}" pattern="yyyy-MM-dd'T'HH:mm" var="dateModerationAnalysee" type="both" />
		
		<c:if test="${avis.dateModeration eq null}">
			<div class="avis">
				<p>Pseudo : ${avis.joueur.pseudo}</p>
				<p>Titre du Jeu : ${avis.jeu.nom}</p>
				<p>Note attribuée : ${avis.note} / 20</p>
				<p>${avis.description}</p>
				
				<p>Publié le <fmt:formatDate value="${dateEnvoiAnalysee}" pattern="dd/MM/yyyy à HH:mm:ss" />.</p>
				
				<p>En attente de modération...</p>
				
				<c:if test="${sessionScope.utilisateur.getClass().getSimpleName() eq 'Moderateur'}">
					<a href="/avis/valider?idAvis=${avis.id}" title="Valider cet Avis">Valider</a>
					<a href="/avis/refuser?idAvis=${avis.id}" title="Refuser cet Avis">Refuser</a>
				</c:if>
				
				<a href="/avis" title="Retour">Revenir aux Avis</a>
			</div>
		</c:if>
		
		<!-- Avis déjà modéré. -->
		<c:if test="${avis.dateModeration ne null}">
			<div class="avis">
				<p>Joueur : ${avis.joueur.pseudo}</p>
				<p>Titre du Jeu : ${avis.jeu.nom}</p>
				<p>${avis.description}</p>
				<p>Publié le <fmt:formatDate value="${dateEnvoiAnalysee}" pattern="dd/MM/yyyy à HH:mm:ss" />.</p>
				<p>Modéré par ${avis.moderateur.pseudo} le <fmt:formatDate value="${dateModerationAnalysee}" pattern="dd/MM/yyyy à HH:mm:ss" />.</p>
				<a href="/avis" title="Retour">Revenir aux Avis</a>
			</div>
		</c:if>
	</div>
</body>
</html>