package br.com.sistemaWK.servicos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sistemaWK.facade.ServicosFacade;
import br.com.sistemaWK.model.Servicos;

@Named
@ViewScoped
public class ServicosMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Servicos> listaServicos;
	
	
	
	@PostConstruct
	public void init() {
		listarServicos();
	}



	public List<Servicos> getListaServicos() {
		return listaServicos;
	}



	public void setListaServicos(List<Servicos> listaServicos) {
		this.listaServicos = listaServicos;
	}
	
	
	
	public String novo() {
		return "cadServicos";
	}
	
	
	public String editar(Servicos servicos) {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("servicos", servicos);
		return "cadServicos";
	}
	
	
	public void ativarDesativarServicos(Servicos servicos) {
		ServicosFacade servicosFacade = new ServicosFacade();
		if (servicos.isAtivo()) {
			servicos.setAtivo(false);
			servicos.setDescricaoativo("x-circle");
		}else {
			servicos.setAtivo(true);
			servicos.setDescricaoativo("check");
		}
		servicosFacade.salvar(servicos);
	}
	
	
	public void listarServicos() {
		ServicosFacade servicosFacade = new ServicosFacade();
		listaServicos = servicosFacade.listar("Select s From Servicos s");
		if (listaServicos == null) {
			listaServicos = new ArrayList<Servicos>();
		}
	}
	
	
	public String turma(Servicos servicos) {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("servicos", servicos);
		return "consTurma";
	}
	
	
	
	
	
	

}
