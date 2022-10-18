import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * EJERCICIO AA7: 
 * 
 * Desarrolle un programa que informe el forecast del tiempo para la semana siguiente utilizando
 * APIS y JSON. El mismo se debe informar en nuestro programa de Jenkins por consola. 
 * 
 * CONSIDERACIONES: 
 * - Subir el proyecto a Github 
 * - Generar un jenkinsfile con la información solicitada 
 * 
 * ENTREGABLES: 
 * - Link del repo donde este el codigo del proyecto 
 * - Captura de pantalla de la consola de Jenkins.
 * 
 */
public class EjercicioAA7 {

	public static void main(String[] args) throws IOException, ParseException {
		
		try {
			// 1. Declarar la URL de la APIREST
			// https://jsonplaceholder.typicode.com/users/4
			URL url = new URL("https://www.el-tiempo.net/api/json/v2/provincias/18");
			
			// 2. Declarar una conexión
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			// 3. Conectarlo
			conn.setRequestMethod("GET");	// voy a obtener información, por eso usamos GET
			conn.connect();
			
			// 4. Obtener el código de respuesta
			int codigoRespuesta = conn.getResponseCode();
			
			if (codigoRespuesta != HttpURLConnection.HTTP_OK) {	// Conexión satisfactoria
				throw new RuntimeException("Respuesta de error: " + codigoRespuesta);
			}
			else {			
				StringBuilder informacionEnString = new StringBuilder();
				
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext()) {
					informacionEnString.append(sc.nextLine());
				}
				sc.close();
				
				// Pasar String a un JSON
				JSONParser parser = new JSONParser();
				JSONObject objetoJSON = (JSONObject) parser.parse( (informacionEnString.toString()) );
				
				objetoJSON = (JSONObject) parser.parse( (objetoJSON.get("today").toString()) );

				String tiempoActual = objetoJSON.get("p").toString();
				
				// Generar código Groovy
				String codigoGroovy = "pipeline {\n" 
									    + "agent any\n"
									    + "stages{\n"
									    +   "stage('Muestra tiempo'){\n"
									    +      "steps{\n"
									    +       "script{\n"
									    +           "println '" + tiempoActual + "'\n"
									    +       "}\n"
									    +   "}\n"
								    	+    "}\n"
								    	+ "}\n"
								    	+	"}";
				
				// Generar Jenkins file
				Path archivo = Paths.get("JenkinsFileAA7");
				
				Files.writeString(archivo, codigoGroovy, StandardCharsets.UTF_8);				
			}
		}
		catch(MalformedURLException e){
			e.printStackTrace();
		}
	}

}

