
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript" src="/js/creerAlbum.js"></script>

<meta charset="utf-8" />
<title>Création d'un album</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-inverse">
			<div class="navbar-inner">
				<div class="container">
					<ul class="nav">
						<li><a href="acceuil.jsp">Acceuil</a></li>
						<li><a href="creerAlbum.jsp">Ajout d'un Album</a></li>
						<li><a href="gererAlbum.jsp">Gestion des Albums</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="text-center">
			<form method="get" action="creationCD">
				<fieldset>
					<legend>Informations Album</legend>
					<div class="text-center">

						<div class="control-group">
							<div class="controls">
								<label for="titre">Titre <span class="requis">*</span></label> <input
									type="text" placeholder="Tapez le titre de l'Album" id="titre"
									name="titre" value="" size="20" maxlength="20" />
								<div class="alert alert-error hide">
									<h4 class="alert-heading">Erreur !</h4>
									Vous devez entrer un nom d'Album !
								</div>
								<div>
									<select class="selectpicker" title="toto">
										<option>Mustard</option>
										<option>Ketchup</option>
										<option>Relish</option>
									</select>
								</div>
							</div>
						</div>
					</div>
				</fieldset>
				<button type="submit" class="btn">Valider</button>
				<button type="reset" class="btn">Remettre à zéro</button>
			</form>
		</div>
	</div>
</body>
</html>