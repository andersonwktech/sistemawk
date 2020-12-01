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
@Table(name = "contaspagar")
public class Contaspagar implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontaspagar")
    private Integer idcontaspagar;
	@Column(name = "valorparcela")
	private float valorparcela;
	@Column(name = "formapagamento")
	private String formapagamento;
	@Column(name = "nparcela")
	private int nparcela;
	@Column(name = "status")
	private String status;
	@Column(name = "corstatus")
	private String corstatus;
	@Column(name = "pago")
	private boolean pago;
	@Temporal(TemporalType.DATE)
	@Column(name = "datacompetencia")
	private Date datacompetencia;
	@Temporal(TemporalType.DATE)
	@Column(name = "datapagamento")
	private Date datapagamento;
	@Temporal(TemporalType.DATE)
	@Column(name = "datacompra")
	private Date datacompra;
	@Column(name = "taxas")
	private float taxas;
	@Column(name = "juros")
	private float juros;
	@Column(name = "observacao")
	private String observacao;
	@Column(name = "quantidade")
	private int quantidade;
	@JoinColumn(name = "categoria_idcategoria", referencedColumnName = "idcategoria")
	@ManyToOne(optional = false)
	private Categoria categoria;
	@JoinColumn(name = "fornecedor_idfornecedor", referencedColumnName = "idfornecedor")
	@ManyToOne(optional = false)
	private Fornecedor fornecedor;
	@JoinColumn(name = "banco_idbanco", referencedColumnName = "idbanco")
	@ManyToOne(optional = false)
	private Banco banco;

	
	
	public Contaspagar() {
	
	}



	public Integer getIdcontaspagar() {
		return idcontaspagar;
	}



	public void setIdcontaspagar(Integer idcontaspagar) {
		this.idcontaspagar = idcontaspagar;
	}



	public float getValorparcela() {
		return valorparcela;
	}



	public void setValorparcela(float valorparcela) {
		this.valorparcela = valorparcela;
	}



	public String getFormapagamento() {
		return formapagamento;
	}



	public void setFormapagamento(String formapagamento) {
		this.formapagamento = formapagamento;
	}



	public int getNparcela() {
		return nparcela;
	}



	public void setNparcela(int nparcela) {
		this.nparcela = nparcela;
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



	public Date getDatacompetencia() {
		return datacompetencia;
	}



	public void setDatacompetencia(Date datacompetencia) {
		this.datacompetencia = datacompetencia;
	}



	public Date getDatapagamento() {
		return datapagamento;
	}



	public void setDatapagamento(Date datapagamento) {
		this.datapagamento = datapagamento;
	}



	public Date getDatacompra() {
		return datacompra;
	}



	public void setDatacompra(Date datacompra) {
		this.datacompra = datacompra;
	}



	public float getTaxas() {
		return taxas;
	}



	public void setTaxas(float taxas) {
		this.taxas = taxas;
	}



	public float getJuros() {
		return juros;
	}



	public void setJuros(float juros) {
		this.juros = juros;
	}



	public String getObservacao() {
		return observacao;
	}



	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}



	public int getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}



	public Categoria getCategoria() {
		return categoria;
	}



	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	public Fornecedor getFornecedor() {
		return fornecedor;
	}



	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}



	public Banco getBanco() {
		return banco;
	}



	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	
	
	
	
	
	
	
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idcontaspagar != null ? idcontaspagar.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Contaspagar)) {
			return false;
		}
		Contaspagar other = (Contaspagar) object;
		if ((this.idcontaspagar == null && other.idcontaspagar != null)
				|| (this.idcontaspagar != null && !this.idcontaspagar.equals(other.idcontaspagar))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemaWK.model.Contaspagar[ idcontaspagar=" + idcontaspagar + " ]";
	}
}
