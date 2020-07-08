package br.com.sistemaWK.vendas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sistemaWK.facade.ContasReceberFacade;
import br.com.sistemaWK.model.Contasreceber;
import br.com.sistemaWK.model.Vendas;

@Named
@ViewScoped
public class ContasReceberMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Contasreceber> listaContasReceber;
	private Vendas vendas;
	
	
	
	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		vendas = (Vendas) session.getAttribute("vendas");
		session.removeAttribute("vendas");
		listarContasReceber();
	}



	public List<Contasreceber> getListaContasReceber() {
		return listaContasReceber;
	}



	public void setListaContasReceber(List<Contasreceber> listaContasReceber) {
		this.listaContasReceber = listaContasReceber;
	}



	public Vendas getVendas() {
		return vendas;
	}



	public void setVendas(Vendas vendas) {
		this.vendas = vendas;
	}
	
	
	
	public void listarContasReceber() {
		ContasReceberFacade contasReceberFacade = new ContasReceberFacade();
		listaContasReceber = contasReceberFacade.listar("Select c From Contasreceber c WHERE c.vendas.idvendas=" + vendas.getIdvendas());
		if (listaContasReceber == null) {
			listaContasReceber = new ArrayList<Contasreceber>();
		}
	}
	
	
	public String voltar() {
		return "consVendas";
	}
	
	
	public void pagamentoContas(Contasreceber contasreceber) {
		ContasReceberFacade contasReceberFacade = new ContasReceberFacade();
		if (contasreceber.isPago()) {
			contasreceber.setPago(false);
			contasreceber.setStatus("x-circle");
			contasreceber.setCorstatus("red");
		}else {
			contasreceber.setPago(true);
			contasreceber.setStatus("check");
			contasreceber.setCorstatus("green");
		}
		contasReceberFacade.salvar(contasreceber);
	}
	
	
	

}
