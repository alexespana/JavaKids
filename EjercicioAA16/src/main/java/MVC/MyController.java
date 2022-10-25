package MVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	
	@GetMapping("index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/noticias")
	public String mostrarNoticias() {
		return "noticias";
	}
	
	@GetMapping("/amor")
	public String mostrarTecnologia() {
		return "amor";
	}
	
	@GetMapping("/economia")
	public String mostrarMercado() {
		return "economia";
	}
	
	@GetMapping("/tiempo")
	public String mostrarTiempo() {
		return "tiempo";
	}
	
	@GetMapping("/imagenes")
	public String mostrarImagenes() {
		return "imagenes";
	}
	
	
}
