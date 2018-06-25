package br.una.veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.una.veiculos.model.AnimalEstimacao;


@Repository
public interface AnimalEstimacaoRepository extends JpaRepository<AnimalEstimacao, Long> {

	
}