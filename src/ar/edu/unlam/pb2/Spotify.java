package ar.edu.unlam.pb2;
import java.util.HashSet;

public class Spotify {//menu dentro del reproductor
	private Dispositivo dispositivo;
	private Calidad calidad;
	
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
	
	public Double descuento(Cuenta cuenta, Double precio) {
		if(cuenta instanceof Premium) {
			precio *= 0.50;
		}
		if(cuenta instanceof Classic) {
			precio *= 0.25;
		}
		return precio;
	}
	
	public Boolean cambiarCalidadCancion(Cuenta cuenta, Calidad calidad) {
		if(cuenta instanceof Premium) {
			this.setCalidad(calidad);
			return true;
		}
		if(cuenta instanceof Free) { //En Free no se puede cambiar la calidad
			return false;
		}
		if(cuenta instanceof Classic) { //En Classic no se puede utilizar la maxima calidad
			if(calidad != Calidad.Maximo) {
				return true;
			}
			else {
				return false;
			}
		}
		return null;
		
	}
	
	public Boolean reproducirEnOtroDispositivo(Cuenta cuenta, Dispositivo dispositivo) {
		if(cuenta instanceof Premium) {
			this.setDispositivo(dispositivo);
			return true;
		}
		if(cuenta instanceof Free) { //En Free no se puede cambiar la calidad
				return false;
		}
		if(cuenta instanceof Classic) {
				return true;
		}
		return null;
	}

	public Calidad getCalidad() {
		return calidad;
	}

	public void setCalidad(Calidad calidad) {
		this.calidad = calidad;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
}

