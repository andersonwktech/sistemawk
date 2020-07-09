package br.com.sistemaWK.consultores;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sistemaWK.facade.ConsultoresFacade;
import br.com.sistemaWK.model.Consultores;
import br.com.sistemaWK.util.Mensagem;

@Named
@ViewScoped
public class CadConsultoresMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Consultores consultores;
	
	
	
	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		consultores = (Consultores) session.getAttribute("consultores");
		session.removeAttribute("consultores");
		if (consultores == null) {
			consultores = new Consultores();
			consultores.setAtivo(true);
			consultores.setDescricaoativo("check");
		}
	}



	public Consultores getconsultores() {
		return consultores;
	}



	public void setconsultores(Consultores consultores) {
		this.consultores = consultores;
	}
	
	
	
	public String cancelar() {
		return "consConsultores";
	}
	
	
	public String salvar() {
		if (validarDados()) {
			ConsultoresFacade consultoresFacade = new ConsultoresFacade();
			consultoresFacade.salvar(consultores);
			return "consConsultores";
		}
		return "";
	}
	
	
	public boolean validarDados() {
		if (consultores.getNome() == null || consultores.getNome().length() <=0) {
			Mensagem.lancarMensagemInfo("Atenção", "Informe seu nome");
			return false;
		}
		return true;
	}
	
	
	
	
	
	
	
	
	

}
