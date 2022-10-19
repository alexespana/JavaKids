
public class Vuelo implements CalcularEstadisticas2{
	private final int PRECIOPROMEDIOPASAJE = 50;
	private String destino;
	private int numeroPasajesVendidos;
	private String salida;
	
	public Vuelo(String destino, int numeroPasajesVendidos, String salida) {
		this.destino = destino;
		this.numeroPasajesVendidos = numeroPasajesVendidos;
		this.salida = salida;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getnumeroPasajesVendidos() {
		return numeroPasajesVendidos;
	}

	public void setnumeroPasajesVendidos(int numeroPasajesVendidos) {
		this.numeroPasajesVendidos = numeroPasajesVendidos;
	}

	public String getsalida() {
		return salida;
	}

	public void setsalida(String salida) {
		this.salida = salida;
	}


	@Override
	public int calcularAsistenciaPasajeros() {
		return (int) this.numeroPasajesVendidos/2;
	}
	
	@Override
	public double calcularGananciaNeta() {		
		return this.numeroPasajesVendidos * this.PRECIOPROMEDIOPASAJE;
	}
	
	@Override
	public String toString() {
		return "\nVuelo [destino=" + destino + ", numeroPasajesVendidos=" + numeroPasajesVendidos + ", salida=" + salida
				+ "asistenciaPasajeros=" + this.calcularAsistenciaPasajeros() + "gananciaNeta=" + this.calcularGananciaNeta()+ "]";
	}
	
}
