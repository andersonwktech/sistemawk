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
@Table(name = "banco")
public class Banco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbanco")
    private Integer idbanco;
	@Column(name = "agencia")
	private String agencia;
	@Column(name = "conta")
	private String conta;
	@Column(name = "nome")
	private String nome;
	@Column(name = "gerente")
	private String gerente;
	@Column(name = "emailgerente")
	private String emailgerente;
	@Column(name = "digitoagencia")
	private String digitoagencia;
	@Column(name = "digitoconta")
	private String digitoconta;
	@Column(name = "carteira")
	private String carteira;
	@Column(name = "valorjuros")
	private float valorjuros;
	@Column(name = "valormulta")
	private float valormulta;
	
	
	public Banco() {
	
	}


	public Integer getIdbanco() {
		return idbanco;
	}


	public void setIdbanco(Integer idbanco) {
		this.idbanco = idbanco;
	}


	public String getAgencia() {
		return agencia;
	}


	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}


	public String getConta() {
		return conta;
	}


	public void setConta(String conta) {
		this.conta = conta;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getGerente() {
		return gerente;
	}


	public void setGerente(String gerente) {
		this.gerente = gerente;
	}


	public String getEmailgerente() {
		return emailgerente;
	}


	public void setEmailgerente(String emailgerente) {
		this.emailgerente = emailgerente;
	}


	public String getDigitoagencia() {
		return digitoagencia;
	}


	public void setDigitoagencia(String digitoagencia) {
		this.digitoagencia = digitoagencia;
	}


	public String getDigitoconta() {
		return digitoconta;
	}


	public void setDigitoconta(String digitoconta) {
		this.digitoconta = digitoconta;
	}


	public String getCarteira() {
		return carteira;
	}


	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}


	public float getValorjuros() {
		return valorjuros;
	}


	public void setValorjuros(float valorjuros) {
		this.valorjuros = valorjuros;
	}


	public float getValormulta() {
		return valormulta;
	}


	public void setValormulta(float valormulta) {
		this.valormulta = valormulta;
	}
	
	
	
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idbanco != null ? idbanco.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Banco)) {
			return false;
		}
		Banco other = (Banco) object;
		if ((this.idbanco == null && other.idbanco != null)
				|| (this.idbanco != null && !this.idbanco.equals(other.idbanco))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemaWK.model.Banco[ idbanco=" + idbanco + " ]";
	}
	
	
	
	
}
