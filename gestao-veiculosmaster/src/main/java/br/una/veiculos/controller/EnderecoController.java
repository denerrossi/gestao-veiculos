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


import br.una.veiculos.model.Endereco;
import br.una.veiculos.repository.EnderecoRepository;

@RestController
@RequestMapping(path = "/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listar() {
		List<Endereco> enderecos = enderecoRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(enderecos);
	}
		
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Endereco endereco) {
		Endereco enderecos= enderecoRepository.save(endereco);
		return ResponseEntity.status(HttpStatus.OK).body(enderecos);
	}
		
	@DeleteMapping(path = "/remover/{id}")
	public void remover(@PathVariable("id") Long id) {
		enderecoRepository.deleteById(id);
	}
	
	
}
