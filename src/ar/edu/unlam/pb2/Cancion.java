package ar.edu.unlam.pb2;

public class Cancion {
	
	private String nombre;
	private String genero;
	private String cantante;
	private Double duracion;	
	
	Cancion(String nombre, String genero, String cantante, Double duracion) {
		this.nombre = nombre;
		this.genero = genero;
		this.cantante = cantante;
		this.duracion = duracion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCantante() {
		return cantante;
	}

	public void setCantante(String cantante) {
		this.cantante = cantante;
	}

	public Double getDuracion() {
		return duracion;
	}

	public void setDuracion(Double duracion) {
		this.duracion = duracion;
	}
	

}
