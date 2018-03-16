<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=uft-8">
<title>Auteur ajouté</title>
<jsp:useBean id="auteur" scope='request' class='classe.Auteur' />
</head>
<body>
	<% out.println("<p>" +  auteur.toString() + "</p>"); %>
</body>
</html>