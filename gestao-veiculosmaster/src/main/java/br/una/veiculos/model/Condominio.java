package br.una.veiculos.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Condominio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private boolean possuiBloco;
	
	@ManyToOne
	@JoinColumn(name="endereco_id")
	private Endereco endereco;
	
	//*@OneToMany(mappedBy="condominio")
	//*private List<Usuario> usuarios = new ArrayList<Usuario>();*//

	public Condominio() {

	}

	public Condominio(Long id, String nome, boolean possuiBloco, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.possuiBloco = possuiBloco;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isPossuiBloco() {
		return possuiBloco;
	}

	public void setPossuiBloco(boolean possuiBloco) {
		this.possuiBloco = possuiBloco;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

	

}
