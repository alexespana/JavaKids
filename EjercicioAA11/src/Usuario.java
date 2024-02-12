import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Usuario extends Persona implements Interfaz2, Interfaz3, Interfaz4{
	private int mesesAntiguedad;
	private String segmento;
	private String status;
	private LocalDate fechaLogin;
	private LocalDate fechaRegistro;
	private int productos;
	
	
	
	public Usuario(String nombre, LocalDate fechaNacimiento, LocalDate fechaRegistro, LocalDate fechaLogin, int productos, String pais) {
		super(nombre, fechaNacimiento, pais);
		this.fechaLogin = fechaLogin;
		this.fechaRegistro = fechaRegistro;
		this.productos = productos;
		
		// Atributos calculados
		this.mesesAntiguedad = this.calcularMesesAntiguedad(this.fechaRegistro);
		this.segmento = this.calcularSegmento(productos);
		this.status = this.calcularStatus(this.fechaLogin);
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMesesAntiguedad() {
		return mesesAntiguedad;
	}

	public void setMesesAntiguedad(int mesesAntiguedad) {
		this.mesesAntiguedad = mesesAntiguedad;
	}
	
	public LocalDate getFechaLogin() {
		return fechaLogin;
	}

	public void setFechaLogin(LocalDate fechaLogin) {
		this.fechaLogin = fechaLogin;
	}

	public int getProductos() {
		return productos;
	}

	public void setProductos(int productos) {
		this.productos = productos;
	}

	
	
	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Override
	public String calcularStatus(LocalDate fechaLogin) {
		
		Period periodo = Period.between(fechaLogin, LocalDate.now());
		int años = periodo.getYears();
		
		if (años>=2) {	// Más de dos años
			return "Inactivos";
		}
		else {
			return "Activos";
		}
	}

	@Override
	public String calcularSegmento(int productos) {
		if (productos>=1 && productos <=5) {
			return "Estandar User";
		}
		else if(productos>=6 && productos <=10) {
			return "Affiliate";

		}
		else if(productos >= 11) {
			return "Premier";

		}
		else return null;
	}

	@Override
	public int calcularMesesAntiguedad(LocalDate fechaIngreso) {
		Period periodo = Period.between(fechaIngreso, LocalDate.now());
		return periodo.getYears() * 12 + periodo.getMonths();
	}

	@Override
	public String toString() {
		String salida = super.toString();
		
		return "\n<==== Usuario ====> [" +  salida + "\nmesesAntiguedad=" + mesesAntiguedad + ", segmento=" + segmento + ", status=" + status
				+ ", fechaLogin=" + fechaLogin + ", fechaRegistro=" + fechaRegistro + ", productos=" + productos + "]";
	}
	
	

}
