package br.com.sistemaWK.cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sistemaWK.facade.ClienteFacade;
import br.com.sistemaWK.model.Cliente;

@Named
@ViewScoped
public class ClienteMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Cliente> listaCliente;
	
	
	
	@PostConstruct
	public void init() {
		listarAlunos();
	}



	public List<Cliente> getlistaCliente() {
		return listaCliente;
	}



	public void setlistaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	
	
	
	
	public void listarAlunos() {
		ClienteFacade alunosFacade = new ClienteFacade();
		listaCliente = alunosFacade.listar("Select c From Cliente c");
		if (listaCliente == null) {
			listaCliente = new ArrayList<Cliente>();
		}
	}
	
	
	public String novo() {
		return "cadCliente";
	}
	
	
	public String editar(Cliente cliente) {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("cliente", cliente);
		return "cadCliente";
	}
	
	
	
	
	

}
