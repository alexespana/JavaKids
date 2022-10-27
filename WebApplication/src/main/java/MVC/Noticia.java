package MVC;

public class Noticia {

	private String titular;
	private String informacion;
	
	public Noticia(String titular, String informacion) {
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
		return "Noticia [titular=" + titular + ", informacion=" + informacion + "]";
	}
	
}
