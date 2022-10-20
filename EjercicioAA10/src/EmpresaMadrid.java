import java.util.List;

public class EmpresaMadrid extends Empresa{
	private final double TEMP_MIN = 5.0;
	private final double TEMP_MAX = 20.0;
	
	public EmpresaMadrid(String nombre, String ubicacion, List<Producto> productos) {
		super(nombre, ubicacion, productos);
	}
	
	public String informarActividades(double temperatura) {
		String cadena = super.informarActividades(temperatura);
		
		if (temperatura < TEMP_MIN) {
			return cancelarDiaTrabajo();
		}
		
		if (temperatura > TEMP_MAX) {
			return cadena + " \nEl stock generado hoy es de " + this.informarStockGenerado(getProductos()) + " productos.";
		}
		
		return cadena;
	}

}
