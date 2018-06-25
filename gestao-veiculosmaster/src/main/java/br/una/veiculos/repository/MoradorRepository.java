package br.una.veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.una.veiculos.model.Morador;

@Repository
public interface MoradorRepository extends JpaRepository<Morador, Long> {

	void save(MoradorRepository moradores);

	void deleteById(Long id);

}
