package io.github.lucasbarroscode.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.lucasbarroscode.clientes.model.entity.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

}
