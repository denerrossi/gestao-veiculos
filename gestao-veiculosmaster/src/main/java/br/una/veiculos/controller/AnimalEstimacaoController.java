package br.una.veiculos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.una.veiculos.model.AnimalEstimacao;
import br.una.veiculos.repository.AnimalEstimacaoRepository;


@RestController
@RequestMapping(path = "/animais")
public class AnimalEstimacaoController {

	@Autowired
	private AnimalEstimacaoRepository animaisRepository;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listar() {
		List<AnimalEstimacao> animalEstimacao = animaisRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(animalEstimacao);
	}
	
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody AnimalEstimacao animal) {
		AnimalEstimacao animalEstimacao = animaisRepository.save(animal);
		return ResponseEntity.status(HttpStatus.OK).body(animalEstimacao);
	}
	
	@DeleteMapping(path = "/remover/{id}")
	public void remover(@PathVariable("id") Long id) {
	    animaisRepository.deleteById(id);
		
	}
	
	/*
	@GetMapping(path = "/editar/{id}")
	public ResponseEntity<?>update(@PathVariable("id") AnimalEstimacao animal) {
		AnimalEstimacao animais = animaisRepository.findAllById(id);
		return ResponseEntity.status(HttpStatus.OK).body(animais);
				
	}*/
	
}
