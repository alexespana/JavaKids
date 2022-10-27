package MVC;

public class Clima {
	private double temperatura;

	public Clima(double temperatura) {
		this.temperatura = temperatura;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	@Override
	public String toString() {
		return "Clima [temperatura=" + temperatura + "]";
	}
}
