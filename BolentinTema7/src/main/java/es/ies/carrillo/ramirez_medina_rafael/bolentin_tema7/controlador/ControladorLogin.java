package es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.controlador;

import es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.vista.CredentialsList;
import es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.vista.DialogInformation;

public class ControladorLogin {

	/**
	 * Método para comprobar el login introducido en los campos de texto de la
	 * aplicación
	 * 
	 * @param _user
	 * @param _password
	 * @return
	 */
	public static boolean comprobarLogin(String _user, char[] _password) {

		boolean accesoCorrecto = false;

		// Recogemos los datos de los campos de texto
		String user = _user.toString();
		String password = "";
		for (char c : _password) {
			password += c;
		}

		// Comprobamos si los campos están vacíos
		if (user.isEmpty() || password.isEmpty()) { // Si lo están mostramos mensaje de error
			DialogInformation jinfo = new DialogInformation();
			jinfo.lblMessage.setText("Alguno de los campos están vacíos");
			jinfo.setVisible(true);
		} else if (user.equals("user") && password.equals("1234")) { // Si no lo están y los datos son correctos
			// Llamamos a la función que permite el acceso a la aplicación
			CredentialsList credentialList = new CredentialsList();
			credentialList.setVisible(true);
			accesoCorrecto = true;

		} else { // Si los datos no son correctos
			// Mostramos error
			DialogInformation jinfo = new DialogInformation();
			jinfo.lblMessage.setText("Usuario o contraseña incorrectos.");
			jinfo.setVisible(true);
		}

		return accesoCorrecto;
	}
}