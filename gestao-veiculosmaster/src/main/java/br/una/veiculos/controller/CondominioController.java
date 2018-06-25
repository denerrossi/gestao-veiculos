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

import br.una.veiculos.model.Condominio;
import br.una.veiculos.repository.CondominioRepository;


@RestController
@RequestMapping("/condominios")
public class CondominioController {

	@Autowired
	private CondominioRepository condominiosRepository;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listar() {
		List<Condominio> condominios = condominiosRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(condominios);
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Condominio condominio) {
		Condominio condominios = condominiosRepository.save(condominio);
		return ResponseEntity.status(HttpStatus.OK).body(condominios);
	}
	
		
	@DeleteMapping(path = "/remover/{id}")
	public void remover(@PathVariable("id") Long id) {
		condominiosRepository.deleteById(id);
	}
	
	
}
