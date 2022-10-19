import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Ejercicio AA9 integrador
 * 
 * Nos contraron de la empresa aeronáutica Iberia para poder estandarizar y sistematizar la información que
 * tienen hoy en día almacenada en archivos planos. Cuentan con 4 TXTS para sus viajes principales. Además
 * de la información que ya contienen los archivos, nos piden generar la siguiente:
 * - Ganancia neta = cantidad de pasajes vendidos * 50 (50€, valor promedio del pasaje). - 
 * - Cantidad de pasajeros que asistieron al vuelo = cantidad de pasajes vendidos / 2. - 
 * - Implementar interfaces para generar el TOTAL de ganancia. - 
 * - Generar (expresado en euros) el TOTAL de ganacia, en la última línea del TXT. Ganancia TOTAL = Suma de la ganancia NETA. - 
 * - Implementar las siguientes clases: Aerolineas, Vuelos, Vuelo_Aerolineas. - 
 * - Unificar la salida en un solo TXT llamado "resumenVentas_MesAño"
 * - Implementar controles a través de AOP ANTES de ejecutar los métodos que generan la ganancia y la cantidad de pasajeros. (Con un simple WARNING alcanza).
 * - El archivo de salida FINAL se debe llamar "resumenVentas_MesAño"
 * - Subir al repositorio de Github.
 * 
 * ENTREGABLES:
 * - Código del proyecto.
 * - TXT de salida.
 * 
 * 
 */
public class VueloAerolinea {

	public static void main(String[] args) throws IOException {
		String archivoSalida = "resumenVentas_";
		String [] archivosEntrada = {"Barcelona.txt","Berlin.txt","Buenos Aires.txt","Madrid.txt"};
		List<Vuelo> vuelos = new ArrayList<Vuelo>();
		String linea, nombre = null, salida = null;
		int numPasajes = 0;
		
		// Leer los vuelos disponibles
		for (int i=0; i<archivosEntrada.length; i++){
			
			Scanner sc = new Scanner(new File(archivosEntrada[i]), "UTF-8");
			int contador = 0;
			while(sc.hasNextLine()) {
				linea = sc.nextLine();
				
				switch(contador) {
					case 0:
						nombre = linea;
						break;
					case 1:
						numPasajes = Integer.parseInt(linea.split(":")[1].trim());
						break;
					case 2:
						salida = linea.split(":")[1];
						break;
					}
				contador++;
			}
			vuelos.add(new Vuelo(nombre, numPasajes, salida));

			// Cerrar Scanner
			sc.close();
		}
		
		// Crear Aerolínea
		Aerolinea Iberia= new Aerolinea("Iberia","Madrid", vuelos);
		
		// Crear archivo de salida
		int mes = LocalDate.now().getMonthValue();
		int año = LocalDate.now().getYear();
		
		Path archivo = Paths.get(archivoSalida + mes + año + ".txt");
		Files.writeString(archivo, Iberia.toString(), StandardCharsets.UTF_8);
	}

}
