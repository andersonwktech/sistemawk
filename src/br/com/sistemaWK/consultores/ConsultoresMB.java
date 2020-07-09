package br.com.sistemaWK.consultores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sistemaWK.facade.ConsultoresFacade;
import br.com.sistemaWK.model.Consultores;

@Named
@ViewScoped
public class ConsultoresMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Consultores> listaConsultores;
	
	
	
	@PostConstruct
	public void init() {
		listarConsultores();
	}



	
	
	
	public List<Consultores> getListaConsultores() {
		return listaConsultores;
	}






	public void setListaConsultores(List<Consultores> listaConsultores) {
		this.listaConsultores = listaConsultores;
	}






	public void listarConsultores() {
		ConsultoresFacade consultoresFacade = new ConsultoresFacade();
		listaConsultores = consultoresFacade.listar("Select c From Consultores c");
		if (listaConsultores == null) {
			listaConsultores = new ArrayList<Consultores>();
		}
	}
	
	
	public String novo() {
		return "cadConsultores";
	}
	
	
	public String editar(Consultores consultores) {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("consultores", consultores);
		return "cadConsultores";
	}
	
	
	public void ativarDesativarConsultores(Consultores consultores) {
		ConsultoresFacade consultoresFacade = new ConsultoresFacade();
		if (consultores.isAtivo()) {
			consultores.setAtivo(false);
			consultores.setDescricaoativo("x-circle");
		}else {
			consultores.setAtivo(true);
			consultores.setDescricaoativo("check");
		}
		consultoresFacade.salvar(consultores);
	}
	
	
	
	
	
	

}
