<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Stargazer - Inscription</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel='stylesheet' type='text/css' media='screen' href='/css/main.css'>
	<link rel="icon" type="image/x-icon" href="/img/favicon.png">
</head>
<body>
	<div class="wrapper inscription d-flex justify-content-center align-items-center h-100">
		<form:form modelAttribute="joueur" method="post" action="/inscription" class="form-modal">
			<div class="form-group mb-3">
				<form:label path="pseudo" for="inputPseudo">Pseudo</form:label>
				<form:input path="pseudo" class="form-control" id="inputPseudo" />
				<form:errors path="pseudo" cssClass="erreur" />
			</div>
			
			<div class="form-group mb-3">
				<form:label path="email" for="inputEmail">Email</form:label>
				<form:input path="email" class="form-control" id="inputEmail" />
				<small id="emailHelp" class="form-text text-muted">On partagera ton email avec personne... promis.</small>
				<form:errors path="email" cssClass="erreur" />
			</div>
			
			<div class="form-group mb-3">
				<form:label path="motDePasse" for="inputMotDePasse">Mot de Passe</form:label>
				<form:password path="motDePasse" class="form-control" id="inputMotDePasse" />
				<form:errors path="motDePasse" cssClass="erreur" />
			</div>
			
			<div class="form-group mb-3">
				<form:label path="dateDeNaissance" for="inputDateDeNaissance">Date de Naissance</form:label>
				<form:input path="dateDeNaissance" class="form-control" id="inputDateDeNaissance" />
				<form:errors path="dateDeNaissance" cssClass="erreur" />
			</div>
			
			<form:button class="btn btn-primary font-game font-size-custom text-uppercase w-100">Inscription</form:button>
		</form:form>
	</div>
</body>
</html>