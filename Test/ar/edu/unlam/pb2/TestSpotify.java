package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSpotify {

	@Test
	public void QueSePuedaCrearCuenta() {
		// Test solo para guia de inicio.
		
		Cuenta perfil = new Cuenta(1,"jacqui@gmail.com");
		
		Integer nroEsperado = 1;
		String emailAsociado = "jacqui@gmail.com";
		
		
		assertEquals(nroEsperado, perfil.getNroDeCuenta());
		assertEquals(emailAsociado, perfil.getEmail());
	}
}
