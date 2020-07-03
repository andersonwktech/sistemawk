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
@Table(name = "acesso")
public class Acesso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idacesso")
    private Integer idacesso;
	@Column(name = "cadastro")
	private boolean cadastro;
	@Column(name = "editar")
	private boolean editar;
	@Column(name = "excluir")
	private boolean excluir;
	
	
	public Acesso() {
	
	}


	public Integer getIdacesso() {
		return idacesso;
	}


	public void setIdacesso(Integer idacesso) {
		this.idacesso = idacesso;
	}


	public boolean isCadastro() {
		return cadastro;
	}


	public void setCadastro(boolean cadastro) {
		this.cadastro = cadastro;
	}


	public boolean isEditar() {
		return editar;
	}


	public void setEditar(boolean editar) {
		this.editar = editar;
	}


	public boolean isExcluir() {
		return excluir;
	}


	public void setExcluir(boolean excluir) {
		this.excluir = excluir;
	}
	
	
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idacesso != null ? idacesso.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Acesso)) {
			return false;
		}
		Acesso other = (Acesso) object;
		if ((this.idacesso == null && other.idacesso != null)
				|| (this.idacesso != null && !this.idacesso.equals(other.idacesso))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemaWK.model.Acesso[ idacesso=" + idacesso + " ]";
	}
	
	
	
	
	

}
