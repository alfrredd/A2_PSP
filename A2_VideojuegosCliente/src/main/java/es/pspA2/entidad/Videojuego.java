package es.pspA2.entidad;

import org.springframework.stereotype.Component;

@Component
public class Videojuego {

	private int id;
	private String nombre;
	private String empresa;
	private int nota;

	public Videojuego(int id, String nombre, String empresa, int nota) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.empresa = empresa;
		this.nota = nota;
	}

	public Videojuego() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", nombre=" + nombre + ", empresa=" + empresa + ", nota=" + nota + "]";
	}

}
