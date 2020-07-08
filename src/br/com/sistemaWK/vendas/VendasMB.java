package br.com.sistemaWK.vendas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sistemaWK.facade.VendasFacade;
import br.com.sistemaWK.model.Vendas;

@Named
@ViewScoped
public class VendasMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Vendas> listaVendas;
	
	
	
	@PostConstruct
	public void init() {
		listarVendas();
	}



	public List<Vendas> getListaVendas() {
		return listaVendas;
	}



	public void setListaVendas(List<Vendas> listaVendas) {
		this.listaVendas = listaVendas;
	}
	
	
	
	public void listarVendas() {
		VendasFacade vendasFacade = new VendasFacade();
		listaVendas = vendasFacade.listar("Select v From Vendas v");
		if (listaVendas == null) {
			listaVendas = new ArrayList<Vendas>();
		}
	}
	
	
	public String novo() {
		return "cadVendas";
	}
	
	
	public String editar(Vendas vendas) {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("vendas", vendas);
		return "cadVendas";
	}
	
	
	
	public String contasReceber(Vendas vendas) {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("vendas", vendas);
		return "consContasReceber";
	}
	
	

	
}
