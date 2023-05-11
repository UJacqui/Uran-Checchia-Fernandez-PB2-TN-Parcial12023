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
	
	@Test
	public void QueSePuedaDescargarMusicaSiEsCuentaPremium() {
		Spotify spotify = new Spotify();
		Premium cuenta = new Premium(2, "jacqui@gmail.com");
		Cancion cancion = new Cancion("Te guardo","alternativa","Silvina Estrada", 3.45);

		
		spotify.descargarCancion(cuenta,cancion);
		Integer descargasRealizadas = 1;
		Integer obtenidas = cuenta.descargas.size();
		
		assertEquals(descargasRealizadas, obtenidas);

	}
	@Test
	public void QueNoSePuedaDescargarMusicaSiEsCuentaClassic() {
		Spotify spotify = new Spotify();
		Classic cuenta = new Classic(2, "jacqui@gmail.com");
		Cancion cancion = new Cancion("Te guardo","alternativa","Silvina Estrada", 3.45);
		
		Boolean esperado = spotify.descargarCancion(cuenta,cancion);
		
		assertFalse(esperado);
	
	}
	
	@Test
	public void QueNoTengaAnunciosSiEsCuentaPremiumOClassic() {
		Spotify spotify = new Spotify();
		Premium cuenta = new Premium(2, "jacqui@gmail.com");
		Classic cuenta2 =new Classic(3, "melissa@gmail.com");		
		
		spotify.validarAnuncios(cuenta);
		spotify.validarAnuncios(cuenta2);		

		assertFalse(cuenta.getAnuncio());
		assertFalse(cuenta2.getAnuncio());		
		
	}
	
	@Test
	public void QueTengaAnunciosSiLaCuentaEsFree() {
		Spotify spotify = new Spotify();
		Cuenta cuenta3 = new Free(4, "uran@gmail.com");
		
		spotify.validarAnuncios(cuenta3);
		
		assertTrue(cuenta3.getAnuncio());		
		
	}


	@Test
	public void QueSePuedanAgregarCancionesAUnaLista() {
		
		Spotify spotify = new Spotify();
		Cuenta cuenta = new Cuenta(1,"jacqui@gmail.com");
		Cancion cancion = new Cancion("Te guardo","alternativa","Silvina Estrada", 3.45);
	
		cuenta.agregarCanciones(cancion);
		
		Integer cantCancionesEsperadasEnLista = 1;
		Integer cantCancionesObtenidas = cuenta.cantDeCancionesEnLaLista();
		
		assertEquals(cantCancionesEsperadasEnLista, cantCancionesObtenidas);
	}
	
	

}
