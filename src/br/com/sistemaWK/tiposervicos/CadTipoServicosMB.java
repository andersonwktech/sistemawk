package br.com.sistemaWK.tiposervicos;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sistemaWK.facade.TipoServicosFacade;
import br.com.sistemaWK.model.Tiposervicos;
import br.com.sistemaWK.util.Mensagem;

@Named
@ViewScoped
public class CadTipoServicosMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tiposervicos tiposervicos;
	
	
	
	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		tiposervicos = (Tiposervicos) session.getAttribute("tiposervicos");
		session.removeAttribute("tiposervicos");
		if (tiposervicos == null) {
			tiposervicos = new Tiposervicos();
		}
	}



	public Tiposervicos getTiposervicos() {
		return tiposervicos;
	}



	public void setTiposervicos(Tiposervicos tiposervicos) {
		this.tiposervicos = tiposervicos;
	}
	
	
	
	
	public String cancelar() {
		return "consTipoServicos";
	}
	
	
	
	public String salvar() {
		if (tiposervicos.getDescricao() != null && tiposervicos.getDescricao().length() > 0) {
			TipoServicosFacade tipoServicosFacade = new TipoServicosFacade();
			tipoServicosFacade.salvar(tiposervicos);
			return "consTipoServicos";
		}else {
			Mensagem.lancarMensagemInfo("Aten��o", "Favor informe uma descri��o para esse tipo de servi�o");
		}
		return "";
	}
	
	

}
