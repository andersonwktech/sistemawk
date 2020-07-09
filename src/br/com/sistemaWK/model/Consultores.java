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
@Table(name = "consultores")
public class Consultores implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconsultores")
    private Integer idconsultores;
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
	
	
	
	public Consultores() {
	
	}



	



	public Integer getIdconsultores() {
		return idconsultores;
	}







	public void setIdconsultores(Integer idconsultores) {
		this.idconsultores = idconsultores;
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
		hash += (idconsultores != null ? idconsultores.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Consultores)) {
			return false;
		}
		Consultores other = (Consultores) object;
		if ((this.idconsultores == null && other.idconsultores != null)
				|| (this.idconsultores != null && !this.idconsultores.equals(other.idconsultores))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemaWK.model.Consultores[ idconsultores=" + idconsultores + " ]";
	}
	
	
	
	
	

}
