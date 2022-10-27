package MVC;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MyController {

	@GetMapping("/")
	public String home() {
		
		return "index";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("correcto", 0);
		
		return "login";
	}
	
	@RequestMapping("/procesarLogin")
	public String otroProcesoFormulario(@RequestParam("nombreUsuario") String nombre, @RequestParam("password") String password, Model modelo) {
		int correcto = 0;
		boolean salir = false;
		
		// Comprobar si existe en el fichero de credenciales
		try (Scanner scan = new Scanner(new File("users_" + LocalDate.now() + ".txt"), "UTF-8")) {
			
			while(scan.hasNextLine() && !salir) {
				String line = scan.nextLine();
				
				if(line.contains(nombre) && line.contains(password)) {
					salir = true;
					correcto = 1;
				}
				else {
					correcto = 2;					
				}
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		// Agregar información al modelo
		modelo.addAttribute("correcto", correcto);
		
		return "login";
	}
	
	@GetMapping("/noticia")
	public String muestraNoticias(Model model) {
		Noticia noticia = new Noticia("Indra, the best company", "Indra es una de las mejores empresas del mundo");
		
		model.addAttribute("noticia", noticia);
		
		return "noticia";
	}
	
	@GetMapping("/tecnologia")
	public String muestraTecnologia(Model model) {
		Tecnologia tecnologia = new Tecnologia("Nuevo Iphone 14", "Iphone se lanza a su último invento");

		model.addAttribute("tecnologia", tecnologia);
		
		
		return "tecnologia";
	}
	
	@GetMapping("/comida")
	public String muestraComida(Model model) {
		Comida comida = new Comida("Gazpacho", "Tomate, aceite, pepino");

		model.addAttribute("comida", comida);
		
		return "comida";
	}
	
	@GetMapping("/deporte")
	public String muestraDeporte(Model model) {
		Deporte deporte = new Deporte("Futbol");

		model.addAttribute("deporte", deporte);

		
		return "deporte";
	}
	
	@GetMapping("/economia")
	public String muestraEconmia(Model model) {
		Economia economia = new Economia("Ecnomia de granada", "La economñia de Granada va genial");

		model.addAttribute("economia", economia);

		
		return "economia";
	}
	
	@GetMapping("/clima")
	public String muestraClima(Model model) throws IOException, ParseException {
		double temperatura=0.0;
		String URLS = "https://api.open-meteo.com/v1/forecast?latitude=37.1882&longitude=-3.6066&hourly=temperature_2m"; 

		try {
			URL url = new URL(URLS);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");	
			conn.connect();

			int codigoRespuesta = conn.getResponseCode();

			if (codigoRespuesta != HttpURLConnection.HTTP_OK) {	
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
		
		
				// Crear clima
				Clima clima = new Clima(temperatura);
				
				// Añadirlo al modelo
				model.addAttribute("clima", clima);

			}
		}
		catch(MalformedURLException e){
			e.printStackTrace();
		}
		
		return "clima";
	}
	
	
}
