package br.com.sistemaWK.cliente;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sistemaWK.util.ControladorCEPBean;
import br.com.sistemaWK.util.EnderecoBean;
import br.com.sistemaWK.util.Mensagem;
import br.com.sistemaWK.facade.ClienteFacade;
import br.com.sistemaWK.model.Cliente;

@Named
@ViewScoped
public class CadClienteMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	
	
	
	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		cliente = (Cliente) session.getAttribute("cliente");
		session.removeAttribute("cliente");
		if (cliente == null) {
			cliente = new Cliente();
		}
	}



	public Cliente getcliente() {
		return cliente;
	}



	public void setcliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
	public void buscarendereco() {
		ControladorCEPBean cep = new ControladorCEPBean();
		cep.setCep(cliente.getCep());
		EnderecoBean endereco = cep.carregarEndereco();
		if (endereco.getLogradouro() != null) {
			cliente.setBairro(endereco.getBairro());
			cliente.setEstado(endereco.getUf());
			cliente.setCidade(endereco.getLocalidade());
			cliente.setComplemento(endereco.getComplemento());
			String logradouro = endereco.getLogradouro().substring(endereco.getLogradouro().indexOf(" "),
					endereco.getLogradouro().length());
			int posicao = endereco.getLogradouro().length();
			for (int i = 0; i <= logradouro.length(); i++) {
				posicao = posicao - 1;
			}
			String tipo = endereco.getLogradouro().substring(0, posicao + 1);
			cliente.setLogradouro(logradouro);
			cliente.setTipologradouro(tipo);
		}
	}
	
	
	
	public String cancelar() {
		return "consCliente";
	}
	
	
	public String salvar() {
		if (validarDados()) {
			ClienteFacade clienteFacade = new ClienteFacade();
			clienteFacade.salvar(cliente);
			return "consCliente";
		}
		return "";
	}
	
	
	public boolean validarDados() {
		if (cliente.getNome() == null || cliente.getNome().length() <= 0) {
			Mensagem.lancarMensagemInfo("Atenção", "Informe seu nome");
			return false;
		}
		return true;
	}
	
	
	
	

}
