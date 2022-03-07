package io.github.lucasbarroscode.clientes.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.lucasbarroscode.clientes.model.entity.Cliente;
import io.github.lucasbarroscode.clientes.model.entity.ServicoPrestado;
import io.github.lucasbarroscode.clientes.model.repository.ClienteRepository;
import io.github.lucasbarroscode.clientes.model.repository.ServicoPrestadoRepository;
import io.github.lucasbarroscode.clientes.rest.dto.ServicoPrestadoDTO;
import io.github.lucasbarroscode.clientes.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor
public class ServicoPrestadoController {
	
	private final ClienteRepository clienteRepository;
	private final ServicoPrestadoRepository repository;
	private final BigDecimalConverter bigDecimalConverter;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto){
		
		LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Integer idCliente = dto.getIdCliente();
		
		//Optional é uma interface do Java8 que diz o seguinte ele pode ter o cliente dentro ou pode não ter
		Cliente cliente = clienteRepository
				.findById(idCliente)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente Inexistente"));
		
		ServicoPrestado servicoPrestado = new ServicoPrestado();
		servicoPrestado.setDescricao(dto.getDescricao());
		servicoPrestado.setDate(data);
		servicoPrestado.setCliente(cliente);
		servicoPrestado.setValor(bigDecimalConverter.converter(dto.getPreco()));
		
		return repository.save(servicoPrestado);
		
	}
		
	}
	


