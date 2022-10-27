<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>	
	<form action="procesarLogin" method="get">
		Nombre de usuario: <input type="text" name="nombreUsuario"></br>
		Contraseña: <input type="password" name="password"></br>
		<input type="submit" value="Iniciar sesión">
	</form>
	
	<c:if test="${correcto=='0'}">
        <h2>Todavía no has iniciado sesión.</h2> 
        <br />	
	</c:if>
	<c:if test="${correcto=='1'}">
        <h2>El registro ha sido correcto.</h2> 
        <br />	
	</c:if>
	<c:if test="${correcto=='2'}">
        <h2>El registro no ha sido correcto. Vuelve a intentarlo</h2> 
        <br />	
	</c:if>
	
	<a href="/">Volver al home</a>
		
        <jsp:scriptlet>
            String[] windows = {"Bicicleta", "Moto", "Coche", "Barco", "Avión"};
            pageContext.setAttribute("windows", windows);
        </jsp:scriptlet>

        <%-- JSTL foreach tag example to loop an array in jsp --%>
        <c:forEach var="window" items="${pageScope.windows}"> 
            <h1>"${window}"</h1>
        </c:forEach>
        
		
</body>
</html>