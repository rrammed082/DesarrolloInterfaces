package es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.modelo;

import java.io.Serializable;

public class Credencial implements Serializable {
	
	// Variables de la clase
	public String nombreCuenta;
	public String nombreUsuario;
	public String contrasenya;
	
	// Constructor con parámetros
	public Credencial(String nombreCuenta, String nombreUsuario, String contrasenya) {
		this.nombreCuenta = nombreCuenta;
		this.nombreUsuario = nombreUsuario;
		this.contrasenya = contrasenya;
	}

	// Métodos GET y SET de la clase
	public String getNombreCuenta() {
		return nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	// ToString
	@Override
	public String toString() {
		return "Credencial \n"
				+ "[nombreCuenta=" + nombreCuenta + ", \nnombreUsuario=" + nombreUsuario + ", \ncontrasenya="
				+ contrasenya + "]";
	}
	
	
}
