package br.com.sistemaWK.tiposervicos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sistemaWK.facade.TipoServicosFacade;
import br.com.sistemaWK.model.Tiposervicos;

@Named
@ViewScoped
public class TipoServicosMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Tiposervicos> listaTipoServicos;
	
	
	
	@PostConstruct
	public void init() {
		
		listarTipoServicos();
	}



	public List<Tiposervicos> getListaTipoServicos() {
		return listaTipoServicos;
	}



	public void setListaTipoServicos(List<Tiposervicos> listaTipoServicos) {
		this.listaTipoServicos = listaTipoServicos;
	}
	
	
	
	public void listarTipoServicos() {
		TipoServicosFacade tipoServicosFacade = new TipoServicosFacade();
		listaTipoServicos = tipoServicosFacade.listar("Select t From Tiposervicos t");
		if (listaTipoServicos == null) {
			listaTipoServicos = new ArrayList<Tiposervicos>();
		}
	}
	
	
	public String novo() {
		return "cadTipoServicos";
	}
	
	
	public String editar(Tiposervicos tiposervicos) {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("tiposervicos", tiposervicos);
		return "cadTipoServicos";
	}
	
	
	
	
	

}
