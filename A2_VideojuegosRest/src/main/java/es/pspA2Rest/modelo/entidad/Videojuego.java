package es.pspA2Rest.modelo.entidad;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Videojuego other = (Videojuego) obj;
		return id == other.id && Objects.equals(nombre, other.nombre);
	}

}
