package com.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * EJERCICIO SB03
 * 
 * Verduleria a Domicilio
 * 
 * Diseñar un sitio web donde se pueda insertar en un recuadro los siguientes valores:
 * - Zanahoria
 * - Comino
 * - Cebolla
 * - Palta
 * 
 * Y en base a dichos valores, generar un TXT de salida para cada valor correspondiente informando una comida recomendada para hacer:
 * - Si es Zanahoria entonces recomendar una Ensalada de Zanahoria  con un formato de nombre de salida: recetaZanahoria.txt
 * - Si es Comino entonces recomendar una Ensalada de Comino  con un formato de nombre de salida: recetaComino.txt
 * - Si es Cebolla entonces recomendar una Ensalada de Cebolla  con un formato de nombre de salida: recetaCebolla.txt
 * - Si es Palta entonces recomendar una Ensalada de Palta  con un formato de nombre de salida: recetaPalta.txt
 * - Si tiene todos los valores almacenados entonces recomendar una Ensalada de Zanahoria, Comino, Cebolla y palta con un formato de nombre
 * de salida: recetaSana.txt
 * 
 * Cada txt debe tener adentro una receta para los ingredientes. 
 * 
 * ESTRUCTURA DEL PROGRAMA:
 * - Estructura de la pagina web: Debe contar al menos con un Index y una seccion de Comidas.jsp
 * - Se puede declarar 4 clases, 1 para cada ingrediente, o, realizarlo todo en una sola clase. Cada ingrediente debe tener atributos propios del mismo, por
 * ejemplo: Nombre, Color, Sabor (Feo, Rico, Delicioso), Valor monetario.
 * - Implementar 5 interfaces que generen cada una los TXT de salida.
 * 
 * ENTREGABLES:
 * - Link del repositorio de GitHub
 * 
 */

@SpringBootApplication
public class Sb03Application {

	public static void main(String[] args) {
		SpringApplication.run(Sb03Application.class, args);
	}

}
