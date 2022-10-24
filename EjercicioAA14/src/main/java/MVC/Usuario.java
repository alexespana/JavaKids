package MVC;

public class Usuario {
	private String nombre;
	private String contraseña;
	private String email;
	
	public Usuario(String nombre, String contraseña, String email) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contraseña=" + contraseña + ", email=" + email + "]\n";
	}
}
