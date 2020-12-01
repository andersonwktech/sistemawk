package br.com.sistemaWK.model;

import java.io.Serializable;

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
@Table(name = "vendascliente")
public class Vendascliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvendascliente")
    private Integer idvendascliente;
	@JoinColumn(name = "vendas_idvendas", referencedColumnName = "idvendas")
	@ManyToOne(optional = false)
	private Vendas vendas;
	@JoinColumn(name = "cliente_idcliente", referencedColumnName = "idcliente")
	@ManyToOne(optional = false)
	private Cliente cliente;
	
	
	
	public Vendascliente() {
	
	}



	public Integer getIdvendascliente() {
		return idvendascliente;
	}



	public void setIdvendascliente(Integer idvendascliente) {
		this.idvendascliente = idvendascliente;
	}



	public Vendas getVendas() {
		return vendas;
	}



	public void setVendas(Vendas vendas) {
		this.vendas = vendas;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idvendascliente != null ? idvendascliente.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Vendascliente)) {
			return false;
		}
		Vendascliente other = (Vendascliente) object;
		if ((this.idvendascliente == null && other.idvendascliente != null)
				|| (this.idvendascliente != null && !this.idvendascliente.equals(other.idvendascliente))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemaWK.model.Vendascliente[ idvendascliente=" + idvendascliente + " ]";
	}

}
