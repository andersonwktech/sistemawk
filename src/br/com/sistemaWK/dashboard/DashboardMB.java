package br.com.sistemaWK.dashboard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.sistemaWK.facade.VendasFacade;
import br.com.sistemaWK.model.Vendas;

@Named
@ViewScoped
public class DashboardMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Vendas> listaVendas;
	
	
	@PostConstruct
	public void init() {
		listarUltimasVendas();
	}


	public List<Vendas> getListaVendas() {
		return listaVendas;
	}


	public void setListaVendas(List<Vendas> listaVendas) {
		this.listaVendas = listaVendas;
	}
	
	
	public void listarUltimasVendas() {
		VendasFacade vendasFacade = new VendasFacade();
		listaVendas = vendasFacade.listar("Select v From Vendas v ORDER BY v.idvendas DESC");
		if (listaVendas == null) {
			listaVendas = new ArrayList<Vendas>();
		}
	}
	 
	
	
	

}
