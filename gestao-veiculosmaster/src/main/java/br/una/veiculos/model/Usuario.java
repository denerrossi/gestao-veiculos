package br.una.veiculos.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name = "TIPO_USUARIO", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String senha;
	private boolean eSindico;
	private boolean eRoot;
	
	
	@ManyToOne
	@JoinColumn(name="condominio_id")
	private Condominio condominio;
	
	public Usuario() {
		
	}
	
	public Usuario(Long id, String login, String senha, boolean eSindico, boolean eRoot, Condominio condominio) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.eSindico = eSindico;
		this.eRoot = eRoot;
		this.condominio = condominio;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean iseSindico() {
		return eSindico;
	}
	public void seteSindico(boolean eSindico) {
		this.eSindico = eSindico;
	}
	public boolean iseRoot() {
		return eRoot;
	}
	public void seteRoot(boolean eRoot) {
		this.eRoot = eRoot;
	}
	

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
