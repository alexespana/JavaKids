package com.exam;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class Ingrediente implements InterfazZanahoria, InterfazCebolla, InterfazComino,InterfazPalta, InterfazTodos, GenerarArchivo{
	private String nombre;
	private String color;
	private String sabor;
	private double precio;
	
	public Ingrediente(String nombre, String color, String sabor, double precio) {
		this.nombre = nombre;
		this.color = color;
		this.sabor = sabor;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Ingrediente [nombre=" + nombre + ", color=" + color + ", sabor=" + sabor + ", precio=" + precio + "]";
	}

	@Override
	public void generarZanahoria() {
		this.generarArchivo("recetaZanahoria.txt", "Ensalada de zanahoria");	
	}

	@Override
	public void generarCebolla() {
		this.generarArchivo("recetaCebolla.txt", "Ensalada de cebolla");	
	}

	@Override
	public void generarTodos() {
		this.generarArchivo("recetaSana.txt", "Ensalada de zanahoria, comino, cebolla y palta");
	}

	@Override
	public void generarPalta() {
		this.generarArchivo("recetaPalta.txt", "Ensalada de palta");
	}

	@Override
	public void generarComino() {
		this.generarArchivo("recetaComino.txt", "Ensalada de comino");
	}

	@Override
	public void generarArchivo(String nombreArchivo, String cadena) {
		try {		
			Path archivo = Paths.get(nombreArchivo);
			Files.writeString(archivo, cadena, StandardCharsets.UTF_8);
		}
		catch(IOException e) {
			System.out.println("Obtuviste un error en la creación del archivo");
			e.printStackTrace();
		}
		
	}

}
