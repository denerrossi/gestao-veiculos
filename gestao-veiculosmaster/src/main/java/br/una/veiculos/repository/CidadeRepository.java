package br.una.veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.una.veiculos.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	
}
