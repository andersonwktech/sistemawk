package br.com.sistemaWK.contaspagar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.sistemaWK.facade.ContasPagarFacade;
import br.com.sistemaWK.model.Contaspagar;

@Named
@ViewScoped
public class ContasPagarMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Contaspagar> listaContasPagar;
	
	
	@PostConstruct
	public void init() {
		listarContasPagar();
	}


	public List<Contaspagar> getListaContasPagar() {
		return listaContasPagar;
	}


	public void setListaContasPagar(List<Contaspagar> listaContasPagar) {
		this.listaContasPagar = listaContasPagar;
	}
	
	
	
	
	public void listarContasPagar() {
		ContasPagarFacade contasPagarFacade = new ContasPagarFacade();
		listaContasPagar = contasPagarFacade.listar("Select c From Contaspagar c WHERE c.pago=false");
		if (listaContasPagar == null) {
			listaContasPagar = new ArrayList<Contaspagar>();
		}
	}
	
	
	public String novo() {
		return "cadContasPagar";
	}
	
	
	
	

}
