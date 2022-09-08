package io.github.lucasbarroscode.clientes.rest;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.lucasbarroscode.clientes.exception.UsuarioCadastradoException;
import io.github.lucasbarroscode.clientes.model.entity.Usuario;
import io.github.lucasbarroscode.clientes.model.repository.UsuarioRepository;
import io.github.lucasbarroscode.clientes.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
	
	private final UsuarioService service;
	//private final UsuarioRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody @Valid Usuario usuario) {
		
		//repository.save(usuario);		
		try {
			
			service.salvar(usuario);	
		}catch (UsuarioCadastradoException e) {
			//verifica se tem erro na API
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
	}

}
