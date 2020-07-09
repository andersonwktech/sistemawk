package br.com.sistemaWK.servicos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sistemaWK.facade.ConsultoresFacade;
import br.com.sistemaWK.facade.ServicosFacade;
import br.com.sistemaWK.facade.TipoServicosFacade;
import br.com.sistemaWK.model.Consultores;
import br.com.sistemaWK.model.Servicos;
import br.com.sistemaWK.model.Tiposervicos;
import br.com.sistemaWK.util.Mensagem;

@Named
@ViewScoped
public class CadServicosMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Servicos servicos;
	private Tiposervicos tiposervicos;
	private List<Tiposervicos> listaTipoServicos;
	private Consultores consultores;
	private List<Consultores> listaConsultores;
	
	
	
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
		}else {
			tiposervicos = servicos.getTiposervicos();
			consultores = servicos.getConsultores();
		}
		listarConsultores();
		listarTipoServicos();
	}



	public Servicos getServicos() {
		return servicos;
	}



	public void setServicos(Servicos servicos) {
		this.servicos = servicos;
	}
	
	
	
	public Tiposervicos getTiposervicos() {
		return tiposervicos;
	}



	public void setTiposervicos(Tiposervicos tiposervicos) {
		this.tiposervicos = tiposervicos;
	}



	public List<Tiposervicos> getListaTipoServicos() {
		return listaTipoServicos;
	}



	public void setListaTipoServicos(List<Tiposervicos> listaTipoServicos) {
		this.listaTipoServicos = listaTipoServicos;
	}



	public Consultores getConsultores() {
		return consultores;
	}



	public void setConsultores(Consultores consultores) {
		this.consultores = consultores;
	}



	public List<Consultores> getListaConsultores() {
		return listaConsultores;
	}



	public void setListaConsultores(List<Consultores> listaConsultores) {
		this.listaConsultores = listaConsultores;
	}



	public String cancelar() {
		return "consServicos";
	}
	
	
	public String salvar() {
		if (validarDados()) {
			servicos.setConsultores(consultores);
			servicos.setTiposervicos(tiposervicos);
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
		
		if (tiposervicos == null || tiposervicos.getIdtiposervicos() == null) {
			Mensagem.lancarMensagemInfo("Atenção", "Informe o tipo de serviço");
			return false;
		}
		
		if (consultores == null || consultores.getIdconsultores() == null) {
			Mensagem.lancarMensagemInfo("Atenção", "Informe o consultor responsável");
			return false;
		}
		return true;
	}
	
	
	public void listarConsultores() {
		ConsultoresFacade consultoresFacade = new ConsultoresFacade();
		listaConsultores = consultoresFacade.listar("Select c From Consultores c");
		if (listaConsultores == null) {
			listaConsultores = new ArrayList<Consultores>();
		}
	}
	
	
	public void listarTipoServicos() {
		TipoServicosFacade tipoServicosFacade = new TipoServicosFacade();
		listaTipoServicos = tipoServicosFacade.listar("Select t From Tiposervicos t");
		if (listaTipoServicos == null) {
			listaTipoServicos = new ArrayList<Tiposervicos>();
		}
	}

	
	
	
	
	
}
