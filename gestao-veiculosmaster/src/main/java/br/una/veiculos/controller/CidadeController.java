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

import br.una.veiculos.model.Cidade;
import br.una.veiculos.repository.CidadeRepository;

@RestController
@RequestMapping(path = "/cidade")
public class CidadeController {

	@Autowired
	private CidadeRepository cityRepository;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)/*Tenho que colocar esta anotação nas demais classes?*/
	public ResponseEntity<?> listar() {
		List<Cidade> cidades = cityRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(cidades);
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Cidade nome) {
		Cidade cidades = cityRepository.save(nome);
		return ResponseEntity.status(HttpStatus.OK).body(cidades);
	}
	
		
	@DeleteMapping(path = "/remover/{id}")
	public void remover(@PathVariable("id") Long id) {
		cityRepository.deleteById(id);
	}
	
	
}
