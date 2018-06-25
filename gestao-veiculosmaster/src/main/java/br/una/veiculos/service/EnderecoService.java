package br.una.veiculos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.una.veiculos.model.Endereco;
import br.una.veiculos.repository.EnderecoRepository;
import br.una.veiculos.service.exceptions.ObjectNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repositorio;
	
	public Endereco buscaPorId(Long id) {
		Optional<Endereco> endereco = repositorio.findById(id); 
		return endereco.orElseThrow(() -> new ObjectNotFoundException("Endereço com ID: " + id + " não encontrado"));
	}
	
	
}



		