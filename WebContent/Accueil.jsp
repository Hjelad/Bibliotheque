<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<jsp:useBean id='vecteur' scope='request' class='java.util.Vector' />
<%@ page import="java.util.Vector, classes.Personne"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Accueil</title>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<style>
body {
	font-family: 'PT Sans', sans-serif;
	font-size: 13px;
	font-weight: 400;
	color: #4f5d6e;
	position: relative;
}

.body-wrap {
	min-height: 700px;
}

.body-wrap {
	position: relative;
	z-index: 0;
}

.body-wrap:before, .body-wrap:after {
	content: '';
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
	z-index: -1;
	height: 260px;
}

.body-wrap:after {
	top: auto;
	bottom: 0;
}

nav {
	margin-top: 60px;
	box-shadow: 5px 4px 5px #000;
}

h1, p {
	text-align: center;
}

img {
	display: block;
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>
<body>
	<div class="body-wrap">
		<div class="container">
			<nav class="navbar navbar-inverse" role="navigation">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#" style="margin-right: 20px;"><span
							class="glyphicon glyphicon-home" aria-hidden="true"></span>
							Accueil </a> <a class="navbar-brand" href="#"
							style="margin-right: 20px;"><span
							class="glyphicon glyphicon-search" aria-hidden="true"></span>
							Rechercher un ouvrage</a> <a class="navbar-brand" href="#"
							style="margin-right: 20px;"><span
							class="glyphicon glyphicon-book" aria-hidden="true"></span>
							Rendre un emprunt</a>
					</div>
					<a class="navbar-brand" href="#" style="float: right;"><span
						class="glyphicon glyphicon-off" aria-hidden="true"></span></a>
				</div>
			</nav>
			<div class="row">
				<img src="image/livre.jpg" alt="logo">
				<h1>
					<%		
							out.println("Bienvenue <b>" + vecteur.elementAt(0) + " " + vecteur.elementAt(1) +"</b> !");
						%>
				</h1>
				<p>Ici vous pouvez emprunter un livre ou bien rendre un livre
					que vous avez déjà emprunté !</p>
			</div>
		</div>
	</div>
</body>
</html>