package br.una.veiculos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.una.veiculos.model.Cidade;
import br.una.veiculos.repository.CidadeRepository;
import br.una.veiculos.service.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repositorio;
	
	public Cidade buscaPorId(Long id) {
		Optional<Cidade> cidade = repositorio.findById(id); 
		return cidade.orElseThrow(() -> new ObjectNotFoundException("Cidade com ID: " + id + " não encontrado"));
	}
	
	
}



		