package br.com.sistemaWK.fornecedor;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.sistemaWK.model.Fornecedor;

@Named
@ViewScoped
public class FornecedorMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Fornecedor> listaFornecedor;
	
	
	
	@PostConstruct
	public void init() {
		
	}



	public List<Fornecedor> getListaFornecedor() {
		return listaFornecedor;
	}



	public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
		this.listaFornecedor = listaFornecedor;
	}
	
	
	
	
	

}
