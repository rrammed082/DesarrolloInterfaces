package es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.componentes.JButtonRound;
import es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.componentes.JPanelRound;
import es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.controlador.ControladorListaCredenciales;
import es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.modelo.Credencial;
import es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.utiles.Utiles;

public class CredentialsList extends JFrame {

	// Atributos de la clase
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfAccount;
	private JTextField tfUserName;
	private JTextField tfPassword;
	public JList<String> listaCredenciales;
	public static boolean modoOscuro;

	/**
	 * Constructor de la clase sin parámetros
	 */
	public CredentialsList() {

		// Se establece las propiedades de la ventana
		super("Lista de Credenciales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(728, 520);
		setLocationRelativeTo(null);
		setResizable(false);

		// Se define el panel principal donde va a estar albergado todos los elementos
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		/**
		 * Creación del JPanel para la Lista de credenciales
		 */
		JPanelRound panelCredentialList = new JPanelRound();
		panelCredentialList.setBackground(new Color(0, 64, 128));
		panelCredentialList.setBounds(10, 33, 277, 437);
		contentPane.add(panelCredentialList);
		panelCredentialList.setLayout(null);

		// Definición del modelo que usará el JList que se va a usar
		DefaultListModel<String> modeloLista = new DefaultListModel<>();

		// Definición de la lista de Credenciales y sus atributos
		listaCredenciales = new JList<>(modeloLista);
		listaCredenciales.setToolTipText("Lista con las credenciales Guardadas");
		listaCredenciales.setForeground(new Color(0, 0, 0));
		listaCredenciales.setFont(new Font(Utiles.ROBOTO_BLACK, Font.BOLD, 11));
		listaCredenciales.setBorder(null);
		listaCredenciales.setBounds(10, 28, 257, 398);
		panelCredentialList.add(listaCredenciales);

		// Creación del PopUpMenú asociado al Panel de Lista de credenciales
		JPopupMenu popupMenu_JList = new JPopupMenu();
		addPopup(listaCredenciales, popupMenu_JList);

		// Creación de elemento pertenciente al PopUpMenú de Lista de credenciales
		JMenuItem popUpJListDelete = new JMenuItem("Eliminar");
		popUpJListDelete.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_COMPLEMENTARIO));
		popUpJListDelete.setForeground(Utiles.convierteHEXaRGB(Utiles.COLOR_TEXT));
		popupMenu_JList.add(popUpJListDelete);

		// Creación de Label que da información sobre la Lista de Credenciales
		JLabel lblCredentialList = new JLabel("Lista de Credenciales");
		lblCredentialList.setFont(new Font(Utiles.ROBOTO_BLACK, Font.BOLD, 16));
		lblCredentialList.setForeground(Utiles.convierteHEXaRGB(Utiles.COLOR_TEXT));
		lblCredentialList.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredentialList.setBounds(0, 0, 299, 29);
		panelCredentialList.add(lblCredentialList);

