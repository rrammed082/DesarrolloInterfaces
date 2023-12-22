package es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import es.ies.carrillo.ramirez_medina_rafael.bolentin_tema7.controlador.ControladorLogin;

public class LoginTest {
	@Test
    public void testLoginCorrecto() {
		String usuario = "user";
		String password = "1234";
	
        assertTrue(ControladorLogin.comprobarLogin(usuario, password.toCharArray()));
    }

    @Test
    public void testLoginIncorrecto() {
    	String usuario = "admin";
		String password = "admin";
		assertFalse(ControladorLogin.comprobarLogin(usuario, password.toCharArray()));
    }

    @Test
    public void testCamposVacios() {
    	String usuario = "";
		String password = "";
		assertFalse(ControladorLogin.comprobarLogin(usuario, password.toCharArray()));
    }
}
