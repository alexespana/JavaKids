<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario</title>
</head>
<body>

	<h1>Formulario de ingredientes</h1>	
	<form action="procesaFormulario" method="post">
		Introduzca los ingredientes, separador por espacios: <input type="text" name="ingredientes"></br>
		
		<input type="submit" value="Meter ingrediente/s">
	</form>
    
</body>
</html>