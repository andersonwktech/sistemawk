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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	@Column(name = "valorparcela")
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
	@Column(name = "nparcela")
	private int nparcela;
	@Column(name = "numeroparcela")
	private int numeroparcela;
	@Column(name = "status")
	private String status;
	@Column(name = "corstatus")
	private String corstatus;
	@Column(name = "pago")
	private boolean pago;
	@JoinColumn(name = "vendas_idvendas", referencedColumnName = "idvendas")
	@ManyToOne(optional = false)
	private Vendas vendas;
	
	
	public Contasreceber() {
	
	}
	
	
	
	
	
	
	public Integer getIdcontasreceber() {
		return idcontasreceber;
	}






	public void setIdcontasreceber(Integer idcontasreceber) {
		this.idcontasreceber = idcontasreceber;
	}






	public float getValorparcela() {
		return valorparcela;
	}






	public void setValorparcela(float valorparcela) {
		this.valorparcela = valorparcela;
	}






	public Date getDatavencimento() {
		return datavencimento;
	}






	public void setDatavencimento(Date datavencimento) {
		this.datavencimento = datavencimento;
	}






	public String getFormapagamento() {
		return formapagamento;
	}






	public void setFormapagamento(String formapagamento) {
		this.formapagamento = formapagamento;
	}






	public float getComissao() {
		return comissao;
	}






	public void setComissao(float comissao) {
		this.comissao = comissao;
	}






	public float getParceiro() {
		return parceiro;
	}






	public void setParceiro(float parceiro) {
		this.parceiro = parceiro;
	}






	public float getVendedor() {
		return vendedor;
	}






	public void setVendedor(float vendedor) {
		this.vendedor = vendedor;
	}






	public int getNparcela() {
		return nparcela;
	}






	public void setNparcela(int nparcela) {
		this.nparcela = nparcela;
	}






	public int getNumeroparcela() {
		return numeroparcela;
	}






	public void setNumeroparcela(int numeroparcela) {
		this.numeroparcela = numeroparcela;
	}






	public Vendas getVendas() {
		return vendas;
	}






	public void setVendas(Vendas vendas) {
		this.vendas = vendas;
	}






	public String getStatus() {
		return status;
	}






	public void setStatus(String status) {
		this.status = status;
	}






	public String getCorstatus() {
		return corstatus;
	}






	public void setCorstatus(String corstatus) {
		this.corstatus = corstatus;
	}






	public boolean isPago() {
		return pago;
	}






	public void setPago(boolean pago) {
		this.pago = pago;
	}






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
