package com.challengeLiterAlura.LiterAlura;

import com.challengeLiterAlura.LiterAlura.principal.Principal;
import com.challengeLiterAlura.LiterAlura.repository.AutorRepository;
import com.challengeLiterAlura.LiterAlura.repository.LibroRepository;
import com.challengeLiterAlura.LiterAlura.service.AutorService;
import com.challengeLiterAlura.LiterAlura.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	@Autowired
	private LibroService libroService;

	@Autowired
	private AutorService autorService;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(libroService,autorService);
		principal.muestraElMenu();
	}
}
