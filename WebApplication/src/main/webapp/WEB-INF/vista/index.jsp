<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!-- Un taglib se utiliza para importar librer�as en un c�digo html, generalmente el core es el m�s utilizado, para usar
el de sql, es igual pero ponniendo sql al final por core 

�Qu� propiedades tiene un bean?
- Propiedades privadas con m�todos Getters y Setters
- Constructor p�blico sin par�metros - Tambi�n podr�a tener alguno m�s con par�metros
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
 	
 	<h2>�ndice de las distintas p�ginas</h2>
 	<ol>
 		<li><a href="noticia">Noticias</a></li>
 		<li><a href="tecnologia">Tecnolog�a</a></li>
 		<li><a href="comida">Comida</a></li>
 		<li><a href="deporte">Deportes</a></li>
 		<li><a href="economia">Econom�a</a></li>
 		<li><a href="clima">Clima</a></li> 		
 	</ol>

 		<li><a href="/">Volver al home</a></li>

</body>
</html>