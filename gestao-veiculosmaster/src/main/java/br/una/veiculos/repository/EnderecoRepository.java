package br.una.veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.una.veiculos.model.Endereco;
import br.una.veiculos.model.Usuario;

public interface EnderecoRepository extends JpaRepository <Endereco, Long> {

	void save(Usuario usuario);

}


