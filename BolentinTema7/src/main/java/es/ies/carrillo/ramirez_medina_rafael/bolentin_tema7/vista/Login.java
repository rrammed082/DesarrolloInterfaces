package es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.componentes.JButtonRound;
import es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.componentes.JPanelRound;
import es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.controlador.ControladorLogin;
import es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.utiles.Utiles;

public class Login extends JFrame {

	// Atributos de la clase
	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Constructor de la clase sin parámetros
	 */
	public Login() {
		
		// Se establece las propiedades de la ventana
		super("Formulario de Acceso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		
		// Se define el panel principal donde va a estar albergado todos los elementos
		JPanel panel = new JPanel();
		panel.setLayout(null);

		getContentPane().add(panel);

		
		JPanelRound loginPanel = new JPanelRound();
		loginPanel.setColorContorno(Utiles.convierteHEXaRGB(Utiles.COLOR_COMPLEMENTARIO));

		loginPanel.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));
		loginPanel.setBounds(34, 225, 325, 258);
		panel.add(loginPanel);
		loginPanel.setLayout(null);

		// Creación de Label para el nombre de usuario
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(21, 38, 96, 22);
		loginPanel.add(usernameLabel);
		usernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		usernameLabel.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));
		usernameLabel.setForeground(Utiles.convierteHEXaRGB(Utiles.COLOR_TEXT));
		usernameLabel.setFont(new Font(Utiles.ROBOTO_BLACK, Font.PLAIN, 18));

		// Definición de campo editable para introducir el nombre de usuario
		usernameField = new JTextField();
		usernameField.setToolTipText("Campo de Texto donde introducir el Nombre de usuario de acceso a la aplicación.");
		usernameField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameField.setBorder(null);
		usernameField.setBounds(129, 35, 169, 25);
		loginPanel.add(usernameField);

		// Creación de Label para la contraseña
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(21, 92, 96, 22);
		loginPanel.add(passwordLabel);
		passwordLabel.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_TEXT));
		passwordLabel.setForeground(Utiles.convierteHEXaRGB(Utiles.COLOR_TEXT));
		passwordLabel.setFont(new Font(Utiles.ROBOTO_BLACK, Font.PLAIN, 18));

		// Definición de campo editable para introducir la contraseña
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Campo de Texto donde introducir la contraseña de acceso a la aplicación.");
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBorder(null);
		passwordField.setBounds(129, 89, 169, 25);
		loginPanel.add(passwordField);

		/**
		 * Acción en el campo editable de Contraseña para que al pulsar el botón enter
		 * haga la misma función que el botón de Login
		 */
		passwordField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				char[] password = passwordField.getPassword();
				// Realiza la autenticación según tus necesidades.
				if (ControladorLogin.comprobarLogin(username, password)) {
					dispose();
				}

			}
		});

		// Creación de Botón Iniciar Sesión
		JButtonRound loginButton = new JButtonRound();
		loginButton.setToolTipText("Botón que permite el acceso a la aplicación si las credenciales introducidas es correcta.");
		loginButton.setBackground(new Color(255, 128, 0));
		loginButton.setColor3(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));
		loginButton.setColor2(Utiles.convierteHEXaRGB(Utiles.COLOR_SECUNDARIO_M));
		loginButton.setColor1(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));
		loginButton.setText("Login");
		loginButton.setBounds(82, 174, 180, 50);
		loginPanel.add(loginButton);

		// Acción del Botón Iniciar Sesión
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Creación de objetos con los datos del campos editables anteriores
				String username = usernameField.getText();
				char[] password = passwordField.getPassword();
				// Llama a la función para comprobar Login
				if (ControladorLogin.comprobarLogin(username, password)) {
					// Si el login es correcto se cierra esta ventan de Login
					dispose();
				}

			}
		});

		// Creación de la imagen de icono de la ventana que aparece arriba a la izquierda
		Image icon = new ImageIcon(
				this.getClass().getResource("/es/ies/carrillo/ramirez_medina_rafael/bolentin_tema7/assets/logo.png"))
				.getImage();
		setIconImage(icon);

		// Creación de imagen de diseño que ocupa todo el fondo del Panel.
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(this.getClass()
				.getResource("/es/ies/carrillo/ramirez_medina_rafael/bolentin_tema7/assets/ciberseguridad.png")));
		lblImage.setBounds(-48, -92, 1071, 737);
		panel.add(lblImage);

		setVisible(true);
	}
}
