package ar.edu.unlam.pb2;
import java.util.ArrayList;
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
	}