package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class Premium extends Cuenta {
	ArrayList<Cancion> descargas = new ArrayList<>();
	
	Premium(Integer nroDeCuenta, String email) {
		super(nroDeCuenta, email);
		
	}

	public ArrayList<Cancion> getDescargas() {
		return descargas;
	}

	public void setDescargas(ArrayList<Cancion> descargas) {
		this.descargas = descargas;
	}

	
}
