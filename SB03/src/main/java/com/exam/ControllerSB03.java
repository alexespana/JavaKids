package com.exam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ControllerSB03{
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/muestraFormulario")
	public String muestraFormulario(Model model) {
		return "ingredientesForm";
	}
	
	@RequestMapping("/procesaFormulario")
	public String procesarFormulario(@RequestParam("ingredientes") String ingredientes, Model model) {
		String salida = "";
		switch (ingredientes) { 
	    case "Zanahoria":
	    	Ingrediente z = new Ingrediente(ingredientes, "naranja", "amargo", 2.0);
	    	z.generarZanahoria();
	    	salida = "Se ha generado el archivo de la zanahoria";
	     break;
	    case "Comino":
	    	Ingrediente z2 = new Ingrediente(ingredientes, "verde", "amargo", 3.0);
	    	z2.generarComino();
	    	salida = "Se ha generado el archivo de la comino.";
	    	break;
	    case "Cebolla":
	    	Ingrediente z3 = new Ingrediente(ingredientes, "blanco", "ácida", 3.0);
	    	z3.generarCebolla();
	    	salida = "Se ha generado el archivo de la cebolla.";
	    	break;
	    case "Palta":
	    	Ingrediente z4 = new Ingrediente(ingredientes, "azul", "dulve", 2.5);
	    	z4.generarPalta();
	    	salida = "Se ha generado el archivo de la palta.";
	    	break;
	    default:
	    	// Comprobar si contiene todos
	    	if (ingredientes.contains("Zanahoria") && ingredientes.contains("Comino") && 
	    		ingredientes.contains("Cebolla") && ingredientes.contains("Palta")) {
		    	Ingrediente z5 = new Ingrediente(ingredientes, "todos", "todos", 22.0);
		    	z5.generarTodos();
		    	salida = "Se ha generado el archivo con todos los ingredientes.";
	    	}
	    	else {
	    		salida="Te has equivocado de ingrediente.";
	    	}
		}
		
		//Agregar salida en el jsp
		model.addAttribute("salida", salida);
		return "comidas";
	}
}
