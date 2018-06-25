package br.una.veiculos.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.una.veiculos.model.Cidade;
import br.una.veiculos.service.CidadeService;

@RestController
@RequestMapping(value="/cidades_service")
public class CidadeResource {
	
	@Autowired
	private CidadeService cidade_service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Cidade cidade = cidade_service.buscaPorId(id);
		return ResponseEntity.ok().body(cidade);
		
	}
}
