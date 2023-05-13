package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class TestSpotify {

	@Test
	public void QueSePuedaCrearCuenta() { // Test solo para guia de inicio.
		
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
		
		Cuenta cuenta = new Cuenta(1,"jacqui@gmail.com");
		Cancion cancion = new Cancion("Te guardo","alternativa","Silvina Estrada", 3.45);
	
		cuenta.agregarCancion(cancion);
		
		Integer cantCancionesEsperadasEnLista = 1;
		Integer cantCancionesObtenidas = cuenta.cantDeCancionesEnLaLista();
		
		assertEquals(cantCancionesEsperadasEnLista, cantCancionesObtenidas);
	}
	
	@Test
	public void QueNoSePuedaAgregarCancionesRepetidasAUnaListaDeReproduccion() {
		// Preparacion
		Cuenta cuenta = new Cuenta(1,"DylanThomas@gmail.com");
		Cancion cancion1 = new Cancion("Esta vida me encanta","alternativa","Montserrat Alay", 2.35);
		Cancion cancion2 = new Cancion("SummerTime Sadnees","alternativa","Lana Del Rey", 4.20);
		
		// Ejecucion
		cuenta.agregarCancion(cancion1);
		cuenta.agregarCancion(cancion2);
		cuenta.agregarCancion(cancion1);
		
		// Verificacion
		int cantCancionesEsperadasEnLista = 2;
		int cantCancionesObtenidas = cuenta.cantDeCancionesEnLaLista();
		
		assertEquals(cantCancionesEsperadasEnLista, cantCancionesObtenidas);
	}

	@Test
	public void QueSeReproduzcaUnaCancion() {
		// Preparacion
		Cuenta cuenta = new Cuenta(1, "DylanThomas@gmail.com");
	    Cancion cancion1 = new Cancion("Esta vida me encanta","alternativa","Montserrat Alay", 2.35);
		// Ejecucion
	    cuenta.agregarCancion(cancion1);
	    
	    ByteArrayOutputStream output = new ByteArrayOutputStream(); // Guardo la salida de la consola
	    PrintStream printSalida = new PrintStream(output); // Guardo la salida en una variable para comparar
	    System.setOut(printSalida);

	    cuenta.reproducirCancion(cancion1);
	    
	    System.setOut(System.out);
	    String salidaGenerada = output.toString().trim();

	    // Verificacion
	    String salidaEsperada = "Esta vida me encanta, Montserrat Alay, alternativa, 2.35min.";
	    assertEquals(salidaEsperada, salidaGenerada);
	}
	
	@Test
	public void QueSePuedaCambiarDeCancionesEnCuentaClassicYPremiumPeroNoEnLasCuentaFree() {
		// Preparacion
		Spotify spotify = new Spotify();
		Premium cuenta1 = new Premium(1, "Dylan@gmail.com");
		Classic cuenta2 = new Classic(2, "Thomas@gmail.com");
		Free cuenta3 = new Free(3, "Fernandez@gmail.com");
		
		// Ejecucion
		spotify.permitirCambiarCancion(cuenta1);
		spotify.permitirCambiarCancion(cuenta2);		
		spotify.permitirCambiarCancion(cuenta3);		

		// Verificacion
		assertFalse(cuenta1.getCambioCancion());
		assertFalse(cuenta2.getCambioCancion());
		assertTrue(cuenta3.getCambioCancion());
	}
	
	@Test
	public void QueSePuedaCrearMasDeUnaPlaylistSoloSiEsCuentaPremium() {
		//Preparacion
		Spotify spotify = new Spotify();
		Premium cuenta1 = new Premium(1, "Dylan@gmail.com");
		Classic cuenta2 = new Classic(2, "Thomas@gmail.com");
		Free cuenta3 = new Free(3, "Fernandez@gmail.com");

	    Cancion cancion1 = new Cancion("Esta vida me encanta","español","Montserrat Alay", 2.35);
		Cancion cancion2 = new Cancion("SummerTime Sadnees","english","Lana Del Rey", 4.20);
		Cancion cancion3 = new Cancion("Quedate vol.44","español","Quevedo", 3.15);
		Cancion cancion4 = new Cancion("Hasta la raiz","español","Natalia Lafourcade", 4.40);
		Cancion cancion5 = new Cancion("All too well","english","Taylor Swift", 10.10);
		
		// Ejecucion Cuenta 1
		spotify.permitirTenerVariasPlaylist(cuenta1);	
		
		cuenta1.crearPlaylist("Español");
		cuenta1.crearPlaylist("Ingles");
		
		cuenta1.agregarCancionAPlaylist(cancion1, "Español");
		cuenta1.agregarCancionAPlaylist(cancion2, "Ingles");
		cuenta1.agregarCancionAPlaylist(cancion3, "Español");
		cuenta1.agregarCancionAPlaylist(cancion4, "Español");
		cuenta1.agregarCancionAPlaylist(cancion5, "Ingles");

		// Cuenta 2	y 3
		spotify.permitirTenerVariasPlaylist(cuenta2);		
		spotify.permitirTenerVariasPlaylist(cuenta3);

		
		// Verificacion cuenta1 cantidad de canciones en cada Playlist
		int cantDePlaylistEsperadas = 2;
		int cantDePlaylistObtenidas = cuenta1.cantPlaylists();

		assertEquals(cantDePlaylistEsperadas, cantDePlaylistObtenidas);

		
		// Verificacion donde solo la cuenta Premium pueda crear mas de 1 Playlist
		assertFalse(cuenta1.getMasDeUnaPlaylist());
		assertTrue(cuenta2.getMasDeUnaPlaylist());
		assertTrue(cuenta3.getMasDeUnaPlaylist());	
	}
	
	@Test
	public void QueSePuedaSaberLaCantidadDeCancionesQueHayEnCadaPlaylist() {
	    // Preparacion
	    Spotify spotify = new Spotify();
	    Premium cuenta1 = new Premium(1, "Dylan@gmail.com");
	    Cancion cancion1 = new Cancion("Esta vida me encanta","español","Montserrat Alay", 2.35);
		Cancion cancion2 = new Cancion("SummerTime Sadnees","english","Lana Del Rey", 4.20);
		Cancion cancion3 = new Cancion("Quedate vol.44","español","Quevedo", 3.15);
		Cancion cancion4 = new Cancion("Hasta la raiz","español","Natalia Lafourcade", 4.40);
		Cancion cancion5 = new Cancion("All too well","english","Taylor Swift", 10.10);

	    // Ejecucion
	    spotify.permitirTenerVariasPlaylist(cuenta1);

		cuenta1.crearPlaylist("Español");
		cuenta1.crearPlaylist("Ingles");
		
		cuenta1.agregarCancionAPlaylist(cancion1, "Español");
		cuenta1.agregarCancionAPlaylist(cancion2, "Ingles");
		cuenta1.agregarCancionAPlaylist(cancion3, "Español");
		cuenta1.agregarCancionAPlaylist(cancion4, "Español");
		cuenta1.agregarCancionAPlaylist(cancion5, "Ingles");

	    // Verificacion Playlist "Español"
	    int cantCancionesEsperadasEnPlaylist1 = 3;
	    int cantCancionesObtenidas1 = cuenta1.cantDeCancionesEnLaPlaylist("Español");

	    assertEquals(cantCancionesEsperadasEnPlaylist1, cantCancionesObtenidas1);
	    
	    // Verificacion Playlist "Ingles"
	    int cantCancionesEsperadasEnPlaylist2 = 2;
	    int cantCancionesObtenidas2 = cuenta1.cantDeCancionesEnLaPlaylist("Ingles");

	    assertEquals(cantCancionesEsperadasEnPlaylist2, cantCancionesObtenidas2);
	}
	
	@Test
	public void queSePuedaReproducirUnaLista() {
		
		Integer cantidadDeReproduccionesEsperada = 4;
		
		Cuenta cuenta = new Cuenta(1, "mario@outllook.com");
		Cancion cancion1 = new Cancion("Be the one","pop","Dua Lipa",3.23);
		Cancion cancion2 = new Cancion("Get Lucky","funk","Daft Punk",6.10);
		Cancion cancion3 = new Cancion("Memories","electronica","David Guetta",3.31);
		Cancion cancion4 = new Cancion("It's My Life","rock","Bon Jovi",3.45);

		cuenta.agregarCancion(cancion1);
		cuenta.agregarCancion(cancion2);
		cuenta.agregarCancion(cancion3);
		cuenta.agregarCancion(cancion4);
		
		assertEquals(cantidadDeReproduccionesEsperada, cuenta.reproducirLista());
	}
		
	@Test
	public void queSePuedaCambiarLaCalidadDeLaMusicaEnCuentaPremiumYClassicPeroNoEnFree() {
		Calidad calidad1 = Calidad.Alta;
		Calidad calidad2 = Calidad.Maximo;
		
		Cuenta cuenta1 = new Premium(1, "mario@outllook.com");
		Cuenta cuenta2 = new Free(2, "alberto@outlook.com");
		Cuenta cuenta3 = new Classic(3,"checchia@outlook.com");
		Spotify config = new Spotify();
		
		assertEquals(true, config.cambiarCalidadCancion(cuenta1, calidad1));
		assertEquals(calidad1, config.getCalidad());
		assertEquals(false, config.cambiarCalidadCancion(cuenta2, calidad1));
		assertEquals(false, config.cambiarCalidadCancion(cuenta3, calidad2));
		assertEquals(true, config.cambiarCalidadCancion(cuenta3, calidad1));
	}
	
	@Test
	public void queSePuedaEscucharEnOtroDispositivoConCuentaPremiumYClassicPeroNoEnFree() {
		Dispositivo dispositivo = Dispositivo.TV;
		
		Cuenta cuenta1 = new Premium(1, "mario@outllook.com");
		Cuenta cuenta2 = new Free(2, "alberto@outlook.com");
		Cuenta cuenta3 = new Classic(3,"checchia@outlook.com");
		Spotify config = new Spotify();
		
		assertEquals(true, config.reproducirEnOtroDispositivo(cuenta1, dispositivo));
		assertEquals(dispositivo, config.getDispositivo());
		assertEquals(false, config.reproducirEnOtroDispositivo(cuenta2, dispositivo));
		assertEquals(true, config.reproducirEnOtroDispositivo(cuenta3, dispositivo));
	}
	
	@Test
	public void quePuedaTenerDescuentoDel50PorCientoSiLaCuentaEsPremium() {
		Double precioPremium = 400.00;
		Double precioClassic = 200.00;
		Double precioFree = 0.00;
		Double valorEsperado = 200.00;
		
		Cuenta cuenta1 = new Premium(1, "mario@outllook.com");
		Cuenta cuenta2 = new Free(2, "alberto@outlook.com");
		Cuenta cuenta3 = new Classic(3,"checchia@outlook.com");
		Spotify config = new Spotify();
		
		assertEquals(valorEsperado, config.descuento(cuenta1, precioPremium));
	}
	
	@Test
	public void quePuedaTenerDescuentoDel25PorCientoSiLaCuentaEsClassic() {
		Double precioPremium = 400.00;
		Double precioClassic = 200.00;
		Double precioFree = 0.00;
		Double valorEsperado = 50.00;
		
		Cuenta cuenta1 = new Premium(1, "mario@outllook.com");
		Cuenta cuenta2 = new Free(2, "alberto@outlook.com");
		Cuenta cuenta3 = new Classic(3,"checchia@outlook.com");
		Spotify config = new Spotify();
		
		assertEquals(valorEsperado, config.descuento(cuenta3, precioClassic));
	}
	
	@Test
	public void queNoPuedaTenerDescuentoSiLaCuentaEsFree() {
		Double precioPremium = 400.00;
		Double precioClassic = 200.00;
		Double precioFree = 0.00;
		Double valorEsperado = 0.00;
		
		Cuenta cuenta1 = new Premium(1, "mario@outllook.com");
		Cuenta cuenta2 = new Free(2, "alberto@outlook.com");
		Cuenta cuenta3 = new Classic(3,"checchia@outlook.com");
		Spotify config = new Spotify();
		
		assertEquals(valorEsperado, config.descuento(cuenta2, precioFree));
	}
}

