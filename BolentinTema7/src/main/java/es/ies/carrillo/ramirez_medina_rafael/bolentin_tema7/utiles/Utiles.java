package es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.utiles;

import java.awt.Color;

import javax.swing.JComponent;

public class Utiles extends JComponent {

	public static final String NEW_LINE = "\n";

	// FUENTES
	public static final String ROBOTO_BLACK = "Roboto/Roboto-Black.ttf";
	public static final String ROBOTO_BLACK_ITALIC = "Roboto/Roboto-BlackItalic.ttf";
	public static final String ROBOTO_BOLD = "Roboto/Roboto-Bold.ttf";
	public static final String POPPINS_BOLD = "Poppins/Poppins-Bold.ttf";
	public static final String POPPINS_BOLD_ITALIC = "Poppins/Poppins-BoldItalic.ttf";
	public static final String POPPINS_REGULAR = "Poppins/Poppins-Regular.ttf";
	public static final String RALEWAY_BOLD = "Raleway/Raleway-Bold.ttf";
	public static final String RALEWAY_BOLD_ITALIC = "Raleway/Raleway-BoldItalic.ttf";
	public static final String RALEWAY_MEDIUM = "Raleway/Raleway-Medium.ttf";

	// COLORES POR DEFECTO
	public static String COLOR_PRIMARIO = "FF8040";
	public static String COLOR_SECUNDARIO_N = "EE6071";
	public static String COLOR_SECUNDARIO_R = "BE5A90";
	public static String COLOR_SECUNDARIO_M = "7E5C95";
	public static String COLOR_COMPLEMENTARIO = "004080";
	public static String COLOR_TEXT = "FFFFFF";
	
	// COLORES POR TEMA OSCUROS
	public static String COLOR_DARK_PRIMARIO = "1E1E1E";
	public static String COLOR_DARK_SECUNDARIO = "2E2E2E";
	public static String COLOR_DARK_RESALTADO = "4CAF50";
	public static String COLOR_DARK_COMPLEMENTARIO = "FFBF7F";
	public static String COLOR_DARK_TEXT_C = "000000";
	
	
	
	
	
	/**
	 * Convierte un color en formato hexadecimal a un objeto Color de Java.
	 *
	 * @param hexColor Representación hexadecimal del color (por ejemplo, "RRGGBB").
	 * @return Objeto Color correspondiente al color hexadecimal especificado.
	 */
	public static Color convierteHEXaRGB(String hexColor) {
		// Extraer los componentes RGB del color hexadecimal

		// Obtener los primeros dos caracteres del color hexadecimal (componente rojo)
		int resultRed = Integer.valueOf(hexColor.substring(0, 2), 16);

		// Obtener los siguientes dos caracteres del color hexadecimal (componente
		// verde)
		int resultGreen = Integer.valueOf(hexColor.substring(2, 4), 16);

		// Obtener los últimos dos caracteres del color hexadecimal (componente azul)
		int resultBlue = Integer.valueOf(hexColor.substring(4, 6), 16);

		// Crear y devolver un nuevo objeto Color con los componentes RGB obtenidos
		Color colorRGB = new Color(resultRed, resultGreen, resultBlue);

		return colorRGB;
	}

}