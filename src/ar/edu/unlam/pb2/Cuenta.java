package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class Cuenta {
	private Integer nroDeCuenta;
	private String email;
	private Boolean anuncio;
	ArrayList <Cancion> listaDeReproduccion = new ArrayList<>();


	Cuenta(Integer nroDeCuenta, String email) {
		this.nroDeCuenta = nroDeCuenta;
		this.email = email;
	}

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
	
	public void agregarCanciones(Cancion cancion) {
		this.listaDeReproduccion.add(cancion);
	}
	
	public Integer cantDeCancionesEnLaLista() {
		return listaDeReproduccion.size();
		
	}

	public void reproducirLista(Cancion cancion) {
		
		for (Cancion canciones : listaDeReproduccion) {
			System.out.println( cancion.getNombre()+" artista:" + cancion.getCantante() + " Genero:" + cancion.getGenero() +" "+ cancion.getDuracion());
		}
	}
	
	

}
