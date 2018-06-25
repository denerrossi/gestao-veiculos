package br.una.veiculos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public enum PorteAnimal {

	PEQUENO(1, "Pequeno"),
	MEDIO(2, "Médio"),
	GRANDE(3, "Grande");
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	
	public Integer getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	
	private PorteAnimal(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public static PorteAnimal getEnum(Integer id) {
		if(id == null) {
			return null;
		}
		for (PorteAnimal porte : PorteAnimal.values()) {
			if (id.equals(porte.getId())) {
				return porte;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + id);
	}
	
}
