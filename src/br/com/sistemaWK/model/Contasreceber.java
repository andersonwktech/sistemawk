package br.com.sistemaWK.model;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "contasreceber")
public class Contasreceber implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontasreceber")
    private Integer idcontasreceber;
	@Column(name = "valoraparcela")
	private float valorparcela;
	@Column(name = "datavencimento")
	@Temporal(TemporalType.DATE)
	private Date datavencimento;
	@Column(name = "formapagamento")
	private String formapagamento;
	@Column(name = "comissao")
	private float comissao;
	@Column(name = "parceiro")
	private float parceiro;
	@Column(name = "vendedor")
	private float vendedor;
	
	
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idcontasreceber != null ? idcontasreceber.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Contasreceber)) {
			return false;
		}
		Contasreceber other = (Contasreceber) object;
		if ((this.idcontasreceber == null && other.idcontasreceber != null)
				|| (this.idcontasreceber != null && !this.idcontasreceber.equals(other.idcontasreceber))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemaWK.model.Contasreceber[ idcontasreceber=" + idcontasreceber + " ]";
	}
	
	
	
	

}
