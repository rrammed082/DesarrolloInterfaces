package es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.swing.DefaultListModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.controlador.ControladorListaCredenciales;
import es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.modelo.Credencial;
import es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.vista.CredentialsList;

public class CredentialList {
	 private CredentialsList credentialsList;
	    private DefaultListModel<String> modeloLista;

	    @BeforeEach
	    void setUp() {
	        credentialsList = new CredentialsList();
	        modeloLista = new DefaultListModel<>();
	    }

	    @Test
	    void testGuardarCredencialesConCamposVacios() {
	        ControladorListaCredenciales.guardarCredenciales(new Credencial("", "", ""), modeloLista);
	        assertEquals(0, modeloLista.size(), "La lista no debería contener elementos");
	    }

	    @Test
	    void testGuardarCredencialesConCamposNoVacios() {
	        ControladorListaCredenciales.guardarCredenciales(new Credencial("Twitter", "rafa", "1234"), modeloLista);
	        assertEquals(1, modeloLista.size(), "La lista debería contener un elemento");
	    }

	    @Test
	    void testEliminarCredencial() {
	        Credencial credencial = new Credencial("Twitter", "rafa", "1234");
	        ControladorListaCredenciales.guardarCredenciales(credencial, modeloLista);
	        ControladorListaCredenciales.eliminarCredencial(0, modeloLista);
	        assertEquals(0, modeloLista.size(), "La lista no debería contener elementos después de eliminar");
	    }
}
