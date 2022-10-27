<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Noticia</title>
</head>
<body>
	<h1>${ noticia.titular }</h1>
	<p>${ noticia.informacion }</p>
	<a href="/">Volver al home</a>	
</body>
</html>