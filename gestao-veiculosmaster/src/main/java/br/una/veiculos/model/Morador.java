package br.una.veiculos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("1")
public class Morador extends Usuario  {

	private static final long serialVersionUID = 1L;
	
	
	private String nome;
	private String cpf;
	private Date dataNascimento;
	@ElementCollection
	@CollectionTable(name="TELEFONE")
	private List<String> telefones = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_morador_unidade", joinColumns = @JoinColumn(name = "morador_id", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "unidade_id", referencedColumnName = "id"))
	private List<UnidadeHabitacional> unidades;
	
	
	public Morador() {
		
	}
	
	public Morador(Long id, String login, String senha, boolean eSindico, boolean eRoot, String nome, String cpf,
			Date dataNascimento, List<String> telefones, Condominio condominio, List< UnidadeHabitacional> unidades) {
		super(id, login, senha, eSindico, eRoot, condominio);
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefones = telefones;
		this.unidades = unidades;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public List<String> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}

	public List<UnidadeHabitacional> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<UnidadeHabitacional> unidades) {
		this.unidades = unidades;
	}
	
	
}
