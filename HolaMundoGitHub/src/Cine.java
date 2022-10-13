import java.util.List;

public class Cine {
	private String name;
	private String address;
	private List<Pelicula> films;
	
	public Cine(String name, String address, List<Pelicula> films) {
		this.name = name;
		this.address = address;
		this.films = films;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Pelicula> getFilms() {
		return films;
	}

	public void setFilms(List<Pelicula> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "Cine [name=" + name + ", address=" + address + ", contiene " + this.films.size() + " peliculas" + "]";
	}
}
