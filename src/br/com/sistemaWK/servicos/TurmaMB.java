package br.com.sistemaWK.servicos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sistemaWK.facade.VendasClienteFacade;
import br.com.sistemaWK.model.Servicos;
import br.com.sistemaWK.model.Vendascliente;

@Named
@ViewScoped
public class TurmaMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Vendascliente> listaTurma;
	private Servicos servicos;
	
	
	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		servicos = (Servicos) session.getAttribute("servicos");
		session.removeAttribute("servicos");
		if (servicos != null) {
			buscarTurma();
		}
	}


	public List<Vendascliente> getListaTurma() {
		return listaTurma;
	}


	public void setListaTurma(List<Vendascliente> listaTurma) {
		this.listaTurma = listaTurma;
	}
	
	
	public Servicos getServicos() {
		return servicos;
	}


	public void setServicos(Servicos servicos) {
		this.servicos = servicos;
	}

	
	

	public void buscarTurma() {
		VendasClienteFacade vendasClienteFacade = new VendasClienteFacade();
		listaTurma = vendasClienteFacade.listar("Select v From Vendascliente v WHERE v.vendas.servicos.idservicos=" 
				+ servicos.getIdservicos());
		if (listaTurma == null) {
			listaTurma = new ArrayList<Vendascliente>();
		}
	}
	
	
	public String voltar() {
		return "consServicos";
	}
	
	
	
	
	

}
