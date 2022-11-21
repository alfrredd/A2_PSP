package es.pspA2Rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class A2VideojuegosRestApplication {

	public static void main(String[] args) {
		System.out.println("Cargando Servicio Rest...");
		SpringApplication.run(A2VideojuegosRestApplication.class, args);
		System.out.println("Servicio Rest Cargado Correctamente");
	}

}
