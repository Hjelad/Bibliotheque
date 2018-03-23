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
	<div class="body-wrap">
		<div class="container">
			<div class="row">


				<div class="row col-md-6 col-md-offset-2 custyle">
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
						<tr>
							<td>L'avare</td>
							<td>Molière</td>
							<td>Comédie</td>
							<td>Louis XIV</td>
							<td class="text-center"><a href="./rendre_livre.html?id=1 "
								class='btn btn-info btn-xs'><span
									class="glyphicon glyphicon-send"></span> Rendre</a></td>
						</tr>
						<tr>
							<td>Relou le cours</td>
							<td>la prof</td>
							<td>Tragédie</td>
							<td>Maige</td>
							<td class="text-center"><a href="#"
								class='btn btn-info btn-xs' href="#"><span
									class="glyphicon glyphicon-send"></span> Rendre</a></td>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
