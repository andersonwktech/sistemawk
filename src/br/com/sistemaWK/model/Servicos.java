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
@Table(name = "servicos")
public class Servicos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idservicos")
    private Integer idservicos;
	@Column(name = "nomeservicos")
	private String nomeservicos;
	@Column(name = "cargahoraria")
	private String cargahoraria;
	@Column(name = "valor")
	private float valor;
	@Column(name = "ativo")
	private boolean ativo;
	@Column(name = "descricaoativo")
	private String descricaoativo;
	
	
	
	public Servicos() {
	
	}



	



	public Integer getIdservicos() {
		return idservicos;
	}







	public void setIdservicos(Integer idservicos) {
		this.idservicos = idservicos;
	}







	public String getNomeservicos() {
		return nomeservicos;
	}







	public void setNomeservicos(String nomeservicos) {
		this.nomeservicos = nomeservicos;
	}







	public String getCargahoraria() {
		return cargahoraria;
	}



	public void setCargahoraria(String cargahoraria) {
		this.cargahoraria = cargahoraria;
	}



	public float getValor() {
		return valor;
	}



	public void setValor(float valor) {
		this.valor = valor;
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
		hash += (idservicos != null ? idservicos.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Servicos)) {
			return false;
		}
		Servicos other = (Servicos) object;
		if ((this.idservicos == null && other.idservicos != null)
				|| (this.idservicos != null && !this.idservicos.equals(other.idservicos))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemaWK.model.Servicos[ idservicos=" + idservicos + " ]";
	}
	
	
	
	
	
	

}
