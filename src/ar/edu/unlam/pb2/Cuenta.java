package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class Cuenta {
	protected Integer nroDeCuenta;
	protected String email;
	protected Boolean anuncio;
	protected Boolean cambioCancion;
	protected Boolean masDeUnaPlaylist;
	

	ArrayList<Cancion> listaDeReproduccion = new ArrayList<>();
    ArrayList<Playlist> playlists = new ArrayList<>();
    

	Cuenta(Integer nroDeCuenta, String email) {
		this.nroDeCuenta = nroDeCuenta;
		this.email = email;
	}
	// -------------------------------------Getters and Setters
	public Integer getNroDeCuenta() {
		return nroDeCuenta;
	}

	public void setNroDeCuenta(Integer nroDeCuenta) {
		this.nroDeCuenta = nroDeCuenta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Boolean getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Boolean anuncio) {
		this.anuncio = anuncio;
	}
	
	
	public Boolean getCambioCancion() {
		return cambioCancion;
	}

	public void setCambioCancion(Boolean cambioCancion) {
		this.cambioCancion = cambioCancion;
	}

	public Boolean getMasDeUnaPlaylist() {
		return masDeUnaPlaylist;
	}

	public void setMasDeUnaPlaylist(Boolean masDeUnaPlaylist) {
		this.masDeUnaPlaylist = masDeUnaPlaylist;
	}
	// -------------------------------------Getters and Setters
	
	// -------------------------------------Methods
	public void agregarCancion(Cancion cancion) {
	    if (!listaDeReproduccion.contains(cancion)) {
	        listaDeReproduccion.add(cancion);
	        System.out.println("Se agrego correctamente.");
	    }else {
	        System.out.println("No se pudo agregar por repetida.");
	    }
	}
	
	public Integer cantDeCancionesEnLaLista() {
		return listaDeReproduccion.size();
	}
	
	public Integer cantDeCancionesEnLaPlaylist(String nombre) {
        for(Playlist playlist : playlists){
        if (playlist.getNombre().equals(nombre)) {
    		return playlist.cantCancionesEnLaPlaylist();
        	}
        }
		return null;
	}

	public void crearPlaylist(String nombre) {
	    Playlist playlist = new Playlist(nombre);
	        playlists.add(playlist);
	}
	
    public void agregarCancionAPlaylist(Cancion cancion, String nombrePlaylist) {
        for (Playlist playlist : playlists) {
            if (playlist.getNombre().equals(nombrePlaylist)) {
                playlist.agregarCancion(cancion);
            }
        }
    }
	public int cantPlaylists() {
	        return playlists.size();
	}
    
	public void reproducirCancion(Cancion cancion) {
		
		for (Cancion canciones : listaDeReproduccion) {
			System.out.println( cancion.getNombre()+", " + cancion.getCantante() + ", " + cancion.getGenero() +", "+ cancion.getDuracion()+"min.");
		}
	}
	
	public Integer reproducirLista() {
		Integer reproducciones = 0;
		for (Cancion canciones : listaDeReproduccion) {
			if(canciones != null)
			reproducciones++;
		}
		return reproducciones;
	}
	
	// -------------------------------------Methods
	
}
