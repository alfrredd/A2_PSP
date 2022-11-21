package es.pspA2.servicio;

import java.util.Arrays;
import java.util.List;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import es.pspA2.entidad.Videojuego;

@Service
public class SPVideojuego {
	public static final String URL = "http://localhost:8080/videojuegos/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Videojuego obtener(int id) {
		try {
			ResponseEntity<Videojuego> re = restTemplate.getForEntity(URL + id, Videojuego.class);
			HttpStatus hs = re.getStatusCode();
			if(hs == HttpStatus.OK) {
				return re.getBody();
			}else {
				System.out.println("Respuesta No Aceptada");
				return null;
			}
		}catch (HttpClientErrorException e) {
			System.out.println("(obtener) Videojuego No Encontrado" + id);
			System.out.println("(obtener) Codigo de Respuesta: " + e.getStatusCode());
			return null;
		}
	}
	
	public Videojuego alta(Videojuego v){
		try {
			ResponseEntity<Videojuego> re = restTemplate.postForEntity(URL, v, Videojuego.class);
			System.out.println("(alta) -> Codigo de respuesta " + re.getStatusCode());
			return re.getBody();
		} catch (HttpClientErrorException e) {
			System.out.println("(alta) -> Videojuego NO dado de alta, id: " + v);
		    System.out.println("(alta) -> Codigo de respuesta: " + e.getStatusCode());
		    return null;
		}
	}
	
	public boolean modificar(Videojuego v){
		try {
			restTemplate.put(URL + v.getId(), v, Videojuego.class);
			return true;
		} catch (HttpClientErrorException e) {
			System.out.println("(modificar) -> Videojuego NO modificado, id: " + v.getId());
		    System.out.println("(modificar) -> Codigo de respuesta: " + e.getStatusCode());
		    return false;
		}
	}
	
	public boolean borrar(int id){
		try {
			restTemplate.delete(URL + id);
			return true;
		} catch (HttpClientErrorException e) {
			System.out.println("(borrar) -> Videojuego NO borrado, id: " + id);
		    System.out.println("(borrar) -> Codigo de respuesta: " + e.getStatusCode());
		    return false;
		}
	}
	
	public List<Videojuego> listar(String nombre){
		String queryParams = "";		
		if(nombre != null) {
			queryParams += "?nombre=" + nombre;
		}
		
		try {
			ResponseEntity<Videojuego[]> response =
					  restTemplate.getForEntity(URL + queryParams,Videojuego[].class);
			Videojuego[] arrayPersonas = response.getBody();
			return Arrays.asList(arrayPersonas);
		} catch (HttpClientErrorException e) {
			System.out.println("(listar) -> Error al obtener la lista de Videojuegos");
		    System.out.println("(listar) -> Codigo de respuesta: " + e.getStatusCode());
		    return null;
		}
	}
	
}
