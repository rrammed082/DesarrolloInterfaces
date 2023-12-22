
package es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.controlador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.modelo.Credencial;
import es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.vista.CredentialsList;
import es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.vista.DialogInformation;

public class ControladorListaCredenciales {
	// Variables Globales de la aplicación
	public static ArrayList<Credencial> listaCredenciales = new ArrayList<>();

	/**
	 * Método para guardar las credenciales
	 * 
	 * @param c
	 * @param modeloLista
	 */
	public static void guardarCredenciales(Credencial c, DefaultListModel<String> modeloLista) {
		if (c.getNombreCuenta().isEmpty() || c.getNombreUsuario().isEmpty() || c.getContrasenya().isEmpty()) {
			// Mensaje de error
			DialogInformation jinfo = new DialogInformation();
			jinfo.lblMessage.setText("Alguno de los campos están vacíos");
			jinfo.setVisible(true);

		} else {
			listaCredenciales.add(c);
			addCredencialALista(c, modeloLista);
			DialogInformation jinfo = new DialogInformation();
			jinfo.lblMessage.setText("Cuenta agregada correctamente.");
			jinfo.imgWarning.setVisible(false);
			jinfo.setVisible(true);
		}
	}

	/**
	 * Método para guardar las credenciales en el Jlist
	 * 
	 * @param c
	 * @param modeloLista
	 */
	public static void addCredencialALista(Credencial c, DefaultListModel<String> modeloLista) {

		String Objetoformateado = String.format(
				"<html><b>%s:</b><br>&nbsp;&nbsp;Usuario: %s<br>&nbsp;&nbsp;Contraseña: %s</html>", c.getNombreCuenta(),
				c.getNombreUsuario(), c.getContrasenya());
		modeloLista.addElement(Objetoformateado);
	}

	/**
	 * Método para cargar el ArrayList desde un archivo
	 * 
	 * @param modeloLista
	 */
	public static void cargarDatosAlaLista(DefaultListModel<String> modeloLista) {
		// Llamada al método para leer un fichero y almacenarlo en el ArrayList de la
		// clase
		leerDesdeArchivo("Contrasenyas.dat");

		for (Credencial credencial : listaCredenciales) { // Se recorre el ArrayList
			// Se almacena llamando al método para añadirlo al JList
			addCredencialALista(credencial, modeloLista);
		}
	}

	/**
	 * Método para guardar los datos del ArrayList en un fichero binario
	 */
	public static void guardarDatos() {
		if (!listaCredenciales.isEmpty()) {
			String nombreFichero = "Contrasenyas.dat";
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreFichero))) {
				oos.writeObject(listaCredenciales);
				System.out.println("Datos almacenados en " + nombreFichero);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Método para leer las credenciales desde el archivo binario y cargarlas en el
	 * ArrayList
	 * 
	 * @param nombreArchivo
	 */
	@SuppressWarnings("unchecked")
	private static void leerDesdeArchivo(String nombreArchivo) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
			listaCredenciales = (ArrayList<Credencial>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método para realizar la eliminación de una Credencial de la Lista.
	 * 
	 * @param credencialSeleccionada, índice de la credencial seleccionada
	 * @param modeloLista
	 */
	public static void eliminarCredencial(int credencialSeleccionada, DefaultListModel<String> modeloLista) {
		// Se comprueba que el índice de la credencial seleccionada no es nulo
		if (credencialSeleccionada != -1) {
			listaCredenciales.remove(credencialSeleccionada);
			modeloLista.remove(credencialSeleccionada);
		}
	}
}
