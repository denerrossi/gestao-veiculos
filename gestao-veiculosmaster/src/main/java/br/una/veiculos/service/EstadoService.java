package br.una.veiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.una.veiculos.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repositorio;
	
	
}
