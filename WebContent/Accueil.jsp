<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:useBean id='vecteur' scope='request' class='java.util.Vector' />
<%@ page import="java.util.Vector, classes.Personne"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>

</head>
<body>
	<%-- En fonction des droits de l'utilisateur, on affiche le menu correspondant --%>
	<% if (vecteur.elementAt(2).equals(true)){%>
	<%@include file="/html/menuAdmin.html"%>
	<%}else{%>
	<%@include file="/html/menu.html"%>
	<%}%>
	
	<div class="row">
		<img src="image/livre.jpg" alt="logo">
		<h1>

			<%		
							out.println("Bienvenue <b >" + vecteur.elementAt(0) + " " + vecteur.elementAt(1) +"</b> !");
						%>

		</h1>
		<p>Ici vous pouvez emprunter un livre ou bien rendre un livre que
			vous avez déjà emprunté !</p>
	</div>
	</div>
	</div>
</body>
</html>