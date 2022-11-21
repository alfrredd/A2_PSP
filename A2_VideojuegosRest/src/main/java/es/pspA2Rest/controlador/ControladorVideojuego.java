package es.pspA2Rest.controlador;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.pspA2Rest.modelo.entidad.Videojuego;
import es.pspA2Rest.modelo.persistencia.DaoVideojuego;

@RestController
public class ControladorVideojuego {
	
	@Autowired
	private DaoVideojuego daoVideojuego;
	//Obtener
	@GetMapping(path="videojuegos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> getVideojuego(@PathVariable("id") int id) {
		System.out.println("Buscando videojuego: " + id);
		Videojuego v = daoVideojuego.get(id);
		if(v != null) {
			return new ResponseEntity<Videojuego>(v,HttpStatus.OK);
		} else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);
		}
	}
	// Alta 
	@PostMapping(path="videojuegos",consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> altaVideojuego(@RequestBody Videojuego v) {
		List<Videojuego> listaVideojuegos = daoVideojuego.list();
		System.out.println("altaVideojuego: Nombre del videojuego: " + v.getNombre());
		System.out.println(listaVideojuegos);
		List<Videojuego> listaNombresR = new ArrayList<Videojuego>();
		for(Videojuego p : listaVideojuegos) {
			if(p.getNombre().equalsIgnoreCase(v.getNombre())) {
				listaNombresR.add(p);
			}
		}
			if(listaNombresR.isEmpty()) {
				daoVideojuego.add(v);
				return new ResponseEntity<Videojuego>(v,HttpStatus.CREATED);
			}else {
				System.out.println("altaVideojuego: Nombre del videojuego repetido.");
				return new ResponseEntity<Videojuego>(HttpStatus.BAD_REQUEST);
			}
		
	}
	
	// Listar
	@GetMapping(path="videojuegos",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Videojuego>> listarVideojuegos() {
		List<Videojuego> listaVideojuegos = null;
			System.out.println("Listando Videojuegos:");
			listaVideojuegos = daoVideojuego.list();			
		System.out.println(listaVideojuegos);
		return new ResponseEntity<List<Videojuego>>(listaVideojuegos,HttpStatus.OK);
	}
	// Modificar
	@PutMapping(path="videojuegos/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> modificarVideojuego(
			@PathVariable("id") int id, 
			@RequestBody Videojuego v) {
		System.out.println("ID a modificar: " + id);
		System.out.println("Datos a modificar: " + v);
		v.setId(id);
		
		List<Videojuego> listaVideojuegos = daoVideojuego.list();
		List<Videojuego> listaNombresR = new ArrayList<Videojuego>();
		for(Videojuego p : listaVideojuegos) {
			if(p.getNombre().equalsIgnoreCase(v.getNombre())) {
				listaNombresR.add(p);
			}
		}
		if(listaNombresR.isEmpty()) {
			Videojuego vUp = daoVideojuego.update(v);
			if(vUp != null) {
				return new ResponseEntity<Videojuego>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);
			}
		}else {
			System.out.println("ModificarVideojuego: Nombre del videojuego repetido.");
			return new ResponseEntity<Videojuego>(HttpStatus.BAD_REQUEST);
		}
		
	}
	// Baja
	@DeleteMapping(path="videojuegos/{id}")
	public ResponseEntity<Videojuego> borrarVideojuego(@PathVariable("id") int id) {
		System.out.println("Id del juego a borrar: " + id);
		Videojuego v = daoVideojuego.delete(id);
		if(v != null) {
			return new ResponseEntity<Videojuego>(v,HttpStatus.OK);
		}else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
