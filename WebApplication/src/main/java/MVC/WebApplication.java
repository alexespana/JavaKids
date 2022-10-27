package MVC;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 * EJERCICIO SB01
 *  
 * - Desarrolle una pagina Web con la siguiente funcionalidad:
 * 
 * Secciones:
 * - Seccion de Noticias (en .jsp)
 * - Seccion de Tecnologia (en .jsp)
 * - Seccion de Comida (en .jsp)
 * - Seccion de Deportes (en .jsp)
 * - Seccion de Economia (en .jsp)
 * - Seccion del clima  (en .jsp)
 * - Seccion de Bienivenida al usuario (donde se realizara el login)  (en .jsp)
 * - Index (en .jsp)
 * 
 * FUNCIONALIDES DEL PROGRAMA:
 * - Desarrollar la API del clima acorde a la ciudad actual
 * - Diseñe una clase llamada Usuario que tenga atributos propios de los usuarios, por ejemplo:
 * Nombre
 * Apellido
 * Nombre de usuario
 * Email
 * Localidad
 * Fecha de nacimiento
 * 
 * - Diseñar una clase para cada una de las secciones de la pagina.
 * - Implementar una noticia/articulo/receta en cada una de las clases, para luego implementarlas en los .jsp
 * - La sección de usuario va a tener un boton de login, donde se va a validar si el usuario existe en base al txt que
 * almacene los usuarios
 * - Desarrollar un TXT que almacene la información de la clase Usuarios
 * - El txt se debe llamar "loginUsuarios.txt"
 * 
 * ACLARACION:
 * (!) Desarrollar 3 usuarios por lo menos. (!)




ENTREGABLES:
- Codigo del proyecto.
 */

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) throws ParseException, IOException {
		SpringApplication.run(WebApplication.class, args);
		String credentials ="";
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		// Crear los tres usuarios
		for(int i=0; i<3;i++) {
			usuarios.add(new Usuario("Nombre_" + i,"Apellido_" + i, "NombreUsuario_" + i, "email_" + i, "localidad_" + i, LocalDate.now(), "password_"+i ));
			credentials += usuarios.get(i).toString() + "\n";
		}
		
		// Crear fichero de credenciales de usuarios (nombre de usuario - password)
		try {		
			Path archivo = Paths.get("users_" + LocalDate.now() + ".txt");
			Files.writeString(archivo, credentials, StandardCharsets.UTF_8);
		}
		catch(IOException e) {
			System.out.println("Obtuviste un error en la creación del archivo");
			e.printStackTrace();
		}
	}

}
