import java.time.LocalDate;
import java.util.List;

public class Empresa implements Calculos{
	private String nombre;
	private String ubicacion;
	private List<Producto> productos;
	
	public Empresa(String nombre, String ubicacion, List<Producto> productos) {
		this.nombre = nombre;
		this.productos = productos;
		this.ubicacion = ubicacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String informarActividades(double temperatura) {
		if (temperatura >= 6 && temperatura <= 20) {
			return "Con una temperatura de " + temperatura + "ºC, se realizaron tareas administrativas.";
		}
		
		return "Con una temperatura de " + temperatura + "ºC, no se realizaron tareas administrativas.";
	}
	
	public String cancelarDiaTrabajo() {
		return "Por condiciones climáticas no se ha podido trabajar el " + LocalDate.now() + " .";
	}

	@Override
	public double calcularGananciaEstimada(List<Producto> productos) {
		double ganancia = 0.0;
		int cont=0;
		
		while(cont<productos.size()) {
			ganancia += productos.get(cont).getGanaciaEsperada() - productos.get(cont).getCostoGeneracion();
			
			cont++;
		}
		
		return ganancia;
	}

	@Override
	public int informarStockGenerado(List<Producto> productos) {
		int stockGenerado = 0;
		int cont=0;
		
		while(cont<productos.size()) {
			stockGenerado += productos.get(cont).getCantidadGenerada();
			
			cont++;
		}
		
		return stockGenerado;
	}

	@Override
	public String toString() {
		String r =  "Empresa\nNombre=" + nombre + ", ubicacion=" + ubicacion + "\n<==== Productos ====>\n";
	
		int cont= 0;
		while (cont<productos.size()) {
			r += productos.get(cont).toString();
					
			cont++;
		}
		
		return r;
		
	}
	
	
}
