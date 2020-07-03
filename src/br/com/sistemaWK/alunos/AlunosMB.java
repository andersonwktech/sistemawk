package br.com.sistemaWK.alunos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sistemaWK.facade.AlunosFacade;
import br.com.sistemaWK.model.Alunos;

@Named
@ViewScoped
public class AlunosMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Alunos> listaAlunos;
	
	
	
	@PostConstruct
	public void init() {
		listarAlunos();
	}



	public List<Alunos> getListaAlunos() {
		return listaAlunos;
	}



	public void setListaAlunos(List<Alunos> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}
	
	
	
	
	public void listarAlunos() {
		AlunosFacade alunosFacade = new AlunosFacade();
		listaAlunos = alunosFacade.listar("Select a From Alunos a");
		if (listaAlunos == null) {
			listaAlunos = new ArrayList<Alunos>();
		}
	}
	
	
	public String novo() {
		return "cadAlunos";
	}
	
	
	public String editar(Alunos alunos) {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("alunos", alunos);
		return "cadAlunos";
	}
	
	
	
	
	

}
