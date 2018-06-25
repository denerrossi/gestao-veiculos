package br.una.veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.una.veiculos.model.Condominio;

@Repository
public interface CondominioRepository extends JpaRepository<Condominio, Long>{

}


