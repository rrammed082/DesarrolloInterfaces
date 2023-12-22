package es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.main;

import java.awt.EventQueue;

import es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.vista.Login;


public class Principal {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Se crea un objeto de la clase y se establece como visible
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
