package br.una.veiculos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.una.veiculos.model.Veiculo;
import br.una.veiculos.repository.VeiculoRepository;

@RestController
@RequestMapping( path = "/veiculos")
public class VeiculosController {

	@Autowired
	private VeiculoRepository veiculosRepository;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listar() {
		List<Veiculo> automotor = veiculosRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(automotor);
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Veiculo veiculo) {
		Veiculo automotor = veiculosRepository.save(veiculo);
		return ResponseEntity.status(HttpStatus.OK).body(automotor);
		
	}
	
	
	@GetMapping(path = "/remover/{id}")
	public void remover(@PathVariable("id") Long id) {
		veiculosRepository.deleteById(id);
	}
	
	
}
