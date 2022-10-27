package MVC;

public class Economia {
	private String titular;
	private String informacion;
	
	public Economia(String titular, String informacion) {
		this.titular = titular;
		this.informacion = informacion;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	@Override
	public String toString() {
		return "Economia [titular=" + titular + ", informacion=" + informacion + "]";
	}
	
}
