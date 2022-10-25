package MVC;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * EJERCICIO AA15:
EJERCICIO AA16 Desarrollar un sitio web que provea información sobre tu ciudad actual, la cual es la
siguiente: 
- Tiempo actual (a traves del desarrollo de una API) en la sección Tiempo 
- Una foto actual de su ciudad en la sección Imagenes 
- Una pagina de Inicio que relacione las otras secciones 
- Una sección Noticias que contenga la ultima noticia relevante de tu ciudad actual 
- Sección Economia que informe la ultima noticia relevante de Economia asociada a su localidad actual 
- Sección Amor que muestre la foto de una pareja.
 */

@SpringBootApplication
public class EjercicioAA16Application {

	public static void main(String[] args) throws IOException, ParseException {
		SpringApplication.run(EjercicioAA16Application.class, args);
		String URLS = "https://api.open-meteo.com/v1/forecast?latitude=37.1882&longitude=-3.6066&hourly=temperature_2m"; 
		double temperatura = 0.0;
		
				// Llamar a la API
		try {
			//--------------------------------------
			// Conexión con la API
			URL url = new URL(URLS);
			
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
				
				objetoJSON = (JSONObject) parser.parse( (objetoJSON.get("hourly").toString()) );
				JSONArray miArray = (JSONArray) parser.parse( (objetoJSON.get("temperature_2m").toString()) );

				// Calcular temperatura media -> [2.3, 4.32, 5.9, 1.21, 4, 2.2]
				double media = 0.0;
				int cont2 = 0;
				while(cont2 < miArray.size()) {
					media = media + Double.parseDouble(miArray.get(cont2).toString());		
					cont2++;
				}
				
				media = media/miArray.size();
				temperatura = Math.round(media * 100) / 100d;
				
				System.out.println("La temperatura de mi ciudad es " + temperatura +"ºC." );
			}
		}
		catch(MalformedURLException e){
			e.printStackTrace();
		}
		
	}
}
