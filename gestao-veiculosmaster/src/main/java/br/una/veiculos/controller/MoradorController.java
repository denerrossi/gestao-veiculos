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

import br.una.veiculos.model.Morador;
import br.una.veiculos.repository.MoradorRepository;

@RestController
@RequestMapping(path = "/moradores")
public class MoradorController {

	@Autowired
	private MoradorRepository moradoresRepository;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listar() {
		List<Morador> moradores = moradoresRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(moradores);
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Morador morador) {
		Morador moradores = moradoresRepository.save(morador);
		return ResponseEntity.status(HttpStatus.OK).body(moradores);
		
	}
	
	
	@GetMapping(path = "/remover/{id}")
	public void remover(@PathVariable("id") Long id) {
		moradoresRepository.deleteById(id);
	}
	
	
}
