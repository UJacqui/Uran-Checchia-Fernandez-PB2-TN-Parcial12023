package ar.edu.unlam.pb2;
import java.util.HashSet;

public class Spotify {//menu dentro del reproductor
	
	HashSet<Cuenta> cuentas = new HashSet<>();	
	HashSet<Cancion> canciones = new HashSet<>();

	public boolean descargarCancion(Cuenta cuenta,Cancion cancion) {
		if (cuenta instanceof Premium) {
			((Premium) cuenta).getDescargas().add(cancion);// descargo cancion a listaPremiun de descargas
		return true;	
		}
		return false;
	}

	public void validarAnuncios(Cuenta cuenta) {
	
		if (cuenta instanceof Classic || cuenta instanceof Premium) {	 
			cuenta.setAnuncio(false);
		}else {
			cuenta.setAnuncio(true);
			}	
		}
	
	public void permitirCambiarCancion(Cuenta cuenta) {
		
		if (cuenta instanceof Classic || cuenta instanceof Premium) {	 
			cuenta.setCambioCancion(false);
	        System.out.println("Se cambio de cancion correctamente");
		}else {
			cuenta.setCambioCancion(true);
	        System.out.println("No se pudo cambiar de cancion, agrega una suscripcion Classic o Premium.");
			}	
		}
	
	public void permitirTenerVariasPlaylist(Cuenta cuenta) {
		
		if (cuenta instanceof Premium) {	 
			cuenta.setMasDeUnaPlaylist(false);
			System.out.println("Se agrego la playlist correctamente");
		}else {
			cuenta.setMasDeUnaPlaylist(true);
			System.out.println("No se pudo agregar una nueva playlis, suscribrace al paquete Premium.");
			}	
		}
	}

