<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Gestion des albums</title>
<link type="text/css" rel="stylesheet" href="static/css/bootstrap.css" />
<link type="text/css" rel="stylesheet" href="static/css/style.css" />
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
			<form method="get" action="gestionCD">
				<fieldset>
					<div class="text-center">
						<h4>Liste des morceaux</h4>
					</div>

					<div class="text-center">
						<select name="current">
							<c:forEach items="${liste}" var="item">${item}<br>
								<option>${item}</option>
							</c:forEach>
						</select>
					</div>

					<div class="text-center">
						<button name="status" value="delete" type="submit"
							class="btn btn-primary">
							<i class="icon-trash icon-white"></i> <span><strong>Delete</strong></span>
						</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>