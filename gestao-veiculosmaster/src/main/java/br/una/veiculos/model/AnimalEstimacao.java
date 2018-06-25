package br.una.veiculos.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AnimalEstimacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String raca;
	private String porte;
	private Date dataUltimaVacina;
	
	@ManyToOne
	@JoinColumn(name="morador_id")
	private Morador morador;
	
	public AnimalEstimacao() {


	}


	public AnimalEstimacao(Long id, String nome, String raca, String porte, Date dataUltimaVacina, Morador morador) {
		super();
		this.id = id;
		this.nome = nome;
		this.raca = raca;
		this.porte = porte;
		this.dataUltimaVacina = dataUltimaVacina;
		this.morador = morador;
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


	public String getRaca() {
		return raca;
	}


	public void setRaca(String raca) {
		this.raca = raca;
	}


	public String getPorte() {
		return porte;
	}


	public void setPorte(String porte) {
		this.porte = porte;
	}


	public Date getDataUltimaVacina() {
		return dataUltimaVacina;
	}


	public void setDataUltimaVacina(Date dataUltimaVacina) {
		this.dataUltimaVacina = dataUltimaVacina;
	}
	


	public Morador getMorador() {
		return morador;
	}


	public void setMorador(Morador morador) {
		this.morador = morador;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnimalEstimacao other = (AnimalEstimacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
		
	

}
