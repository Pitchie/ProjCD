
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript" src="static/js/creerAlbum.js"></script>

<meta charset="utf-8" />
<title>Création d'un album</title>
<link type="text/css" rel="stylesheet" href="static/css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-inverse">
			<div class="navbar-inner">
				<div class="container">
					<ul class="nav">
						<li><a href="/ProjetCD/acceuilCD">Acceuil</a></li>
						<li><a href="/ProjetCD/creationCD">Ajout d'un Album</a></li>
						<li><a href="/ProjetCD/gestionCD">Gestion des Albums</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="text-center">
			<form method="get" action="creationCD">
				<fieldset>
					<h2>Informations Album</h2>
					<div class="text-center">

						<div class="control-group">
							<div class="controls">
								<h4><label for="titre" class="text-warning"> Titre *</label></h4> <input
									type="text" placeholder="Tapez le titre de l'Album" id="titre"
									name="titre" value="" size="20" maxlength="20" />
								<div class="alert alert-error hide">
									<h4 class="alert-heading">Erreur !</h4>
									Vous devez entrer un nom d'Album !
								</div>

								<!-- 								<div class="text-center"> -->
								<!-- 								<select name="album"> -->
								<!-- 									<option></option> -->
								<%-- 									<c:forEach var="" items="${albums}"> --%>
								<%-- 									</c:forEach> --%>
								<!-- 								</select> -->
								<!-- 								</div> -->

								<div class="text-center text-warning"><h5>Choisir une catégorie</h5></div>
								<div>
									<select class="selectpicker" title="toto">
										<option>Rock</option>
										<option>Electro</option>
										<option>Jazz</option>
									</select>
								</div>
							</div>
						</div>
					</div>
				</fieldset>
				<button type="submit" class="btn btn-success">Valider</button>
				<button type="reset" class="btn btn-warning">Remettre à zéro</button>
			</form>
		</div>
	</div>
</body>
</html>