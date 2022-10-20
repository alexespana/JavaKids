import java.io.File;
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

public class EjercicioAA10 {

	public static void main(String[] args) throws IOException, ParseException {
		double [] temperaturas = new double[2]; 
		List<Empresa> empresas = new ArrayList<Empresa>();
		List<List<Producto>> lista_productos = new ArrayList<List<Producto>>();
		String [] ficherosEntrada = {"productosMadrid.txt", "productosBarcelona.txt"};
		String [] URLS = {"https://api.open-meteo.com/v1/forecast?latitude=40.4167&longitude=-3.7033&hourly=temperature_2m", 
						  "https://api.open-meteo.com/v1/forecast?latitude=41.3887&longitude=2.159&hourly=temperature_2m"};
		
		int cont = 0;
		while(cont < URLS.length) {
			// Leer productos de la empresa
			Scanner scan = new Scanner(new File(ficherosEntrada[cont]), "UTF-8");	
			List<Producto> productos = new ArrayList<Producto>();
			
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				String [] lineaDividida = line.split("\t");
				
				// Lista de productos
				productos.add(new Producto(lineaDividida[0],
										   Integer.parseInt(lineaDividida[1]),
										   Integer.parseInt(lineaDividida[2]), 
										   Integer.parseInt(lineaDividida[3])
										  )
							 );	
			}
			
			//Lista de listas de Producto
			lista_productos.add(productos);		
			
			scan.close();
			
			try {
				//--------------------------------------
				// Conexión con la API
				URL url = new URL(URLS[cont]);
				
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
					temperaturas[cont] = Math.round(media * 100) / 100d;
				}
			}
			catch(MalformedURLException e){
				e.printStackTrace();
			}
			
			cont++;
		}
				
		// Crear empresas
		empresas.add(new EmpresaMadrid("Madrid","Madrid", lista_productos.get(0)));
		empresas.add(new EmpresaBarcelona("Barcelona", "Barcelona", lista_productos.get(1)));
		
		
		// Crear archivos de salida 
		cont = 0;
		while(cont<URLS.length) {
			Path archivo = Paths.get("prodDia_" + empresas.get(cont).getNombre() + LocalDate.now());
			
			String salida = empresas.get(cont).toString();
			salida += empresas.get(cont).informarActividades(temperaturas[cont]);
			Files.writeString(archivo, salida, StandardCharsets.UTF_8);

			cont++;
		}
		
	}

}
