package br.una.veiculos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.una.veiculos.model.Cidade;
import br.una.veiculos.repository.CidadeRepository;
import br.una.veiculos.service.exceptions.ObjectNotFoundException;

@Service
public class AnimalEstimacaoService {

	@Autowired
	private CidadeRepository repositorio;
	
	public Cidade buscaPorId(Long id) {
		Optional<Cidade> cidade = repositorio.findById(id); 
		return cidade.orElseThrow(() -> new ObjectNotFoundException("Cidade com ID: " + id + " não encontrado"));
	}
	
	
}



		