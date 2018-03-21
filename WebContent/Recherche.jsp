<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:useBean id='vecteur' scope='request' class='java.util.Vector' />
<%@ page import="java.util.Vector, classes.Personne"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recherche un ouvrage</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="https//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="https//code.jquery.com/jquery-1.11.1.min.js"></script>
<style type="text/css">
* {
	box-sizing: border-box;
}

.autocomplete {
	/*the container must be positioned relative:*/
	position: relative;
	display: inline-block;
}

.autocomplete-items {
	position: absolute;
	border: 1px solid #d4d4d4;
	border-bottom: none;
	border-top: none;
	z-index: 99;
	/*position the autocomplete items to be the same width as the container:*/
	top: 100%;
	left: 0;
	right: 0;
}

.autocomplete-items div {
	padding: 10px;
	cursor: pointer;
	background-color: #fff;
	border-bottom: 1px solid #d4d4d4;
}

.autocomplete-items div:hover {
	/*when hovering an item:*/
	background-color: #e9e9e9;
}

.autocomplete-active {
	/*when navigating through the items using the arrow keys:*/
	background-color: DodgerBlue !important;
	color: #ffffff;
}
</style>

</head>
<body>
	<%-- En fonction des droits de l'utilisateur, on affiche le menu correspondant --%>
	<%
		if (vecteur.elementAt(2).equals(true)) {
	%>
	<%@include file="/html/menuAdmin.html"%>
	<%
		} else {
	%>
	<%@include file="/html/menu.html"%>
	<%
		}
	%>

	<div class="body-wrap">
		<div class="container">
			<div class="row">

				<form Method="POST"
					action="http://localhost:8080/Bibliotheque/ServletEmprunter">
					<fieldset>
						<!-- Text input-->
						<div class="form-group">
							<div class="col-md-6">
								<div class="autocomplete" style="width:100%;">
									<input id="rechercheEmprunt" name="rechercheEmprunt"
										type="text" placeholder="Ma recherche"
										class="form-control input-md">
								</div>
							</div>
							<div class="col-md-2">
								<select id="genre" name="genre" class="form-control">
									<option value=""></option>
									<option value="SF">SF</option>
									<option value="polar">Polar</option>
								</select>
							</div>
							<div class="col-md-2">
								<select id="editeur" name="editeur" class="form-control">
									<option value=""></option>
									<option value="1">Option 1</option>
									<option value="2">Option 2</option>
								</select>
							</div>
						</div>

						<!-- Button -->
						<div class="form-group">
							<div class="col-md-2">
								<button type="submit" id="recherche" name="recherche"
									class="btn btn-primary">Recherche</button>
							</div>
						</div>

					</fieldset>
				</form>


				<div class="row col-md-8 col-md-offset-2 custyle">
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
							if (vecteur.size() != 3) {
						%>
						<tr>
							<td>
								<%
									out.println(vecteur.elementAt(0));
								%>
							</td>
							<td>
								<%
									out.println(vecteur.elementAt(1));
								%>
							</td>
							<td>
								<%
									out.println(vecteur.elementAt(2));
								%>
							</td>
							<td>
								<%
									out.println(vecteur.elementAt(3));
								%>
							</td>
							<td class="text-center"><a href="#"
								class='btn btn-info btn-xs' href="#"><span
									class="glyphicon glyphicon-edit"></span> Emprunter</a></td>
						</tr>
						<%
							}else{
						%>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td class="text-center"><a href="#"
								class='btn btn-info btn-xs' href="#"><span
									class="glyphicon glyphicon-edit"></span> Emprunter</a></td>
						</tr>
						<%
							}
						%>

					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>