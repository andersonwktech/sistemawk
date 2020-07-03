package br.com.sistemaWK.professores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sistemaWK.facade.ProfessoresFacade;
import br.com.sistemaWK.model.Professores;

@Named
@ViewScoped
public class ProfessoresMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Professores> listaProfessores;
	
	
	
	@PostConstruct
	public void init() {
		listarProfessores();
	}



	public List<Professores> getListaProfessores() {
		return listaProfessores;
	}



	public void setListaProfessores(List<Professores> listaProfessores) {
		this.listaProfessores = listaProfessores;
	}
	
	
	
	
	public void listarProfessores() {
		ProfessoresFacade professoresFacade = new ProfessoresFacade();
		listaProfessores = professoresFacade.listar("Select p From Professores p");
		if (listaProfessores == null) {
			listaProfessores = new ArrayList<Professores>();
		}
	}
	
	
	public String novo() {
		return "cadProfessores";
	}
	
	
	public String editar(Professores professores) {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("professores", professores);
		return "cadProfessores";
	}
	
	
	public void ativarDesativarProfessores(Professores professores) {
		ProfessoresFacade professoresFacade = new ProfessoresFacade();
		if (professores.isAtivo()) {
			professores.setAtivo(false);
			professores.setDescricaoativo("x-circle");
		}else {
			professores.setAtivo(true);
			professores.setDescricaoativo("check");
		}
		professoresFacade.salvar(professores);
	}
	
	
	
	
	
	

}
