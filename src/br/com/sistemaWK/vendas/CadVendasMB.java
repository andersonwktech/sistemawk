package br.com.sistemaWK.vendas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sistemaWK.util.ControladorCEPBean;
import br.com.sistemaWK.util.EnderecoBean;
import br.com.sistemaWK.facade.AlunosFacade;
import br.com.sistemaWK.facade.ContasReceberFacade;
import br.com.sistemaWK.facade.FormasPagamentoFacade;
import br.com.sistemaWK.facade.ProfessoresFacade;
import br.com.sistemaWK.facade.ServicosFacade;
import br.com.sistemaWK.facade.VendasFacade;
import br.com.sistemaWK.model.Alunos;
import br.com.sistemaWK.model.Contasreceber;
import br.com.sistemaWK.model.Formaspagamento;
import br.com.sistemaWK.model.Professores;
import br.com.sistemaWK.model.Servicos;
import br.com.sistemaWK.model.Vendas;
import br.com.sistemaWK.util.Mensagem;

@Named
@ViewScoped
public class CadVendasMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vendas vendas;
	private Alunos alunos;
	private Formaspagamento formaspagamento;
	private List<Formaspagamento> listaFormasPagamento;
	private List<Contasreceber> listaContasReceber;
	private Servicos servicos;
	private List<Servicos> listaServicos;
	private boolean trocarCliente = true;
	private String cpfAluno;
	private Professores professores;
	private List<Professores> listaProfessores;
	private float valorServico;
	private String cargahoraria;
	private Contasreceber contasreceber;
	private float valorParcelar;
	private float valorRestante;
	private String cep;
	private String teste;
	private String descricaoFormaPagamento;
	private float valorFormaPagamento;

	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		vendas = (Vendas) session.getAttribute("vendas");
		session.removeAttribute("vendas");
		formaspagamento = new Formaspagamento();
		contasreceber = new Contasreceber();
		if (vendas == null) {
			vendas = new Vendas();
			vendas.setDatavenda(new Date());
			vendas.setStatus("Não Pago");
			vendas.setCorstatus("red");
			alunos = new Alunos();
		}else {
			alunos = vendas.getAlunos();
			cpfAluno = alunos.getCpf();
			this.cep = alunos.getCep();
			servicos = vendas.getServicos();
			professores = vendas.getProfessores();
			buscarFormasPagamento();
			buscarContasReceber();
			verificarValores();
		}
		listarServicos();
		listarProfessores();
	}

	public Vendas getVendas() {
		return vendas;
	}

	public void setVendas(Vendas vendas) {
		this.vendas = vendas;
	}

	public Alunos getAlunos() {
		return alunos;
	}

	public void setAlunos(Alunos alunos) {
		this.alunos = alunos;
	}

	public Formaspagamento getFormaspagamento() {
		return formaspagamento;
	}

	public void setFormaspagamento(Formaspagamento formaspagamento) {
		this.formaspagamento = formaspagamento;
	}

	public List<Formaspagamento> getListaFormasPagamento() {
		return listaFormasPagamento;
	}

	public void setListaFormasPagamento(List<Formaspagamento> listaFormasPagamento) {
		this.listaFormasPagamento = listaFormasPagamento;
	}

	public List<Contasreceber> getListaContasReceber() {
		return listaContasReceber;
	}

	public void setListaContasReceber(List<Contasreceber> listaContasReceber) {
		this.listaContasReceber = listaContasReceber;
	}

	public Servicos getServicos() {
		return servicos;
	}

	public void setServicos(Servicos servicos) {
		this.servicos = servicos;
	}

	public List<Servicos> getListaServicos() {
		return listaServicos;
	}

	public void setListaServicos(List<Servicos> listaServicos) {
		this.listaServicos = listaServicos;
	}

	public boolean isTrocarCliente() {
		return trocarCliente;
	}

	public void setTrocarCliente(boolean trocarCliente) {
		this.trocarCliente = trocarCliente;
	}

	public String getCpfAluno() {
		return cpfAluno;
	}

	public void setCpfAluno(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}

	public Professores getProfessores() {
		return professores;
	}

	public void setProfessores(Professores professores) {
		this.professores = professores;
	}

	public List<Professores> getListaProfessores() {
		return listaProfessores;
	}

	public void setListaProfessores(List<Professores> listaProfessores) {
		this.listaProfessores = listaProfessores;
	}

	public float getValorServico() {
		return valorServico;
	}

	public void setValorServico(float valorServico) {
		this.valorServico = valorServico;
	}

	public String getCargahoraria() {
		return cargahoraria;
	}

	public void setCargahoraria(String cargahoraria) {
		this.cargahoraria = cargahoraria;
	}

	public Contasreceber getContasreceber() {
		return contasreceber;
	}

	public void setContasreceber(Contasreceber contasreceber) {
		this.contasreceber = contasreceber;
	}

	public float getValorParcelar() {
		return valorParcelar;
	}

	public void setValorParcelar(float valorParcelar) {
		this.valorParcelar = valorParcelar;
	}

	public float getValorRestante() {
		return valorRestante;
	}

	public void setValorRestante(float valorRestante) {
		this.valorRestante = valorRestante;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}

	public String getDescricaoFormaPagamento() {
		return descricaoFormaPagamento;
	}

	public void setDescricaoFormaPagamento(String descricaoFormaPagamento) {
		this.descricaoFormaPagamento = descricaoFormaPagamento;
	}

	public float getValorFormaPagamento() {
		return valorFormaPagamento;
	}

	public void setValorFormaPagamento(float valorFormaPagamento) {
		this.valorFormaPagamento = valorFormaPagamento;
	}

	public void listarServicos() {
		ServicosFacade servicosFacade = new ServicosFacade();
		listaServicos = servicosFacade.listar("Select s From Servicos s");
		if (listaServicos == null) {
			listaServicos = new ArrayList<Servicos>();
		}
	}

	public void listarProfessores() {
		ProfessoresFacade professoresFacade = new ProfessoresFacade();
		listaProfessores = professoresFacade.listar("Select p From Professores p WHERE p.ativo=true");
		if (listaProfessores == null) {
			listaProfessores = new ArrayList<Professores>();
		}
	}

	public void buscarAluno() {
		AlunosFacade alunosFacade = new AlunosFacade();
		alunos = alunosFacade.consultarCPF(cpfAluno);
		if (alunos == null) {
			alunos = new Alunos();
			Mensagem.lancarMensagemInfo("Atenção", "Aluno não encontrado \n Inseria dados do aluno manualmente!!");
		} else { 
			this.cep = alunos.getCep();
			Mensagem.lancarMensagemInfo("Atenção", "Aluno encontrado!!");
		}
	}

	public void adicionarFormaPagamento() {
		if (listaFormasPagamento == null) {
			listaFormasPagamento = new ArrayList<Formaspagamento>();
		}
		if (descricaoFormaPagamento != null) {
			formaspagamento = new Formaspagamento();
			formaspagamento.setDescricao(descricaoFormaPagamento);
			formaspagamento.setValor(valorFormaPagamento);
			valorRestante = valorRestante + valorFormaPagamento;
			vendas.setValorvenda(vendas.getValorvenda() + valorFormaPagamento);
			listaFormasPagamento.add(formaspagamento);
			descricaoFormaPagamento = "";
			valorFormaPagamento = 0.0f;
		}
	}
	
	public void excluirFormaPagamento(String ilinha) {
		int linha = Integer.parseInt(ilinha);
		if (linha >= 0) {
			if (listaFormasPagamento.get(linha).getIdformaspagamento() != null) {
				FormasPagamentoFacade formasPagamentoFacade = new FormasPagamentoFacade();
				formasPagamentoFacade.excluir(listaFormasPagamento.get(linha).getIdformaspagamento());
			}
			valorRestante = valorRestante - listaFormasPagamento.get(linha).getValor();
			vendas.setValorvenda(vendas.getValorvenda() - listaFormasPagamento.get(linha).getValor());
			listaFormasPagamento.remove(linha);
		}
	}

	public void buscarendereco() {
		ControladorCEPBean cep = new ControladorCEPBean();
		cep.setCep(this.cep);
		EnderecoBean endereco = cep.carregarEndereco();
		if (endereco.getLogradouro() != null) {
			alunos.setCep(this.cep);
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
			teste = logradouro;
			Mensagem.lancarMensagemInfo("Atenção", "CEP encontrado com sucesso");
		}
	}

	public void dadosProdutos() {
		if (servicos != null) {
			valorServico = servicos.getValor();
			cargahoraria = servicos.getCargahoraria();
			descricaoFormaPagamento = servicos.getNomeservicos();
			valorFormaPagamento = servicos.getValor();
			adicionarFormaPagamento();
		}
	}

	public void calcularParcelas() {
		if (contasreceber != null) {
			if (valorParcelar > 0.0f && contasreceber.getNparcela() > 0) {
				if (valorParcelar <= valorRestante) {
					contasreceber.setValorparcela(valorParcelar / contasreceber.getNparcela());
				}else {
					Mensagem.lancarMensagemInfo("Atenção", "Valor a Parcelar maior que o valor total da venda");
				}
			}else {
				Mensagem.lancarMensagemInfo("Atenção", "Digite o valor a parcelar, junto com o número de parcelas");
			}
		}
	}
	
	
	public void adicionarContas() {
		if (listaContasReceber == null) {
			listaContasReceber = new ArrayList<Contasreceber>();
		}
		if (contasreceber != null) {
			Date datavencimento = contasreceber.getDatavencimento();
			float valorparcela = contasreceber.getValorparcela();
			int nParcela = contasreceber.getNparcela();
			String forma = contasreceber.getFormapagamento();
			if (contasreceber.getValorparcela() > 0 && contasreceber.getDatavencimento() != null
					&& contasreceber.getNparcela() > 0) {
				for (int i = 1; i <= nParcela; i++) {
					contasreceber.setDatavencimento(datavencimento);
					contasreceber.setValorparcela(valorparcela);
					contasreceber.setFormapagamento(forma);
					contasreceber.setNparcela(nParcela);
					contasreceber.setNumeroparcela(i);
					contasreceber.setCorstatus("red");
					contasreceber.setStatus("x-circle");
					contasreceber.setPago(false);
					if (vendas.getIdvendas() != null) {
						contasreceber.setVendas(vendas);
					}
					listaContasReceber.add(contasreceber);
					valorRestante = valorRestante - contasreceber.getValorparcela();
					contasreceber = new Contasreceber();
				}
			}
		}
	}
	
	
	public void excluirContas(String ilinha) {
		int linha = Integer.parseInt(ilinha);
		if (linha >= 0) {
			if (listaContasReceber.get(linha).getIdcontasreceber() != null) {
				ContasReceberFacade contasReceberFacade = new ContasReceberFacade();
				contasReceberFacade.excluir(listaContasReceber.get(linha).getIdcontasreceber());
			}
			valorRestante = valorRestante + listaContasReceber.get(linha).getValorparcela();
			listaContasReceber.remove(linha);
		}
	}
	
	
	public String cancelar() {
		return "consVendas";
	}
	
	
	public String salvar() {
		if (validarDados()) {
			salvarAluno();
			vendas.setAlunos(alunos);
			vendas.setProfessores(professores);
			vendas.setServicos(servicos);
			VendasFacade vendasFacade = new VendasFacade();
			vendas = vendasFacade.salvar(vendas);
			salvarFormasPagamento();
			salvarContasReceber();
			return "consVendas";
		}
		return "";
	}
	
	
	public void salvarFormasPagamento() {
		if (listaFormasPagamento == null) {
			listaFormasPagamento = new ArrayList<Formaspagamento>();
		}
		FormasPagamentoFacade formasPagamentoFacade = new FormasPagamentoFacade();
		for (int i = 0; i < listaFormasPagamento.size(); i++) {
			listaFormasPagamento.get(i).setVendas(vendas);
			formasPagamentoFacade.salvar(listaFormasPagamento.get(i));
		}
	}
	
	
	public void salvarContasReceber() {
		if (listaContasReceber == null) {
			listaContasReceber = new ArrayList<Contasreceber>();
		}
		ContasReceberFacade contasReceberFacade = new ContasReceberFacade();
		for (int i = 0; i < listaContasReceber.size(); i++) {
			listaContasReceber.get(i).setVendas(vendas);
			contasReceberFacade.salvar(listaContasReceber.get(i));
		}
	}
	
	
	public boolean validarDados() {
		if (listaFormasPagamento == null || listaFormasPagamento.size() <= 0) {
			Mensagem.lancarMensagemInfo("Atenção", "Favor inserir produtos na listagem de orçamento!!");
			return false;
		}
		
		if (valorRestante < 0.0f) {
			Mensagem.lancarMensagemInfo("Atenção", "Valor restante de pagamento consta negativo!!");
			return false;
		}
		
		if (valorRestante > 0.01f) {
			Mensagem.lancarMensagemInfo("Atençao", "Valor restante ainda consta em aberto para pagamento!!");
			return false;
		}
		
		if (alunos == null) {
			Mensagem.lancarMensagemInfo("Atenção", "Favor inserir um Aluno a esta venda!!");
			return false;
		}
		
		if (servicos == null) {
			Mensagem.lancarMensagemInfo("Atenção", "Favor inserir algum produto");
			return false;
		}
		
		if (professores == null) {
			Mensagem.lancarMensagemInfo("Atenção", "Favor inserir um professor");
			return false;
		}
		return true; 
	}
	
	
	
	public void verificarValores() {
		if (listaFormasPagamento == null) {
			listaFormasPagamento = new ArrayList<Formaspagamento>();
		}
		if (listaContasReceber == null) {
			listaContasReceber = new ArrayList<Contasreceber>();
		}
		
		for (int i = 0; i < listaFormasPagamento.size(); i++) {
			valorRestante = valorRestante + listaFormasPagamento.get(i).getValor();
		}
		
		for (int i = 0; i < listaContasReceber.size(); i++) {
			valorRestante = valorRestante - listaContasReceber.get(i).getValorparcela();
		}
	}
	
	
	public void salvarAluno() {
		AlunosFacade alunosFacade = new AlunosFacade();
		alunos = alunosFacade.salvar(alunos);
	}
	
	
	public void buscarContasReceber() {
		if (vendas != null) {
			ContasReceberFacade contasReceberFacade = new ContasReceberFacade();
			listaContasReceber = contasReceberFacade.listar("Select c From Contasreceber c WHERE c.vendas.idvendas=" + vendas.getIdvendas());
			if (listaContasReceber == null) {
				listaContasReceber = new ArrayList<Contasreceber>();
			}
		}
	}
	
	
	public void buscarFormasPagamento() {
		if (vendas != null) {
			FormasPagamentoFacade formasPagamentoFacade = new FormasPagamentoFacade();
			listaFormasPagamento = formasPagamentoFacade.listar("Select f From Formaspagamento f WHERE f.vendas.idvendas=" + vendas.getIdvendas());
			if (listaFormasPagamento == null) {
				listaFormasPagamento = new ArrayList<Formaspagamento>();
			}
		}
	}
	
	
	
	

}
