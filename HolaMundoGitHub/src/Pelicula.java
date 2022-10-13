public class Pelicula {
	private String name;
	private long rank;
	private long worldwideLifetimeGross;
	private long domesticLifetimeGross;
	private long foreignLifetimeGross;
	private long year;
	
	public Pelicula(long rank, String name, long worldwideLifetimeGross, long domesticLifetimeGross,
			long foreignLifetimeGross, long year) {
		this.name = name;
		this.rank = rank;
		this.worldwideLifetimeGross = worldwideLifetimeGross;
		this.domesticLifetimeGross = domesticLifetimeGross;
		this.foreignLifetimeGross = foreignLifetimeGross;
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getRank() {
		return rank;
	}

	public void setRank(long rank) {
		this.rank = rank;
	}

	public long getWorldwideLifetimeGross() {
		return worldwideLifetimeGross;
	}

	public void setWorldwideLifetimeGross(long worldwideLifetimeGross) {
		this.worldwideLifetimeGross = worldwideLifetimeGross;
	}

	public long getDomesticLifetimeGross() {
		return domesticLifetimeGross;
	}

	public void setDomesticLifetimeGross(long domesticLifetimeGross) {
		this.domesticLifetimeGross = domesticLifetimeGross;
	}

	public long getForeignLifetimeGross() {
		return foreignLifetimeGross;
	}

	public void setForeignLifetimeGross(long foreignLifetimeGross) {
		this.foreignLifetimeGross = foreignLifetimeGross;
	}

	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Pelicula [name=" + name + ", rank=" + rank + ", worldwideLifetimeGross=" + worldwideLifetimeGross
				+ ", domesticLifetimeGross=" + domesticLifetimeGross + ", foreignLifetimeGross=" + foreignLifetimeGross
				+ ", year=" + year + "]";
	}
	
	
	
}
