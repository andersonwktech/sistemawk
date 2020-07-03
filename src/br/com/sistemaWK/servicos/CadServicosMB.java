package br.com.sistemaWK.servicos;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sistemaWK.facade.ServicosFacade;
import br.com.sistemaWK.model.Servicos;
import br.com.sistemaWK.util.Mensagem;

@Named
@ViewScoped
public class CadServicosMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Servicos servicos;
	
	
	
	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		servicos = (Servicos) session.getAttribute("servicos");
		session.removeAttribute("servicos");
		if (servicos == null) {
			servicos = new Servicos();
			servicos.setAtivo(true);
			servicos.setDescricaoativo("check");
		}
	}



	public Servicos getServicos() {
		return servicos;
	}



	public void setServicos(Servicos servicos) {
		this.servicos = servicos;
	}
	
	
	
	public String cancelar() {
		return "consServicos";
	}
	
	
	public String salvar() {
		if (validarDados()) {
			ServicosFacade servicosFacade = new ServicosFacade();
			servicosFacade.salvar(servicos);
			return "consServicos";
		}
		return "";
	}
	
	
	public boolean validarDados() {
		if (servicos.getNomeservicos() == null || servicos.getNomeservicos().length() <= 0) {
			Mensagem.lancarMensagemInfo("Atenção", "Informe o nome do serviço");
			return false;
		}
		return true;
	}

	
	
	
	
	
}
