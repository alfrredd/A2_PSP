package es.pspA2Rest.modelo.persistencia;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import es.pspA2Rest.modelo.entidad.Videojuego;

@Component
public class DaoVideojuego {
	public List<Videojuego> listaVideojuegos;
	public int contador;
	
	public DaoVideojuego() {
		System.out.println("DaoVideojuego: Creando Lista de Videojuegos");
		listaVideojuegos = new ArrayList<Videojuego>();
		Videojuego v1 = new Videojuego(contador++, "Super Mario Bros", "Nintendo", 89);
		Videojuego v2 = new Videojuego(contador++, "Grand Theft Auto V", "Rockstar Games", 97);
		Videojuego v3 = new Videojuego(contador++, "Sonic Frontiers", "Sega", 58);
		Videojuego v4 = new Videojuego(contador++, "Elden Ring", "Bandai Namco", 96);
		Videojuego v5 = new Videojuego(contador++, "FIFA 23", "EA", 77);
		listaVideojuegos.add(v1);
		listaVideojuegos.add(v2);
		listaVideojuegos.add(v3);
		listaVideojuegos.add(v4);
		listaVideojuegos.add(v5);
	}
	
	public Videojuego get(int posicion) {
		try {
			return listaVideojuegos.get(posicion);
		}catch (IndexOutOfBoundsException iobe) {
			System.out.println("Fuera de rango");
			return null;
		}
	}
	
	public List<Videojuego> list() {
		return listaVideojuegos;
	}
	
	public void add(Videojuego v) {
		v.setId(contador++);
		listaVideojuegos.add(v);
	}
	
	public Videojuego delete(int posicion) {
		try {
			return listaVideojuegos.remove(posicion);
		}catch (IndexOutOfBoundsException e) {
			System.out.println("Persona a borrar fuera de rango");
			return null;
		}
	}
	
	public Videojuego update(Videojuego v) {
		try {
			Videojuego vA = listaVideojuegos.get(v.getId());
			vA.setNombre(v.getNombre());
			vA.setEmpresa(v.getEmpresa());
			vA.setNota(v.getNota());
			
			return vA;
		}catch (IndexOutOfBoundsException iobe) {
			System.out.println("Videojuego a actualizar fuera de rango");
			return null;
		}
	}
}
