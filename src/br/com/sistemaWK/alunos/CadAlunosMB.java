package br.com.sistemaWK.alunos;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sistemaWK.util.ControladorCEPBean;
import br.com.sistemaWK.util.EnderecoBean;
import br.com.sistemaWK.util.Mensagem;
import br.com.sistemaWK.facade.AlunosFacade;
import br.com.sistemaWK.model.Alunos;

@Named
@ViewScoped
public class CadAlunosMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Alunos alunos;
	
	
	
	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		alunos = (Alunos) session.getAttribute("alunos");
		session.removeAttribute("alunos");
		if (alunos == null) {
			alunos = new Alunos();
		}
	}



	public Alunos getAlunos() {
		return alunos;
	}



	public void setAlunos(Alunos alunos) {
		this.alunos = alunos;
	}
	
	
	
	
	public void buscarendereco() {
		ControladorCEPBean cep = new ControladorCEPBean();
		cep.setCep(alunos.getCep());
		EnderecoBean endereco = cep.carregarEndereco();
		if (endereco.getLogradouro() != null) {
			alunos.setBairro(endereco.getBairro());
			alunos.setEstado(endereco.getUf());
			alunos.setCidade(endereco.getLocalidade());
			alunos.setComplemento(endereco.getComplemento());
			String logradouro = endereco.getLogradouro().substring(endereco.getLogradouro().indexOf(" "),
					endereco.getLogradouro().length());
			int posicao = endereco.getLogradouro().length();
			for (int i = 0; i <= logradouro.length(); i++) {
				posicao = posicao - 1;
			}
			String tipo = endereco.getLogradouro().substring(0, posicao + 1);
			alunos.setLogradouro(logradouro);
			alunos.setTipologradouro(tipo);
		}
	}
	
	
	
	public String cancelar() {
		return "consAlunos";
	}
	
	
	public String salvar() {
		if (validarDados()) {
			AlunosFacade alunosFacade = new AlunosFacade();
			alunosFacade.salvar(alunos);
			return "consAlunos";
		}
		return "";
	}
	
	
	public boolean validarDados() {
		if (alunos.getNome() == null || alunos.getNome().length() <= 0) {
			Mensagem.lancarMensagemInfo("Atenção", "Informe seu nome");
			return false;
		}
		return true;
	}
	
	
	
	

}
