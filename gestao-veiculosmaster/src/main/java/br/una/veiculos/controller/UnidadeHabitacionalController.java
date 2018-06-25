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

import br.una.veiculos.model.UnidadeHabitacional;
import br.una.veiculos.repository.UnidadeHabitacionalRepository;

@RestController
@RequestMapping(path = "/residencias")
public class UnidadeHabitacionalController {

	@Autowired
	private UnidadeHabitacionalRepository residenciasRepository;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listar() {
		List<UnidadeHabitacional> residenciais = residenciasRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(residenciais);
		
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody UnidadeHabitacional residencia) {
		UnidadeHabitacional residenciais = residenciasRepository.save(residencia);
		return ResponseEntity.status(HttpStatus.OK).body(residenciais);
		
	}
	
		
	@DeleteMapping(path = "/remover/{id}")
	public void remover(@PathVariable("id") Long id) {
		residenciasRepository.deleteById(id);
	}
	
	
}
