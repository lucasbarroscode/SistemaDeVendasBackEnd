package io.github.lucasbarroscode.clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.lucasbarroscode.clientes.model.entity.Cliente;
import io.github.lucasbarroscode.clientes.model.repository.ClienteRepository;

@SpringBootApplication
public class ClientesApplication {
	
	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository repository) {
		return 	args -> {
			Cliente cliente = Cliente.builder().cpf("22683731779").nome("Fulano").build();
			repository.save(cliente);
			
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);
	}

}
