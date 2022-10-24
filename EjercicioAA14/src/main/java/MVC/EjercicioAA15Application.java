package MVC;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * EJERCICIO AA15:
 * A su pagina web debe agregarle las siguientes funcionalides:
 * - Almacenar en un TXT los siguientes datos de los usuarios:
 * - Nombre Usuario
 * - Contraseña
 * - Email
 * 
 * Generar esta funcionalidad a traves de una interfaz que se llame generaUsuario() para al menos 5 usuarios. 
 * El txt se debe llamar usuarios.txt
 */

@SpringBootApplication
public class EjercicioAA15Application implements GenerarUsuarios {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioAA15Application.class, args);
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		EjercicioAA15Application e = new EjercicioAA15Application();
		usuarios = e.generarUsuario(5);
		
		String out="";
		for( Usuario u : usuarios) {
			out += u.toString();
		}
		
		// Crear archivo salida
		String nombreArchivo = "usersInfo.txt";
		
		try {
			Path archivo = Paths.get(nombreArchivo);
			Files.writeString(archivo, out, StandardCharsets.UTF_8);
		}
		catch(IOException error) {
			System.out.println("Obtuviste un error en la creación del archivo de salida");
			error.printStackTrace();
		}
	}

	@Override
	public List<Usuario> generarUsuario(int numUsers) {
		List<Usuario> usuarios = new ArrayList<Usuario>();

		
		for(int i=0; i<numUsers; i++) {
			usuarios.add(new Usuario("user_" + i, "password_" + i, "user_" + i + "@gmail.com"));
		}
		
		return usuarios;
	}

}
