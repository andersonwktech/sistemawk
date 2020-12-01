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
@Table(name = "fornecedor")
public class Fornecedor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfornecedor")
    private Integer idfornecedor;
	@Column(name = "descricao")
	private String descricao;
	
	
	public Fornecedor() {
	
	}


	public Integer getIdfornecedor() {
		return idfornecedor;
	}


	public void setIdfornecedor(Integer idfornecedor) {
		this.idfornecedor = idfornecedor;
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
		hash += (idfornecedor != null ? idfornecedor.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Fornecedor)) {
			return false;
		}
		Fornecedor other = (Fornecedor) object;
		if ((this.idfornecedor == null && other.idfornecedor != null)
				|| (this.idfornecedor != null && !this.idfornecedor.equals(other.idfornecedor))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemaWK.model.Fornecedor[ idfornecedor=" + idfornecedor + " ]";
	}
	
	

}
