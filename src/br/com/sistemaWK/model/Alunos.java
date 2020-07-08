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
@Table(name = "alunos")
public class Alunos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idalunos")
    private Integer idalunos;
	@Column(name = "nome")
	private String nome;
	@Column(name = "email")
	private String email;
	@Column(name = "telefonecelular")
	private String telefonecelular;
	@Column(name = "tipologradouro")
	private String tipologradouro;
	@Column(name = "logradouro")
	private String logradouro;
	@Column(name = "numero")
	private String numero;
	@Column(name = "bairro")
	private String bairro;
	@Column(name = "cidade")
	private String cidade;
	@Column(name = "estado")
	private String estado;
	@Column(name = "cep")
	private String cep;
	@Column(name = "complemento")
	private String complemento;
	@Column(name = "cpf")
	private String cpf;
	
	
	
	public Alunos() {
	
	}



	public Integer getIdalunos() {
		return idalunos;
	}



	public void setIdalunos(Integer idalunos) {
		this.idalunos = idalunos;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTelefonecelular() {
		return telefonecelular;
	}



	public void setTelefonecelular(String telefonecelular) {
		this.telefonecelular = telefonecelular;
	}



	public String getTipologradouro() {
		return tipologradouro;
	}



	public void setTipologradouro(String tipologradouro) {
		this.tipologradouro = tipologradouro;
	}



	public String getLogradouro() {
		return logradouro;
	}



	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public String getBairro() {
		return bairro;
	}



	public void setBairro(String bairro) {
		this.bairro = bairro;
	}



	public String getCidade() {
		return cidade;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getCep() {
		return cep;
	}



	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
	
	public String getComplemento() {
		return complemento;
	}



	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idalunos != null ? idalunos.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Alunos)) {
			return false;
		}
		Alunos other = (Alunos) object;
		if ((this.idalunos == null && other.idalunos != null)
				|| (this.idalunos != null && !this.idalunos.equals(other.idalunos))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemaWK.model.Alunos[ idalunos=" + idalunos + " ]";
	}
	
	
	
	
	

}
