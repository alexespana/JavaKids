public class Producto {
	private String nombre;
	private int cantidadGenerada;
	private int costoGeneracion;
	private int ganaciaEsperada;
	
	public Producto(String nombre, int cantidadGenerada, int costoGeneracion, int ganaciaEsperada) {
		this.nombre = nombre;
		this.cantidadGenerada = cantidadGenerada;
		this.costoGeneracion = costoGeneracion;
		this.ganaciaEsperada = ganaciaEsperada;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidadGenerada() {
		return cantidadGenerada;
	}

	public void setCantidadGenerada(int cantidadGenerada) {
		this.cantidadGenerada = cantidadGenerada;
	}

	public int getCostoGeneracion() {
		return costoGeneracion;
	}

	public void setCostoGeneracion(int costoGeneracion) {
		this.costoGeneracion = costoGeneracion;
	}

	public int getGanaciaEsperada() {
		return ganaciaEsperada;
	}

	public void setGanaciaEsperada(int ganaciaEsperada) {
		this.ganaciaEsperada = ganaciaEsperada;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", cantidadGenerada=" + cantidadGenerada + ", costoGeneracion="
				+ costoGeneracion + ", ganaciaEsperada=" + ganaciaEsperada + "]\n";
	}
}
