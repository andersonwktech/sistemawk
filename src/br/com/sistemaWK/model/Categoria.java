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
@Table(name = "categoria")
public class Categoria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcategoria")
    private Integer idcategoria;
	@Column(name = "descricao")
	private String descricao;
	
	
	public Categoria() {
	
	}


	public Integer getIdcategoria() {
		return idcategoria;
	}


	public void setIdcategoria(Integer idcategoria) {
		this.idcategoria = idcategoria;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idcategoria != null ? idcategoria.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Categoria)) {
			return false;
		}
		Categoria other = (Categoria) object;
		if ((this.idcategoria == null && other.idcategoria != null)
				|| (this.idcategoria != null && !this.idcategoria.equals(other.idcategoria))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemaWK.model.Categoria[ idcategoria=" + idcategoria + " ]";
	}
	

}
