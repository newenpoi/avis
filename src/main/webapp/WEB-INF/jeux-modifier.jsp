<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Stargazer - Modifier un Jeu</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel='stylesheet' type='text/css' media='screen' href='/css/main.css'>
</head>
<body>
	<c:if test="${not empty errors}">${errors}</c:if>
	<div class="d-flex justify-content-center align-items-center h-100">
		<form:form modelAttribute="jeu" method="post" action="/jeux/modifier" class="w-50">
		
			<!-- Identifiant -->
			<form:hidden path="id" value="${jeu.id}" />
			
			<div class="form-group mb-3">
				<form:label path="nom" for="inputNom">Nom</form:label>
				<form:input path="nom" class="form-control" id="inputNom" placeHolder="Pragmata" />
				<form:errors path="nom" cssClass="erreur" />
			</div>
			
			<div class="form-group mb-3">
				<form:label path="editeur" for="inputEditeur">Éditeur</form:label>
				<form:select path="editeur" class="form-control" id="inputEditeur">
					<form:options items="${editeurs}" itemValue="id" itemLabel="nom" />
				</form:select>
				<form:errors path="editeur" cssClass="erreur" />
			</div>
			
			<div class="form-group mb-3">
				<form:label path="dateSortie" for="inputDateDeSortie">Date de Sortie</form:label>
				<form:input path="dateSortie" class="form-control" id="inputDateDeSortie" />
				<small id="dateDeSortieHelp" class="form-text text-muted">Saisissez la date de sortie au format JJ/MM/AAAA.</small>
				<form:errors path="dateSortie" cssClass="erreur" />
			</div>
			
			<!-- Image -->
			<form:hidden path="image" value="img/jeux/default.png" />
			
			<div class="form-group mb-3">
				<form:label path="description" for="inputDesc">Description</form:label>
				<form:textarea path="description" class="form-control" id="inputDesc"></form:textarea>
				<form:errors path="description" cssClass="erreur" />
			</div>
			
			<div class="form-group mb-3">
				<form:label path="genre" for="inputGenre">Genre</form:label>
				<form:select path="genre" class="form-control" id="inputGenre">
					<form:options items="${genres}" itemValue="id" itemLabel="nom" />
				</form:select>
				<form:errors path="genre" cssClass="erreur" />
			</div>
			
			<div class="form-group mb-3">
				<form:label path="classification" for="inputClassification">Genre</form:label>
				<form:select path="classification" class="form-control" id="inputClassification">
					<form:options items="${classifications}" itemValue="id" itemLabel="nom" />
				</form:select>
				<form:errors path="classification" cssClass="erreur" />
			</div>
			
			<div class="form-group mb-3">
				<form:label path="plateformes" for="inputPlateforme">Genre</form:label>
				<form:select path="plateformes" class="form-control" id="inputPlateforme">
					<form:options items="${plateformes}" itemValue="id" itemLabel="nom" />
				</form:select>
				<form:errors path="plateformes" cssClass="erreur" />
			</div>
			
			<div class="form-group mb-3">
				<form:label path="modeleEconomique" for="inputModeleEconomique">Modèle Économique</form:label>
				<form:select path="modeleEconomique" class="form-control" id="inputModeleEconomique">
					<form:options items="${modelesEconomiques}" itemValue="id" itemLabel="nom" />
				</form:select>
				<form:errors path="modeleEconomique" cssClass="erreur" />
			</div>
			
			<!-- Modérateur -->
			<form:hidden path="moderateur" value="${sessionScope.utilisateur.id}" />
			
			<form:button class="btn btn-primary font-game font-size-custom text-uppercase w-100">Modifier</form:button>
		</form:form>
	</div>
</body>
</html>