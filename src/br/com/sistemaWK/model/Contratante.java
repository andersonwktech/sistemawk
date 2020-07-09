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
@Table(name = "contratante")
public class Contratante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontratante")
    private Integer idcontratante;
	@Column(name = "cpfcnpj")
	private String cpfcnpj;
	
	
	public Contratante() {
	
	}


	public Integer getIdcontratante() {
		return idcontratante;
	}


	public void setIdcontratante(Integer idcontratante) {
		this.idcontratante = idcontratante;
	}


	public String getCpfcnpj() {
		return cpfcnpj;
	}


	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}
	
	
	
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idcontratante != null ? idcontratante.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Cliente)) {
			return false;
		}
		Contratante other = (Contratante) object;
		if ((this.idcontratante == null && other.idcontratante != null)
				|| (this.idcontratante != null && !this.idcontratante.equals(other.idcontratante))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemaWK.model.Contratante[ idcontratante=" + idcontratante + " ]";
	}
	
	
	

}
