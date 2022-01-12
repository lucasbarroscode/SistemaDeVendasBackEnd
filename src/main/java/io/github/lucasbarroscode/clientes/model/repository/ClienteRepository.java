package io.github.lucasbarroscode.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.lucasbarroscode.clientes.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
