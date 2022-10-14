package AOP;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class Servicio 
{
	public void informarTiempoBarcelona() throws IOException, ParseException 
	{
		final String BASE_URL = "https://www.el-tiempo.net/api/json/v2/provincias/08";
		try {
				URL url = new URL(BASE_URL);
				
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				
				// 3. Conectarlo
				conn.setRequestMethod("GET");	// voy a obtener información, por eso usamos GET
				conn.connect();

				
				int codigoRespuesta = conn.getResponseCode();
				if (codigoRespuesta != HttpURLConnection.HTTP_OK) {	// Conexión satisfactoria
					throw new RuntimeException("Respuesta de error: " + codigoRespuesta);
				}
				else {
					StringBuilder informacionProvincia = new StringBuilder();
					
					Scanner sc = new Scanner(url.openStream());
					while(sc.hasNext()) {
						informacionProvincia.append(sc.nextLine());
					}
					
					// Cerrar el escaner
					sc.close();
					
					JSONParser parser = new JSONParser();
					JSONObject objetoJSON = (JSONObject) parser.parse( (informacionProvincia.toString()) );
					
					objetoJSON = (JSONObject) parser.parse( (objetoJSON.get("today").toString()) );

					String tiempoActual = objetoJSON.get("p").toString();
					
					System.out.println("Descripción del tiempo Actual de Barcelona: ");
					System.out.println(tiempoActual);
			
					
				}
				
		}
		catch(MalformedURLException e){	
			e.printStackTrace();
		}

				
			
	}
}
