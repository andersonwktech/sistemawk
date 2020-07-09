package br.com.sistemaWK.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "vendas")
public class Vendas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvendas")
    private Integer idvendas;
	@Column(name = "datavenda")
	@Temporal(TemporalType.DATE)
	private Date datavenda;
	@Column(name = "status")
	private String status;
	@Column(name = "observacao")
	private String observacao;
	@Column(name = "valorvenda")
	private float valorvenda;
	@Column(name = "corstatus")
	private String corstatus;
	@JoinColumn(name = "contratante_idcontratante", referencedColumnName = "idcontratante")
	@ManyToOne(optional = false)
	private Contratante contratante;
	@JoinColumn(name = "servicos_idservicos", referencedColumnName = "idservicos")
	@ManyToOne(optional = false)
	private Servicos servicos;
	
	
	
	public Vendas() {
	
	}



	public Integer getIdvendas() {
		return idvendas;
	}



	public void setIdvendas(Integer idvendas) {
		this.idvendas = idvendas;
	}



	public Date getDatavenda() {
		return datavenda;
	}



	public void setDatavenda(Date datavenda) {
		this.datavenda = datavenda;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getObservacao() {
		return observacao;
	}



	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}



	public float getValorvenda() {
		return valorvenda;
	}



	public void setValorvenda(float valorvenda) {
		this.valorvenda = valorvenda;
	}


	

	
	public Contratante getContratante() {
		return contratante;
	}



	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}



	public Servicos getServicos() {
		return servicos;
	}



	public void setServicos(Servicos servicos) {
		this.servicos = servicos;
	}



	public String getCorstatus() {
		return corstatus;
	}



	public void setCorstatus(String corstatus) {
		this.corstatus = corstatus;
	}



	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idvendas != null ? idvendas.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Vendas)) {
			return false;
		}
		Vendas other = (Vendas) object;
		if ((this.idvendas == null && other.idvendas != null)
				|| (this.idvendas != null && !this.idvendas.equals(other.idvendas))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemaWK.model.Vendas[ idvendas=" + idvendas + " ]";
	}
	
	
	
	
	
	
	
	

}
