package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class Premium extends Cuenta {
	ArrayList<Cancion> descargas = new ArrayList<>();
	private List<Playlist> playlists;
	
	Premium(Integer nroDeCuenta, String email) {
		super(nroDeCuenta, email);
	}

	public ArrayList<Cancion> getDescargas() {
		return descargas;
	}

	public void setDescargas(ArrayList<Cancion> descargas) {
		this.descargas = descargas;
	}

	public List<Playlist> getPlaylists() {
        return playlists;
    }
	
    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
    

}
