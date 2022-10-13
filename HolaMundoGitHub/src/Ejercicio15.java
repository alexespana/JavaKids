import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EJERCICIO 15
 * 
 * 
 * ENUNCIADO: 
 * Desarrollar un programa que genere un archivo de salida (.txt) en formato JSON de la siguiente información: 
 * Top 10 de peliculas historicas y su recaudación
 * LINK con la info: https://www.boxofficemojo.com/chart/ww_top_lifetime_gross/?area=XWW&ref_=bo_cso_ac
 * (!) Tomar todas las columnas menos las porcentuales. (!)
 * 
 * ESTRUCTURA DEL PROGRAMA:
 * - Utilizar composición para la clase Pelicula con sus atributos y luego aplicarla en otra clase
 * para que sea parte del formato del TXT de salida.
 * - El archivo de salida se debe llamar "informaciónPeliculas"
 * - Subir el codigo del proyecto y el txt generado al repositorio de Github (rama de Desarrollo)
 * 
 */
public class Ejercicio15 {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		final String outFile = "informacionPeliculas";
		List<Pelicula> films = new ArrayList<Pelicula>();
		Scanner sc = new Scanner(new File("filmsInfo"));
		
		// Leer la información del fichero de entrada
		String [] dividedLine;
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();			
			dividedLine = line.split("\s{2,}");
		
			long rank = Long.parseLong(dividedLine[0]);
			String name = dividedLine[1];
			long worldwideLifetimeGross = Long.parseLong( dividedLine[2].replace("$", "").replace(",", "") );
			long domesticLifetimeGross = Long.parseLong(dividedLine[3].replace("$", "").replace(",", ""));
			long foreignLifetimeGross = Long.parseLong(dividedLine[4].replace("$", "").replace(",", ""));
			long year = Long.parseLong(dividedLine[5]);
			
			films.add(new Pelicula(rank, name,worldwideLifetimeGross,domesticLifetimeGross,foreignLifetimeGross,year ));
		}
		
		// Crear un cine - Composición
		Cine cinema = new Cine("Mi cine", "Avenida del Sur", films);
		System.out.println(cinema);
		
		
		// Crear un JSON a través de un array de películas
		JSONArray miArray = new JSONArray();
		
		for (int i=0; i<films.size(); i++) {
			
			JSONObject miPelicula = new JSONObject();
			miPelicula.put("rank", films.get(i).getRank());
			miPelicula.put("name", films.get(i).getName());
			miPelicula.put("worldwideLifetimeGross", films.get(i).getWorldwideLifetimeGross());
			miPelicula.put("domesticLifetimeGross", films.get(i).getDomesticLifetimeGross());
			miPelicula.put("foreignLifetimeGross", films.get(i).getForeignLifetimeGross());
			miPelicula.put("year", films.get(i).getYear());

			miArray.add(miPelicula);
		}
		
		// Create and write in the File
		try {
			Path archivo = Paths.get("informaciónPeliculas.JSON");			
			Files.writeString(archivo, miArray.toJSONString(), StandardCharsets.UTF_8);
		}
		catch(IOException e) {
			System.out.println("Obtuviste un error en la creación del archivo");
			e.printStackTrace();
		}	
	}
}
