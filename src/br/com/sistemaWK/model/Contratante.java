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
	@Column(name = "tipopessoa")
	private String tipopessoa;
	@Column(name = "nomefantasia")
	private String nomefantasia;
	@Column(name = "razaosocial")
	private String razaosocial;
	@Column(name = "endereco")
	private String endereco;
	
	
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
	
	
	
	
	public String getTipopessoa() {
		return tipopessoa;
	}


	public void setTipopessoa(String tipopessoa) {
		this.tipopessoa = tipopessoa;
	}


	public String getNomefantasia() {
		return nomefantasia;
	}


	public void setNomefantasia(String nomefantasia) {
		this.nomefantasia = nomefantasia;
	}


	public String getRazaosocial() {
		return razaosocial;
	}


	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
