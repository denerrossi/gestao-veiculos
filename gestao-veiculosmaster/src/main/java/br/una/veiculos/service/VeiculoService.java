package br.una.veiculos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.una.veiculos.model.Veiculo;
import br.una.veiculos.repository.VeiculoRepository;
import br.una.veiculos.service.exceptions.ObjectNotFoundException;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository repositorio;
	
	public Veiculo buscarPorId(Long id) {
		Optional<Veiculo> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Veículo com ID: " + id + " não encontrado")); 
		
	}
}
