package io.github.lucasbarroscode.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.lucasbarroscode.clientes.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
