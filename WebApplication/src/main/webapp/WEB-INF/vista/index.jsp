<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!-- Un taglib se utiliza para importar librerías en un código html, generalmente el core es el más utilizado, para usar
el de sql, es igual pero ponniendo sql al final por core 

¿Qué propiedades tiene un bean?
- Propiedades privadas con métodos Getters y Setters
- Constructor público sin parámetros - También podría tener alguno más con parámetros
- Implementar Serializable
-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
 	<h1>Bienvenido al ejercicio SB01</h1>
 	
 	<button onclick="location.href='login';" id="myButton" >Login</button>
 	
 	<h2>Índice de las distintas páginas</h2>
 	<ol>
 		<li><a href="noticia">Noticias</a></li>
 		<li><a href="tecnologia">Tecnología</a></li>
 		<li><a href="comida">Comida</a></li>
 		<li><a href="deporte">Deportes</a></li>
 		<li><a href="economia">Economía</a></li>
 		<li><a href="clima">Clima</a></li> 		
 	</ol>

 		<li><a href="/">Volver al home</a></li>

</body>
</html>