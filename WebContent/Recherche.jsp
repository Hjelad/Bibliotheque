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
<script>
	var livres = [
<%int last = (int) vecteur.lastElement();
			for (int i = vecteur.size() - 1; i >= vecteur.size() - last - 1; i--) {
				if (i == vecteur.size() - last - 1) {
					out.println("\"" + vecteur.elementAt(i) + "\"");
				} else {
					out.println("\"" + vecteur.elementAt(i) + "\",");

				}
			}%>
	]; // ajouter le nom des livres, auteurs
	function autocomplete(inp, arr) {
		/*the autocomplete function takes two arguments,
		the text field element and an array of possible autocompleted values:*/
		var currentFocus;
		/*execute a function when someone writes in the text field:*/
		inp
				.addEventListener(
						"input",
						function(e) {
							var a, b, i, val = this.value;
							/*close any already open lists of autocompleted values*/
							closeAllLists();
							if (!val) {
								return false;
							}
							currentFocus = -1;
							/*create a DIV element that will contain the items (values):*/
							a = document.createElement("DIV");
							a.setAttribute("id", this.id + "autocomplete-list");
							a.setAttribute("class", "autocomplete-items");
							/*append the DIV element as a child of the autocomplete container:*/
							this.parentNode.appendChild(a);
							/*for each item in the array...*/
							for (i = 0; i < arr.length; i++) {
								/*check if the item starts with the same letters as the text field value:*/
								if (arr[i].substr(0, val.length).toUpperCase() == val
										.toUpperCase()) {
									/*create a DIV element for each matching element:*/
									b = document.createElement("DIV");
									/*make the matching letters bold:*/
									b.innerHTML = "<strong>"
											+ arr[i].substr(0, val.length)
											+ "</strong>";
									b.innerHTML += arr[i].substr(val.length);
									/*insert a input field that will hold the current array item's value:*/
									b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
									/*execute a function when someone clicks on the item value (DIV element):*/
									b
											.addEventListener(
													"click",
													function(e) {
														/*insert the value for the autocomplete text field:*/
														inp.value = this
																.getElementsByTagName("input")[0].value;
														/*close the list of autocompleted values,
														(or any other open lists of autocompleted values:*/
														closeAllLists();
													});
									a.appendChild(b);
								}
							}
						});
		/*execute a function presses a key on the keyboard:*/
		inp.addEventListener("keydown", function(e) {
			var x = document.getElementById(this.id + "autocomplete-list");
			if (x)
				x = x.getElementsByTagName("div");
			if (e.keyCode == 40) {
				/*If the arrow DOWN key is pressed,
				increase the currentFocus variable:*/
				currentFocus++;
				/*and and make the current item more visible:*/
				addActive(x);
			} else if (e.keyCode == 38) { //up
				/*If the arrow UP key is pressed,
				decrease the currentFocus variable:*/
				currentFocus--;
				/*and and make the current item more visible:*/
				addActive(x);
			} else if (e.keyCode == 13) {
				/*If the ENTER key is pressed, prevent the form from being submitted,*/
				e.preventDefault();
				if (currentFocus > -1) {
					/*and simulate a click on the "active" item:*/
					if (x)
						x[currentFocus].click();
				}
			}
		});
		function addActive(x) {
			/*a function to classify an item as "active":*/
			if (!x)
				return false;
			/*start by removing the "active" class on all items:*/
			removeActive(x);
			if (currentFocus >= x.length)
				currentFocus = 0;
			if (currentFocus < 0)
				currentFocus = (x.length - 1);
			/*add class "autocomplete-active":*/
			x[currentFocus].classList.add("autocomplete-active");
		}
		function removeActive(x) {
			/*a function to remove the "active" class from all autocomplete items:*/
			for (var i = 0; i < x.length; i++) {
				x[i].classList.remove("autocomplete-active");
			}
		}
		function closeAllLists(elmnt) {
			/*close all autocomplete lists in the document,
			except the one passed as an argument:*/
			var x = document.getElementsByClassName("autocomplete-items");
			for (var i = 0; i < x.length; i++) {
				if (elmnt != x[i] && elmnt != inp) {
					x[i].parentNode.removeChild(x[i]);
				}
			}
		}
		/*execute a function when someone clicks in the document:*/
		document.addEventListener("click", function(e) {
			closeAllLists(e.target);
		});
	}
	function auto() {
		autocomplete(document.getElementById("rechercheEmprunt"), livres);
	}
</script>
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
	border: 1 px solid #d4d4d4;
	border-bottom: none;
	border-top: none;
	z-index: 99;
	/*position the autocomplete items to be the same width as the container:*/
	top: 100%;
	left: 0;
	right: 0;
}

.autocomplete-items div {
	padding: 10 px;
	cursor: pointer;
	background-color: #fff;
	border-bottom: 1 px solid #d4d4d4;
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
	<%--
	En fonction
	des droits de l'utilisateur,
	on affiche
	le menu correspondant--%>
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

				<center></center><form Method="POST"
					action="http://localhost:8080/Bibliotheque/ServletEmprunter">
					<fieldset>
						<!-- Text input-->
						<div class="form-group">
							<div class="col-md-6">
								<div class="autocomplete" style="width: 100%;">
									<input id="rechercheEmprunt" name="rechercheEmprunt"
										type="text" onclick="auto()" placeholder="Ma recherche"
										class="form-control input-md">
								</div>
							</div>
						</div>

						<!-- Button -->
						<div class="form-group">
							<div class="col-md-2">
								<button type="submit" id="recherche" name="recherche"
									class="btn btn-primary">Recherche</button>
							</div>
						</div>
						</center>

					</fieldset>
				</form>


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

								for (int i = 3; i < vecteur.size() - last -1; i = i + 4) {
									out.println("<tr><td>" + vecteur.elementAt(i) + "</td><td>" + vecteur.elementAt(i + 1) + "</td><td>"
											+ vecteur.elementAt(i + 2) + "</td><td>" + vecteur.elementAt(i + 3)
											+ "</td><td class=\"text-center\"><a href=\"http://localhost:8080/Bibliotheque/ServletRendreEmprunt?titre="+vecteur.elementAt(i)+"&auteur="+vecteur.elementAt(i+1) +"&genre="+vecteur.elementAt(i+2)+"&editeur="+vecteur.elementAt(i+3)+"\"class='btn btn-info btn-xs'><span class=\"glyphicon glyphicon-edit\"></span> Emprunter</a></td></tr>");
								}
						%>
						

					</table>
				</form>
			</div>
		</div>
	</div>
	
	
</body>
</html>