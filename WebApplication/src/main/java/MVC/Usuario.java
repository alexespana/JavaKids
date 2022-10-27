package MVC;

import java.time.LocalDate;

public class Usuario {
	private String nombre;
	private String apellido;
	private String nombreUsuario;
	private String email;
	private String localidad;
	private LocalDate fechaNacimiento;
	private String password;
	
	public Usuario(String nombre, String apellido, String nombreUsuario, String email, String localidad, LocalDate fechaNacimiento, String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.localidad = localidad;
		this.fechaNacimiento = fechaNacimiento;
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", nombreUsuario=" + nombreUsuario + ", email="
				+ email + ", localidad=" + localidad + ", fechaNacimiento=" + fechaNacimiento + ", password=" + password
				+ "]";
	}


	
}
