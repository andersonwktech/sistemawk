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
@Table(name = "tiposervicos")
public class Tiposervicos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtiposervicos")
    private Integer idtiposervicos;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "dadoscliente")
	private boolean dadoscliente;
	
	
	public Tiposervicos() {
	
	}


	public Integer getIdtiposervicos() {
		return idtiposervicos;
	}


	public void setIdtiposervicos(Integer idtiposervicos) {
		this.idtiposervicos = idtiposervicos;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	public boolean isDadoscliente() {
		return dadoscliente;
	}


	public void setDadoscliente(boolean dadoscliente) {
		this.dadoscliente = dadoscliente;
	}


	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idtiposervicos != null ? idtiposervicos.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Tiposervicos)) {
			return false;
		}
		Tiposervicos other = (Tiposervicos) object;
		if ((this.idtiposervicos == null && other.idtiposervicos != null)
				|| (this.idtiposervicos != null && !this.idtiposervicos.equals(other.idtiposervicos))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemaWK.model.Tiposervicos[ idtiposervicos=" + idtiposervicos + " ]";
	}
	
	
	
	
	

}
