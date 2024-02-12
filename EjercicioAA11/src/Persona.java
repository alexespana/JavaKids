import java.time.LocalDate;
import java.time.Period;

public class Persona implements Interfaz1{
	private String nombre;
	private LocalDate fechaNacimiento;
	private String pais;
	private int edad; 	// Atributo calculado
	
	public Persona(String nombre, LocalDate fechaNacimiento, String pais) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.pais =pais;
		
		// Atributos calculados
		this.edad = this.calcularEdad(fechaNacimiento);
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	
	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	@Override
	public int calcularEdad(LocalDate fechaNacimiento) {
		Period periodo = Period.between(fechaNacimiento, LocalDate.now());
		return periodo.getYears();
	}


	@Override
	public String toString() {
		return "\nNombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", pais=" + pais + ", edad="
				+ edad;
	}
	
	

}
