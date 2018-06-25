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

import br.una.veiculos.model.Estado;
import br.una.veiculos.repository.EstadoRepository;


@RestController
@RequestMapping(path = "/estados")
public class EstadosController {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listar() {
		List<Estado> unidadeFederal = estadoRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(unidadeFederal);
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Estado uf) {
		Estado unidadeFederal = estadoRepository.save(uf);
		return ResponseEntity.status(HttpStatus.OK).body(unidadeFederal);
	}
	
	@GetMapping(path = "/remover/{id}")
	public void remover(@PathVariable("id") Long id) {
		estadoRepository.deleteById(id);
	}
	
	
}
