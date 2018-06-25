package br.una.veiculos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class UnidadeHabitacional{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String identificacao;
	private String bloco;
	private boolean interfoneOk;
	
	/*@ManyToMany
	@JoinColumn(name="morador_id")
	private Morador morador;*/
	
	public UnidadeHabitacional() {
		
	}

	

	public UnidadeHabitacional(Long id, String identificacao, String bloco, boolean interfoneOk) {
		super();
		this.id = id;
		this.identificacao = identificacao;
		this.bloco = bloco;
		this.interfoneOk = interfoneOk;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public boolean isInterfoneOk() {
		return interfoneOk;
	}

	public void setInterfoneOk(boolean interfoneOk) {
		this.interfoneOk = interfoneOk;
	}
	
	
	
}
