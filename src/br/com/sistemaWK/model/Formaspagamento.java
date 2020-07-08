package br.com.sistemaWK.model;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "formaspagamento")
public class Formaspagamento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idformaspagamento")
    private Integer idformaspagamento;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "valor")
	private float valor;
	@JoinColumn(name = "vendas_idvendas", referencedColumnName = "idvendas")
	@ManyToOne(optional = false)
	private Vendas vendas;
	
	
	
	@PostConstruct
	public void init() {
		
	}



	public Integer getIdformaspagamento() {
		return idformaspagamento;
	}



	public void setIdformaspagamento(Integer idformaspagamento) {
		this.idformaspagamento = idformaspagamento;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public float getValor() {
		return valor;
	}



	public void setValor(float valor) {
		this.valor = valor;
	}



	public Vendas getVendas() {
		return vendas;
	}



	public void setVendas(Vendas vendas) {
		this.vendas = vendas;
	}
	
	
	
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idformaspagamento != null ? idformaspagamento.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Formaspagamento)) {
			return false;
		}
		Formaspagamento other = (Formaspagamento) object;
		if ((this.idformaspagamento == null && other.idformaspagamento != null)
				|| (this.idformaspagamento != null && !this.idformaspagamento.equals(other.idformaspagamento))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemaWK.model.Formaspagamento[ idformaspagamento=" + idformaspagamento + " ]";
	}
	
	
	
	

}
