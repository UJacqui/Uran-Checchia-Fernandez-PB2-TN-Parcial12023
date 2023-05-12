package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class Playlist {
    private String nombre;
    private ArrayList<Cancion> canciones;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }
    
    public int cantCancionesEnLaPlaylist() {
		return canciones.size();
    	
    }

}
