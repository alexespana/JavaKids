package AOP;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * EJERCICIO AA1:
 * 
 * Desarrollar una aplicación que implemente el paradigma de programación orientada a aspectos. El programa debe
 * poder informar ANTES de que se realice la acción, la fecha en la cual se realizo, el formato de la fecha
 * debe ser AA/MM/DD Horas Minutos Segundos
 * 
 * ¿Qué debe hacer el programa?
 * El programa debe informar del estado del tiempo en la ciudad de Barcelona. Y antes de informarse se debe
 * ejecutar el mensaje de la hora de ejecución a través de AOP.
 * 
 * ENTREGABLES:
 * - Link del repositorio a Github
 * - Captura de pantalla. 
 */
public class EjercicioAA1 {

	public static void main(String[] args) throws IOException, ParseException {
		final String API_URL = "https://www.el-tiempo.net/api/json/v2/provincias/08";
		
		try {
			URL url = new URL(API_URL);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");	// voy a obtener información, por eso usamos GET
			conn.connect();		
			
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
				
				JSONParser parser = new JSONParser();
				JSONObject objetoJSON = (JSONObject) parser.parse( (informacionEnString.toString()) );
				
				objetoJSON = (JSONObject) parser.parse( (objetoJSON.get("today").toString()) );
				String tiempoActual = objetoJSON.get("p").toString();				
			}
		}
		catch(MalformedURLException e){
			e.printStackTrace();
		}
	}

}
