package br.una.veiculos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.una.veiculos.model.Morador;
import br.una.veiculos.repository.MoradorRepository;
import br.una.veiculos.service.exceptions.ObjectNotFoundException;

@Service
public class MoradorService {

	@Autowired
	private MoradorRepository repositorio;
	
	public Morador buscaPorId(Long id) {
		Optional<Morador> morador = repositorio.findById(id); 
		return morador.orElseThrow(() -> new ObjectNotFoundException("Morador com ID: " + id + " não encontrado"));
	}
	
	
}



		