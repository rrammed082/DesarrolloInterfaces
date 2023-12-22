package es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.componentes.JButtonRound;
import es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.utiles.Utiles;

import javax.swing.ImageIcon;

public class DialogInformation extends JDialog {

	// Atributos de la clase
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public static JLabel lblMessage;
	public static JLabel imgWarning;

	/**
	 * Constructor de la clase sin parámetros
	 */
	public DialogInformation() {

		// Se establece las propiedades del Dialogo
		setTitle("Mensaje informativo");
		setResizable(false);
		setBounds(100, 100, 353, 250);
		setLocationRelativeTo(null);

		// Se define el panel principal donde va a estar albergado todos los elementos
		getContentPane().setLayout(null);
		contentPanel.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));
		contentPanel.setBounds(0, 0, 337, 156);
		getContentPane().add(contentPanel);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);

		// Creación de Label genérico que mostrar un mensaje que se le establece
		// en la creación del objeto DialogInformation
		lblMessage = new JLabel("Mensaje");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font(Utiles.ROBOTO_BLACK, Font.BOLD, 18));
		lblMessage.setBounds(10, 82, 317, 31);
		contentPanel.add(lblMessage);

		// Creación de la imagen de advertencia que aparecerá en la creación de
		// DialogInformation para errores
		imgWarning = new JLabel("");
		imgWarning.setIcon(new ImageIcon(DialogInformation.class
				.getResource("/es/ies/carrillo/ramirez_medina_rafael/bolentin_tema7/assets/advertencia.png")));
		imgWarning.setHorizontalAlignment(SwingConstants.CENTER);
		imgWarning.setBounds(125, 0, 84, 57);
		contentPanel.add(imgWarning);

		// Se define el panel donde se van a establecer los botones
		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));
		buttonPane.setBounds(0, 155, 337, 56);
		getContentPane().add(buttonPane);
		buttonPane.setLayout(null);

		// Creación de Botón Confirmar o aceptar
		JButtonRound btnConfirm = new JButtonRound();
		btnConfirm.setToolTipText("Botón para aceptar la información de la aplicación");
		btnConfirm.setText("Aceptar");
		btnConfirm.setFont(new Font(Utiles.ROBOTO_BLACK, Font.BOLD, 12));
		btnConfirm.setActionCommand("OK");
		btnConfirm.setBounds(118, 11, 98, 31);
		buttonPane.add(btnConfirm);

		// Funcionalidad del Botón confirmar
		btnConfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // Cierra el diálogo de información si es pulsado

			}

		});

		// Si está marcado el check en el programa principal se establece elemento por
		// elemento el color
		// que tendrá cada uno de ellos en el modo oscuro
		if (!CredentialsList.modoOscuro) {
			contentPanel.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));
			buttonPane.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));

			lblMessage.setForeground(Utiles.convierteHEXaRGB(Utiles.COLOR_TEXT));

			btnConfirm.setColor1(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));
			btnConfirm.setColor2(Utiles.convierteHEXaRGB(Utiles.COLOR_SECUNDARIO_M));
			btnConfirm.setColor3(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));

		} else { // Si no está marcado se vuelve a definir los colores que tiene cada elemento
				 // por defecto

			contentPanel.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_PRIMARIO));
			buttonPane.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_PRIMARIO));

			lblMessage.setForeground(Utiles.convierteHEXaRGB(Utiles.COLOR_TEXT));

			btnConfirm.setColor1(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_PRIMARIO));
			btnConfirm.setColor2(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_SECUNDARIO));
			btnConfirm.setColor3(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_RESALTADO));

		}
		
		// Creación de la imagen de icono de la ventana que aparece arriba a la
		// izquierda
		Image icon = new ImageIcon(
				this.getClass().getResource("/es/ies/carrillo/ramirez_medina_rafael/bolentin_tema7/assets/logo.png"))
				.getImage();
		setIconImage(icon);
	}
}