		// Creación de la Barra de Menú de la ventana
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Utiles.convierteHEXaRGB(Utiles.COLOR_TEXT));
		menuBar.setBackground(new Color(0, 64, 128));
		menuBar.setBounds(0, 0, 719, 22);
		contentPane.add(menuBar);

		// Creación de un botón de Menú ubicado en el JMenuBar
		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setToolTipText("Botón para abrir el Menú Archivo");
		mnArchivo.setForeground(Utiles.convierteHEXaRGB(Utiles.COLOR_TEXT));
		mnArchivo.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_COMPLEMENTARIO));
		menuBar.add(mnArchivo);

		// Creación de un botón elemento perteneciente al botón de Menú del JMenuBar
		JMenuItem mnCargarPasswordDesdeArchivo = new JMenuItem("Cargar Contraseñas desde Archivo");
		mnCargarPasswordDesdeArchivo.setToolTipText("Botón para cargar las credenciales desde un fichero binario");
		mnCargarPasswordDesdeArchivo.setForeground(Utiles.convierteHEXaRGB(Utiles.COLOR_TEXT));
		mnCargarPasswordDesdeArchivo.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_COMPLEMENTARIO));
		mnArchivo.add(mnCargarPasswordDesdeArchivo);

		// Funcionalidad del botón
		mnCargarPasswordDesdeArchivo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Se llama al método para cargar la lista en el JList
				ControladorListaCredenciales.cargarDatosAlaLista(modeloLista);
				// Una vez pulsado se deshabilita para evitar errores al cargar dos veces el
				// mismo archivo
				mnCargarPasswordDesdeArchivo.setEnabled(false);
			}
		});

		// Creación de un botón de Menú ubicado en el JMenuBar
		JMenu mnOptions = new JMenu("Opciones");
		mnOptions.setToolTipText("Botón para abrir las opciones de la aplicación");
		mnOptions.setForeground(Utiles.convierteHEXaRGB(Utiles.COLOR_TEXT));
		mnOptions.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_COMPLEMENTARIO));
		menuBar.add(mnOptions);

		// Creación de un botón elemento de verificación perteneciente al botón de Menú
		// del JMenuBar
		JCheckBoxMenuItem checkModoOscuro = new JCheckBoxMenuItem("Modo Oscuro");
		checkModoOscuro.setToolTipText("Botón de verificación para activar el modo oscuro en la aplicación");
		checkModoOscuro.setBackground(new Color(0, 64, 128));
		checkModoOscuro.setForeground(Utiles.convierteHEXaRGB(Utiles.COLOR_TEXT));
		mnOptions.add(checkModoOscuro);

		/**
		 * Creación del JPanel para el relleno de datos y funcionalidad en la aplicación
		 */
		JPanelRound panelRegister = new JPanelRound();
		panelRegister.setBounds(299, 32, 403, 438);
		contentPane.add(panelRegister);
		panelRegister.setLayout(null);

		// Creación del PopUpMenú asociado al Panel Registro
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBounds(-10307, -10052, 143, 32);
		addPopup(panelRegister, popupMenu);

		// Creación de elemento pertenciente al PopUpMenú Panel Registro
		JMenuItem popUpCleanText = new JMenuItem("Limpiar Campos");
		popUpCleanText.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_COMPLEMENTARIO));
		popUpCleanText.setForeground(Utiles.convierteHEXaRGB(Utiles.COLOR_TEXT));
		popupMenu.add(popUpCleanText);

		// Creación de Label que da información sobre el Panel Registro
		JLabel lblRegistro = new JLabel("REGISTRO");
		lblRegistro.setForeground(Utiles.convierteHEXaRGB(Utiles.COLOR_TEXT));
		lblRegistro.setFont(new Font(Utiles.ROBOTO_BLACK, Font.BOLD, 20));
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setBounds(10, 5, 393, 73);
		panelRegister.add(lblRegistro);

		// Creación de Label para Nombre de Cuenta
		JLabel lblAccount = new JLabel("Nombre de la Cuenta:");
		lblAccount.setFont(new Font(Utiles.ROBOTO_BLACK, Font.BOLD, 12));
		lblAccount.setForeground(Utiles.convierteHEXaRGB(Utiles.COLOR_TEXT));
		lblAccount.setBounds(35, 120, 136, 14);
		panelRegister.add(lblAccount);

		// Creación de Label para Nombre de Usuario
		JLabel lblUserName = new JLabel("Nombre de la Usuario:");
		lblUserName.setFont(new Font(Utiles.ROBOTO_BLACK, Font.BOLD, 12));
		lblUserName.setForeground(Utiles.convierteHEXaRGB(Utiles.COLOR_TEXT));
		lblUserName.setBounds(35, 170, 136, 14);
		panelRegister.add(lblUserName);

		// Creación de Label para Contraseña
		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setFont(new Font(Utiles.ROBOTO_BLACK, Font.BOLD, 12));
		lblPassword.setForeground(Utiles.convierteHEXaRGB(Utiles.COLOR_TEXT));
		lblPassword.setBounds(35, 220, 136, 14);
		panelRegister.add(lblPassword);

		// Definición de campo editable para introducir el Nombre de la Cuenta
		tfAccount = new JTextField();
		tfAccount.setToolTipText(
				"Campo para introducir  el nombre de la cuenta de la credencial a guardar. No puede estar vacío.");
		tfAccount.setBorder(null);
		tfAccount.setHorizontalAlignment(SwingConstants.CENTER);
		tfAccount.setBounds(181, 118, 168, 20);
		panelRegister.add(tfAccount);
		tfAccount.setColumns(10);

		// Definición de campo editable para introducir el Nombre de la Usuario
		tfUserName = new JTextField();
		tfUserName.setToolTipText(
				"Campo para introducir  el nombre de usuario de la credencial a guardar. No puede estar vacío.");
		tfUserName.setBorder(null);
		tfUserName.setHorizontalAlignment(SwingConstants.CENTER);
		tfUserName.setColumns(10);
		tfUserName.setBounds(181, 168, 168, 20);
		panelRegister.add(tfUserName);

		// Definición de campo editable para introducir la contraseña
		tfPassword = new JTextField();
		tfPassword.setToolTipText(
				"Campo para introducir la contraseña de la cuenta de la credencial a guardar. No puede estar vacío.");
		tfPassword.setBorder(null);
		tfPassword.setHorizontalAlignment(SwingConstants.CENTER);
		tfPassword.setColumns(10);
		tfPassword.setBounds(181, 218, 168, 20);
		panelRegister.add(tfPassword);

		/**
		 * Acción en el campo editable de Contraseña para que al pulsar el botón enter
		 * haga la misma función que el botón de Guardar Contraseña
		 */
		tfPassword.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Creación de objeto con los datos del campos editables anteriores
				Credencial c = new Credencial(tfAccount.getText(), tfUserName.getText(), tfPassword.getText());

				// Llama a la función para guardar las contraseñas al JList
				ControladorListaCredenciales.guardarCredenciales(c, modeloLista);

				// Modificación de los campos editables para hacer más cómodo
				// el volver a introducir una nueva credencial
				tfAccount.setText("");
				tfUserName.setText("");
				tfPassword.setText("");

			}
		});

		// Creación de Botón Guardar contraseña
		JButtonRound btnSavePassword = new JButtonRound();
		btnSavePassword.setToolTipText("Botón para almacenar la contraseña en la lista.");
		btnSavePassword.setFont(new Font(Utiles.ROBOTO_BLACK, Font.BOLD, 12));
		btnSavePassword.setText("Guardar Contraseña");
		btnSavePassword.setColor3(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));
		btnSavePassword.setColor2(Utiles.convierteHEXaRGB(Utiles.COLOR_SECUNDARIO_M));
		btnSavePassword.setColor1(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));
		
		/**
		 * Acción en el Botón Guardar Contraseña para que al pulsar el botón 
		 * registre la contraseña del usuario definida en los campos de texto
		 */
		btnSavePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Creación de objeto con los datos del campos editables anteriores
				Credencial c = new Credencial(tfAccount.getText(), tfUserName.getText(), tfPassword.getText());
				// Llama a la función para guardar las contraseñas al JList
				ControladorListaCredenciales.guardarCredenciales(c, modeloLista);

				// Modificación de los campos editables para hacer más cómodo
				// el volver a introducir una nueva credencial
				tfAccount.setText("");
				tfUserName.setText("");
				tfPassword.setText("");
			}
		});
		btnSavePassword.setBounds(165, 300, 201, 34);
		panelRegister.add(btnSavePassword);

		// Creación de Botón para salir de la aplicación
		JButtonRound btnLogOut = new JButtonRound();
		btnLogOut.setToolTipText("Botón para salir de la aplicación.");
		btnLogOut.setFont(new Font(Utiles.ROBOTO_BLACK, Font.BOLD, 12));
		btnLogOut.setText("Salir");
		btnLogOut.setColor3(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));
		btnLogOut.setColor2(Utiles.convierteHEXaRGB(Utiles.COLOR_SECUNDARIO_M));
		btnLogOut.setColor1(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));
		
		// Acción del Botón LogOut
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Crea una objeto personalizado hijo JDialog
				DialogLogOut dialogLogOut = new DialogLogOut(new CredentialsList(), modoOscuro);
				// Se establece el JDialog como visible
				dialogLogOut.setVisible(true);
				
				/**
				 * Se comprueba mediante la respuesta que se clica en el JDIalog
				 * si se ha pulsado en sí se realizan dos acciones
				 */
				if (dialogLogOut.obtenerRespuesta() == true) {
					// Se llama al método que realizará el guardado de los elementos del JList en
					// un fichero binario para cargarlo en siguientes sesiones de la aplicación
					ControladorListaCredenciales.guardarDatos();
					// Se cierra la ventana en la que nos encontramos y finaliza la aplicación.
					dispose();
					System.exit(0);
				}
			}
		});
		btnLogOut.setBounds(206, 345, 116, 32);
		panelRegister.add(btnLogOut);

		/**
		 * Se establece la función que tendrá el botón PopUp para limpiar los campos de texto
		 */
		popUpCleanText.addActionListener(v -> {
			tfAccount.setText("");
			tfUserName.setText("");
			tfPassword.setText("");
			tfAccount.requestFocus();
		});
		
		/**
		 * Se establece la función que tendrá el botón PopUp para eliminar elementos de la lista
		 */
		popUpJListDelete.addActionListener(v -> {
			// Se recoge el ínidice del elemento que esté seleccionado
			int credencialSeleccionada = listaCredenciales.getSelectedIndex();

			// Se llama a la función para eliminar credencial
			ControladorListaCredenciales.eliminarCredencial(credencialSeleccionada, modeloLista);
		});

		/**
		 * Funcionalidad para el botón de verificación del menú Opciones "Modo Oscuro"
		 */
		checkModoOscuro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Se almacena el botón de verificación está de modo oscuro está marcado
				modoOscuro = checkModoOscuro.isSelected();

				// Si está marcado se establece elemento por elemento el color que tendrá cada uno
				// de ellos en el modo oscuro
				if (modoOscuro) {
					contentPane.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_PRIMARIO));

					menuBar.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_PRIMARIO));
					mnArchivo.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_PRIMARIO));
					mnCargarPasswordDesdeArchivo.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_PRIMARIO));
					mnOptions.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_PRIMARIO));
					checkModoOscuro.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_PRIMARIO));

					popUpCleanText.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_PRIMARIO));
					popUpCleanText.setForeground(Utiles.convierteHEXaRGB(Utiles.COLOR_TEXT));
					popUpJListDelete.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_PRIMARIO));
					popUpJListDelete.setForeground(Utiles.convierteHEXaRGB(Utiles.COLOR_TEXT));

					panelCredentialList.setColorContorno(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_RESALTADO));
					panelCredentialList.setColorPrimario(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_PRIMARIO));
					panelCredentialList.setColorSecundario(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_SECUNDARIO));

					panelRegister.setColorContorno(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_RESALTADO));
					panelRegister.setColorPrimario(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_PRIMARIO));
					panelRegister.setColorSecundario(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_SECUNDARIO));

					btnSavePassword.setColor1(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_PRIMARIO));
					btnSavePassword.setColor2(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_SECUNDARIO));
					btnSavePassword.setColor3(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_RESALTADO));

					btnLogOut.setColor1(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_PRIMARIO));
					btnLogOut.setColor2(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_SECUNDARIO));
					btnLogOut.setColor3(Utiles.convierteHEXaRGB(Utiles.COLOR_DARK_RESALTADO));

				} else { // Si no está marcado se vuelve a definir los colores que tiene cada elemento por defecto

					contentPane.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_COMPLEMENTARIO));

					menuBar.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_COMPLEMENTARIO));
					mnArchivo.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_COMPLEMENTARIO));
					mnCargarPasswordDesdeArchivo.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_COMPLEMENTARIO));
					mnOptions.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_COMPLEMENTARIO));
					checkModoOscuro.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_COMPLEMENTARIO));

					popUpCleanText.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_COMPLEMENTARIO));
					popUpJListDelete.setBackground(Utiles.convierteHEXaRGB(Utiles.COLOR_COMPLEMENTARIO));

					panelCredentialList.setColorContorno(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));
					panelCredentialList.setColorPrimario(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));
					panelCredentialList.setColorSecundario(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));

					panelRegister.setColorContorno(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));
					panelRegister.setColorPrimario(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));
					panelRegister.setColorSecundario(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));

					btnSavePassword.setColor1(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));
					btnSavePassword.setColor2(Utiles.convierteHEXaRGB(Utiles.COLOR_SECUNDARIO_M));
					btnSavePassword.setColor3(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));

					btnLogOut.setColor1(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));
					btnLogOut.setColor2(Utiles.convierteHEXaRGB(Utiles.COLOR_SECUNDARIO_M));
					btnLogOut.setColor3(Utiles.convierteHEXaRGB(Utiles.COLOR_PRIMARIO));

				}

			}
		});
		
		// Creación de la imagen de icono de la ventana que aparece arriba a la izquierda
		Image icon = new ImageIcon(
				this.getClass().getResource("/es/ies/carrillo/ramirez_medina_rafael/bolentin_tema7/assets/logo.png"))
				.getImage();
		setIconImage(icon);
	}

	/**
	 * Método autogenerado al crear un JPopUp que define los eventos del ratón que
	 * se realizan
	 * 
	 * @param component
	 * @param popup
	 */
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
