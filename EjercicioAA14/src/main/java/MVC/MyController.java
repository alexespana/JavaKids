package MVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/noticias")
	public String mostrarNoticias() {
		return "noticias";
	}
	
	@RequestMapping("/tecnologia")
	public String mostrarTecnologia() {
		return "tecnologia";
	}
	
	@RequestMapping("/mercado")
	public String mostrarMercado() {
		return "mercado";
	}
	
	@RequestMapping("/comida")
	public String mostrarComida() {
		return "comida";
	}
	
	@RequestMapping("/farandula")
	public String mostrarFarandula() {
		return "farandula";
	}
	
	@RequestMapping("/deportes")
	public String mostrarDeportes() {
		return "deportes";
	}
	
	@RequestMapping("/gaming")
	public String mostrarGaming() {
		return "gaming";
	}
	
	@RequestMapping("/influencers")
	public String mostrarInfluencers() {
		return "influencers";
	}
	
	@RequestMapping("/musica")
	public String mostrarMusica() {
		return "musica";
	}
	
}
