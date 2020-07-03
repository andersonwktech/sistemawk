package br.com.sistemaWK.professores;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sistemaWK.facade.ProfessoresFacade;
import br.com.sistemaWK.model.Professores;
import br.com.sistemaWK.util.Mensagem;

@Named
@ViewScoped
public class CadProfessoresMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Professores professores;
	
	
	
	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		professores = (Professores) session.getAttribute("professores");
		session.removeAttribute("professores");
		if (professores == null) {
			professores = new Professores();
			professores.setAtivo(true);
			professores.setDescricaoativo("check");
		}
	}



	public Professores getProfessores() {
		return professores;
	}



	public void setProfessores(Professores professores) {
		this.professores = professores;
	}
	
	
	
	public String cancelar() {
		return "consProfessores";
	}
	
	
	public String salvar() {
		if (validarDados()) {
			ProfessoresFacade professoresFacade = new ProfessoresFacade();
			professoresFacade.salvar(professores);
			return "consProfessores";
		}
		return "";
	}
	
	
	public boolean validarDados() {
		if (professores.getNome() == null || professores.getNome().length() <=0) {
			Mensagem.lancarMensagemInfo("Atenção", "Informe seu nome");
			return false;
		}
		return true;
	}
	
	
	
	
	
	
	
	
	

}
