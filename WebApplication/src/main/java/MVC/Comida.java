package MVC;

public class Comida {
	private String nombre;
	private String informacion;
	
	public Comida(String nombre, String informacion) {
		this.nombre = nombre;
		this.informacion = informacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	@Override
	public String toString() {
		return "Comida [nombre=" + nombre + ", informacion=" + informacion + "]";
	}
}
