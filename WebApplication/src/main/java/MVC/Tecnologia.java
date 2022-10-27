package MVC;

public class Tecnologia {

	private String titular;
	private String informacion;
	
	public Tecnologia(String titular, String informacion) {
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
		return "Tecnología [titular=" + titular + ", informacion=" + informacion + "]";
	}
	
}
