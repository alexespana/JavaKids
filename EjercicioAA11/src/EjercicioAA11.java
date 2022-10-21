import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
 * Somos parte del equipo de una empresa de tecnologia y en el marco de un proyecto de transformación digital
 * nos piden que generemos un programa que gestione la información de los usuarios. Hoy en día el sistema que esta
 * funcionando tiene un archivo plano por cada pais y se busca unificar los criterios llevando toda la información fragmentada
 * en 1 solo archivo. De la información se busca calcular lo siguiente: 
 * - Antiguedad del usuario (Calculo en base a su fecha de registro y la fecha actual)
 * - Segmento del usuario: Para los usuarios que hayan comprado entre 1 y 5 productos se los denomina "Estandar User" Entre 6 y 10 productos
 * "Affiliate" Mas que 11 productos "Premier"
 * - Status del usuario: Para usuarios que no se loguean hace mas de 2 años se los considera "Inactivos" para los demas "Activos"
 * - Edad del usuario: Calculo entre la fecha de nacimiento y la fecha actual
 * 
 * Una vez calculado eso, unificar tambien el resto de la información en 1 solo archivo de salida para cada usuario.
 * 
 * ESTRUCTURA DEL PROGRAMA:
 * - Debe contar con 4 interfaces, una para cada una de las acciones que se deben realizar. Cada una debe emplear una
 * funcion distinta
 * - Aplicar herencia entre las clases Usuario y Persona. Esto no significa que no pueda haber mas clases, porque pueden
 * haber mas clases.
 * - (!) La información de salida no puede tener valores DUPLICADOS (!)
 * 
 * ENTREGABLES: 
 * - Codigo del proyecto
 * - TXT de salida final llamado "informeDiario_fechaDeHoy"
 * 
 * CONSIDERACIONES:
 * - Se puede manipular la estructura de los TXT para ayudar al programa
 * - No se puede utilizar do/while
 * 
 */
public class EjercicioAA11 {

	public static void main(String[] args) throws IOException {
		String [] nombreArchivos = {"USUARIOS1", "USUARIOS2", "USUARIOS3"};
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		// Leer desde los archivos los usuarios
		for(int i=0; i<nombreArchivos.length; i++) {
			
			try (Scanner scan = new Scanner(new File(nombreArchivos[i]), "UTF-8")) {
				
				while(scan.hasNextLine()) {
					String line = scan.nextLine();
					
					if (!line.contains("Nombre")) {
						String [] lineaDividida = line.split("\s{2,}");
						
						// Formato en el que tenemos la fecha
						DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");	
						
						String nombre = lineaDividida[0];
						LocalDate fechaNacimiento = LocalDate.parse(lineaDividida[1], fmt);		
						LocalDate fechaRegistro = LocalDate.parse(lineaDividida[2], fmt);
						LocalDate fechaLogin = LocalDate.parse(lineaDividida[3], fmt);
						int cantidadCompras = Integer.parseInt(lineaDividida[4].trim());
						String pais = lineaDividida[5];
						
						// Lista de usuarios
						usuarios.add(new Usuario(nombre, fechaNacimiento, fechaRegistro, fechaLogin, cantidadCompras, pais));
					}

				}
				
			}
			catch(IOException e) {
				e.printStackTrace();
			}			
		}

		// Set de elementos no repetidos, evistamos usuarios repetidos
		Set<String> salidaUsuarios = new HashSet<String>();

		// Generar archivo de salida unificado
		for(int i=0; i<usuarios.size(); i++){
			salidaUsuarios.add(usuarios.get(i).toString());
		}
		
		Path archivo = Paths.get("informeDiario_" + LocalDate.now() );
		Files.write(archivo, salidaUsuarios, StandardCharsets.UTF_8);		
	}

}
