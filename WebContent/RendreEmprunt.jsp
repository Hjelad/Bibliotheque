<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:useBean id='vecteur' scope='request' class='java.util.Vector' />
<%@ page import="java.util.Vector, classes.Personne"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rendre un ouvrage</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
	<%-- En fonction des droits de l'utilisateur, on affiche le menu correspondant --%>
	<% if (vecteur.elementAt(2).equals(true)){%>
	<%@include file="/html/menuAdmin.html"%>
	<%}else{%>
	<%@include file="/html/menu.html"%>
	<%}%>
	<center><h1>Liste des livres empruntés</h1></center>
	<div class="body-wrap">
		<div class="container">
			<div class="row">


				<form class="row col-md-8 col-md-offset-2 custyle">
					<table class="table table-striped custab">
						<thead>
							<tr>
								<th>Titre</th>
								<th>Auteur</th>
								<th>Genre</th>
								<th>Editeur</th>
								<th class="text-center">Action</th>
							</tr>
						</thead>
						<%

								for (int i = 4; i < vecteur.size() -1; i = i + 4) {
									out.println("<tr><td>" + vecteur.elementAt(i) + "</td><td>" + vecteur.elementAt(i + 1) + "</td><td>"
											+ vecteur.elementAt(i + 2) + "</td><td>" + vecteur.elementAt(i + 3)
											+ "</td><td class=\"text-center\"><a href=\"http://localhost:8080/Bibliotheque/ServletRendreEmprunt?titre="+vecteur.elementAt(i)+"&auteur="+vecteur.elementAt(i+1) +"\"class='btn btn-info btn-xs'><span class=\"glyphicon glyphicon-edit\"></span> Rendre</a></td></tr>");
								}
						%>
						

					</table>
				</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
