package br.com.sistemaWK.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professores")
public class Professores implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprofessores")
    private Integer idprofessores;
	@Column(name = "nome")
	private String nome;
	@Column(name = "email")
	private String email;
	@Column(name = "telefone")
	private String telefone;
	@Column(name = "ativo")
	private boolean ativo;
	@Column(name = "descricaoativo")
	private String descricaoativo;
	
	
	
	public Professores() {
	
	}



	public Integer getIdprofessores() {
		return idprofessores;
	}



	public void setIdprofessores(Integer idprofessores) {
		this.idprofessores = idprofessores;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public boolean isAtivo() {
		return ativo;
	}



	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
	
	
	public String getDescricaoativo() {
		return descricaoativo;
	}



	public void setDescricaoativo(String descricaoativo) {
		this.descricaoativo = descricaoativo;
	}



	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idprofessores != null ? idprofessores.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Professores)) {
			return false;
		}
		Professores other = (Professores) object;
		if ((this.idprofessores == null && other.idprofessores != null)
				|| (this.idprofessores != null && !this.idprofessores.equals(other.idprofessores))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemaWK.model.Professores[ idprofessores=" + idprofessores + " ]";
	}
	
	
	
	
	

}
