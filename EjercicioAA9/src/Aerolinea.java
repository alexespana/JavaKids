import java.util.ArrayList;
import java.util.List;

public class Aerolinea implements CalcularEstadisticas{
	private String nombre;
	private String ubicacion;
	private List<Vuelo> vuelos;
	 
	public Aerolinea(String nombre, String ubicacion, List<Vuelo> vuelos) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.vuelos = vuelos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	@Override
	public String toString() {
		String result = "INFORMACION AEROLINEA\n"
				+ "Nombre=" + nombre + ", ubicacion=" + ubicacion + ".\n"
				+ "<== Vuelos próximos ==>";
		
		for(int i=0; i<vuelos.size(); i++) {
			result += vuelos.get(i).toString();
		}
		
		result += "\n Ganancia total=" + this.calcularGananciaTotal() + ". ";

		return result;
	}

	@Override
	public double calcularGananciaTotal() {
		double gananciaTotal = 0;
		
		for(int i=0; i<this.getVuelos().size(); i++) {
			gananciaTotal += this.vuelos.get(i).calcularGananciaNeta();
		}
		
		return gananciaTotal;
	}
}
