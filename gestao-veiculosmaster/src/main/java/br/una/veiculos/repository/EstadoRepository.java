package br.una.veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.una.veiculos.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

	
}
