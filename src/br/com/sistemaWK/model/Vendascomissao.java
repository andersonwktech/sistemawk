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
@Table(name = "vendascomissao")
public class Vendascomissao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvendascomissao")
    private Integer idvendascomissao;
	@Column(name = "parcela")
	private float parcela;
	@Column(name = "antcartao")
	private float antcartao;
	@Column(name = "emissaoboleto")
	private float emissaoboleto;
	@Column(name = "royalties")
	private float royalties;
	@Column(name = "imposto")
	private float imposto;
	@Column(name = "impressaopostagem")
	private float impressaopostagem;
	@Column(name = "liquido")
	private float liquido;
	@Column(name = "comissaowk")
	private float comissaowk;
	@Column(name = "parceiro")
	private float parceiro;
	@JoinColumn(name = "vendas_idvendas", referencedColumnName = "idvendas")
	@ManyToOne(optional = false)
	private Vendas vendas;
	
	
	
	public Vendascomissao() {
	
	}



	public Integer getIdvendascomissao() {
		return idvendascomissao;
	}



	public void setIdvendascomissao(Integer idvendascomissao) {
		this.idvendascomissao = idvendascomissao;
	}



	public float getParcela() {
		return parcela;
	}



	public void setParcela(float parcela) {
		this.parcela = parcela;
	}



	public float getAntcartao() {
		return antcartao;
	}



	public void setAntcartao(float antcartao) {
		this.antcartao = antcartao;
	}



	public float getEmissaoboleto() {
		return emissaoboleto;
	}



	public void setEmissaoboleto(float emissaoboleto) {
		this.emissaoboleto = emissaoboleto;
	}



	public float getRoyalties() {
		return royalties;
	}



	public void setRoyalties(float royalties) {
		this.royalties = royalties;
	}



	public float getImposto() {
		return imposto;
	}



	public void setImposto(float imposto) {
		this.imposto = imposto;
	}



	public float getImpressaopostagem() {
		return impressaopostagem;
	}



	public void setImpressaopostagem(float impressaopostagem) {
		this.impressaopostagem = impressaopostagem;
	}



	public float getLiquido() {
		return liquido;
	}



	public void setLiquido(float liquido) {
		this.liquido = liquido;
	}



	public float getComissaowk() {
		return comissaowk;
	}



	public void setComissaowk(float comissaowk) {
		this.comissaowk = comissaowk;
	}



	public float getParceiro() {
		return parceiro;
	}



	public void setParceiro(float parceiro) {
		this.parceiro = parceiro;
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
		hash += (idvendascomissao != null ? idvendascomissao.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Vendascomissao)) {
			return false;
		}
		Vendascomissao other = (Vendascomissao) object;
		if ((this.idvendascomissao == null && other.idvendascomissao != null)
				|| (this.idvendascomissao != null && !this.idvendascomissao.equals(other.idvendascomissao))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemaWK.model.Vendascomissao[ idvendascomissao=" + idvendascomissao + " ]";
	}
	
	
	
	

}
