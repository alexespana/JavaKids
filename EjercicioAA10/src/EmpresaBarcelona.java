import java.util.List;

public class EmpresaBarcelona extends Empresa{
	private final double UMBRAL_TEMP = 10;
	
	public EmpresaBarcelona(String nombre, String ubicacion, List<Producto> productos) {
		super(nombre, ubicacion, productos);
	}

	public String informarActividades(double temperatura) {
		String cadena = super.informarActividades(temperatura);
		if (temperatura >= UMBRAL_TEMP) {
			return cadena + "\nEl stock generado hoy es de " + this.informarStockGenerado(getProductos()) + " productos.";
		}
		else {
			return cancelarDiaTrabajo();
		}
		
	}
}
