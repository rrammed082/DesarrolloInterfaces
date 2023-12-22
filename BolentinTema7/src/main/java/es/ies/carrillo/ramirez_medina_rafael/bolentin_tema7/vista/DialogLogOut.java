package es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.vista;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.componentes.JButtonRound;
import es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.utiles.Utiles;

public class DialogLogOut extends JDialog {

	// Atributos de la clase
	private boolean respuesta;

	/**
	 * Constructor de la clase sin parámetros
	 */
	public DialogLogOut(JFrame frame, boolean modoOscuro) {
		
		// Se establece las propiedades del Dialogo
		super(frame, "Confirmar salida", true);
		
		respuesta = false;
		
		// Creación de Botón Sí
		JButtonRound btnSi = new JButtonRound();
		btnSi.setToolTipText("Botón para confirmar la salida de la aplicación");
		btnSi.setFont(new Font(Utiles.ROBOTO_BLACK, Font.BOLD, 12));
		btnSi.setText("Sí");
		btnSi.setBounds(75, 104, 104, 44);
		
		// Creación de Botón No
		JButtonRound btnNo = new JButtonRound();
		btnNo.setToolTipText("Botón para cancelar la operación de salir de la aplicación.");
		btnNo.setFont(new Font(Utiles.ROBOTO_BLACK, Font.BOLD, 12));
		btnNo.setText("No");
		btnNo.setBounds(218, 104, 104, 44);

		/**
		 * Funcionalidad del botón sí
		 */
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Establece la variable en true
				respuesta = true;
				dispose(); // Cierra el diálogo
			}
		});

		/**
		 * Funcionalidad del Botón no
		 */
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				respuesta = false;
				dispose(); // Cierra el diálogo
			}
		});
		
		// Se define el panel principal donde va a estar albergado todos los elementos
		getContentPane().setLayout(null);
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));
		panelBotones.setBounds(0, 0, 379, 181);
		panelBotones.setLayout(null);

		
		// Creación de Label que muestra el mensaje de confirmación de finalización de la aplicación
		JLabel label = new JLabel("¿Está seguro de salir?");
		label.setFont(new Font(Utiles.ROBOTO_BLACK, Font.BOLD, 18));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(93, 26, 200, 50);
		panelBotones.add(label);
		panelBotones.add(btnSi);
		panelBotones.add(btnNo);
		getContentPane().add(panelBotones);

		// Configura el tamaño y la posición del diálogo
		setSize(395, 220);
		setLocationRelativeTo(frame);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		// Si está marcado el check en el programa principal se establece elemento por elemento el color 
		// que tendrá cada uno de ellos en el modo oscuro
		if (!modoOscuro) {

			getContentPane().setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));
			panelBotones.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));
			
			label.setForeground(Utiles.convierteHEXaRGB(Utiles.COLOR_TEXT));
			
			btnSi.setColor3(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));
			btnSi.setColor2(Utiles.convierteHEXaRGB(Utiles.COLOR_SECUNDARIO_M));
			btnSi.setColor1(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));

			btnNo.setColor3(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));
			btnNo.setColor2(Utiles.convierteHEXaRGB(Utiles.COLOR_SECUNDARIO_M));
			btnNo.setColor1(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));

		} else { // Si no está marcado se vuelve a definir los colores que tiene cada elemento por defecto
			
			getContentPane().setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_PRIMARIO));
			panelBotones.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_PRIMARIO));
			
			label.setForeground(Utiles.convierteHEXaRGB(Utiles.COLOR_TEXT));
			
			btnSi.setColor1(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_PRIMARIO));
			btnSi.setColor2(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_SECUNDARIO));
			btnSi.setColor3(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_RESALTADO));

			btnNo.setColor1(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_PRIMARIO));
			btnNo.setColor2(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_SECUNDARIO));
			btnNo.setColor3(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_RESALTADO));
		}
		
		// Creación de la imagen de icono de la ventana que aparece arriba a la izquierda
		Image icon = new ImageIcon(this.getClass().getResource("/es/ies/carrillo/ramirez_medina_rafael/bolentin_tema7/assets/logo.png")).getImage();
        setIconImage(icon);
	}

	/**
	 * Método para obtener la respuesta del botón pulsado
	 * @return
	 */
	public boolean obtenerRespuesta() {
		return respuesta;
	}
}
