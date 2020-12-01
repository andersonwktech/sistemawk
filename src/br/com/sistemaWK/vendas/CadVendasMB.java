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
import br.com.sistemaWK.util.Formatacao;
import br.com.sistemaWK.dao.VendasClienteDao;
import br.com.sistemaWK.facade.ClienteFacade;
import br.com.sistemaWK.facade.ConsultoresFacade;
import br.com.sistemaWK.facade.ContasReceberFacade;
import br.com.sistemaWK.facade.ContratanteFacade;
import br.com.sistemaWK.facade.FormasPagamentoFacade;
import br.com.sistemaWK.facade.ServicosFacade;
import br.com.sistemaWK.facade.TipoServicosFacade;
import br.com.sistemaWK.facade.VendasClienteFacade;
import br.com.sistemaWK.facade.VendasFacade;
import br.com.sistemaWK.model.Cliente;
import br.com.sistemaWK.model.Contasreceber;
import br.com.sistemaWK.model.Contratante;
import br.com.sistemaWK.model.Formaspagamento;
import br.com.sistemaWK.model.Servicos;
import br.com.sistemaWK.model.Tiposervicos;
import br.com.sistemaWK.model.Vendas;
import br.com.sistemaWK.model.Vendascliente;
import br.com.sistemaWK.util.Mensagem;

@Named
@ViewScoped
public class CadVendasMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vendas vendas;
	private Cliente cliente;
	private Formaspagamento formaspagamento;
	private List<Formaspagamento> listaFormasPagamento;
	private List<Contasreceber> listaContasReceber;
	private Servicos servicos;
	private List<Servicos> listaServicos;
	private boolean trocarCliente = true;
	private String cpfContratante;
	private float valorServico;
	private String cargahoraria;
	private Contasreceber contasreceber;
	private float valorParcelar;
	private float valorRestante;
	private String cep;
	private String teste;
	private String descricaoFormaPagamento;
	private float valorFormaPagamento;
	private Contratante contratante;
	private String cpfCliente;
	private List<Tiposervicos> listaTipoServicos;
	private Tiposervicos tiposervicos;
	private String nomeConsultor;
	private List<Vendascliente> listaCliente;
	private float descontoFormaPagamento;
	private float descontoServico;
	private boolean addServico = false;
	private int quantidadeServico;
	private Cliente clienteFinanceiro;
	private Vendascliente vendasClienteFinanceiro;
	private boolean verificarContratantePF = true;
	private boolean verificarContratantePJ = false;

	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		vendas = (Vendas) session.getAttribute("vendas");
		session.removeAttribute("vendas");
		formaspagamento = new Formaspagamento();
		contasreceber = new Contasreceber();
		contasreceber.setFormapagamento("Boleto");
		contasreceber.setNparcela(1);
		cliente = new Cliente();
		cliente.setFinanceiro(false);
		vendasClienteFinanceiro = new Vendascliente();
		vendasClienteFinanceiro.setCliente(new Cliente());
		vendasClienteFinanceiro.getCliente().setFinanceiro(true);
		listaCliente = new ArrayList<Vendascliente>();
		if (vendas == null) {
			vendas = new Vendas();
			vendas.setDatavenda(new Date());
			vendas.setStatus("Não Pago");
			vendas.setCorstatus("red");
			contratante = new Contratante();
			contratante.setTipopessoa("PF");
			tiposervicos = new Tiposervicos();
			quantidadeServico = 1;
			listarTipoServicos();
		} else {
			contratante = vendas.getContratante();
			tiposervicos = vendas.getServicos().getTiposervicos();
			listarTipoServicos();
			servicos = vendas.getServicos();
			listarServicos();
			if (servicos.isConsultorvinculado()) {
				ConsultoresFacade consultoresFacade = new ConsultoresFacade();
				nomeConsultor = consultoresFacade.consultar(servicos.getIdconsultores()).getNome();
			} else {
				nomeConsultor = "";
			}
			buscarFormasPagamento();
			buscarContasReceber();
			verificarValores();
			listarClientes();
		}
	}

	public Vendas getVendas() {
		return vendas;
	}

	public void setVendas(Vendas vendas) {
		this.vendas = vendas;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Contratante getContratante() {
		return contratante;
	}

	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}

	public String getCpfContratante() {
		return cpfContratante;
	}

	public void setCpfContratante(String cpfContratante) {
		this.cpfContratante = cpfContratante;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public List<Tiposervicos> getListaTipoServicos() {
		return listaTipoServicos;
	}

	public void setListaTipoServicos(List<Tiposervicos> listaTipoServicos) {
		this.listaTipoServicos = listaTipoServicos;
	}

	public Tiposervicos getTiposervicos() {
		return tiposervicos;
	}

	public void setTiposervicos(Tiposervicos tiposervicos) {
		this.tiposervicos = tiposervicos;
	}

	public String getNomeConsultor() {
		return nomeConsultor;
	}

	public void setNomeConsultor(String nomeConsultor) {
		this.nomeConsultor = nomeConsultor;
	}

	public List<Vendascliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Vendascliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public float getDescontoFormaPagamento() {
		return descontoFormaPagamento;
	}

	public void setDescontoFormaPagamento(float descontoFormaPagamento) {
		this.descontoFormaPagamento = descontoFormaPagamento;
	}

	public float getDescontoServico() {
		return descontoServico;
	}

	public void setDescontoServico(float descontoServico) {
		this.descontoServico = descontoServico;
	}

	public boolean isAddServico() {
		return addServico;
	}

	public void setAddServico(boolean addServico) {
		this.addServico = addServico;
	}

	public int getQuantidadeServico() {
		return quantidadeServico;
	}

	public void setQuantidadeServico(int quantidadeServico) {
		this.quantidadeServico = quantidadeServico;
	}

	public Cliente getClienteFinanceiro() {
		return clienteFinanceiro;
	}

	public void setClienteFinanceiro(Cliente clienteFinanceiro) {
		this.clienteFinanceiro = clienteFinanceiro;
	}

	public Vendascliente getVendasClienteFinanceiro() {
		return vendasClienteFinanceiro;
	}

	public void setVendasClienteFinanceiro(Vendascliente vendasClienteFinanceiro) {
		this.vendasClienteFinanceiro = vendasClienteFinanceiro;
	}

	public boolean isVerificarContratantePF() {
		return verificarContratantePF;
	}

	public void setVerificarContratantePF(boolean verificarContratantePF) {
		this.verificarContratantePF = verificarContratantePF;
	}

	public boolean isVerificarContratantePJ() {
		return verificarContratantePJ;
	}

	public void setVerificarContratantePJ(boolean verificarContratantePJ) {
		this.verificarContratantePJ = verificarContratantePJ;
	}

	public void listarServicos() {
		if (tiposervicos != null) {
			ServicosFacade servicosFacade = new ServicosFacade();
			listaServicos = servicosFacade.listar(
					"Select s From Servicos s WHERE s.tiposervicos.idtiposervicos=" + tiposervicos.getIdtiposervicos());
			if (listaServicos == null) {
				listaServicos = new ArrayList<Servicos>();
			}
		}
	}

	public void buscarCliente() {
		ClienteFacade clienteFacade = new ClienteFacade();
		cliente = clienteFacade.consultarCPF(cpfCliente);
		if (cliente == null) {
			cliente = new Cliente();
			Mensagem.lancarMensagemInfo("Atenção", "Aluno não encontrado \n Inseria dados do aluno manualmente!!");
		} else {
			this.cep = cliente.getCep();
			Mensagem.lancarMensagemInfo("Atenção", "Aluno encontrado!!");
		}
	}

	public void buscarContratante() {
		ContratanteFacade contratanteFacade = new ContratanteFacade();
		contratante = contratanteFacade.consultarCPFCPNJ(cpfContratante);
		if (contratante == null) {
			contratante = new Contratante();
			contratante.setCpfcnpj(cpfContratante);
			Mensagem.lancarMensagemInfo("Atenção", "Contratante não encontrado \n Inseria dados do manualmente!!");
		} else {
			this.cep = cliente.getCep();
			Mensagem.lancarMensagemInfo("Atenção", "Contratante encontrado!!");
		}
	}

	public void adicionarFormaPagamento() {
		listaFormasPagamento = new ArrayList<Formaspagamento>();
		quantidadeServico = 1;
		if (descricaoFormaPagamento != null) {
			if (!addServico) {
				quantidadeServico = 1;
			}
			formaspagamento = new Formaspagamento();
			formaspagamento.setDescricao(descricaoFormaPagamento);
			formaspagamento.setValor(valorFormaPagamento);
			formaspagamento.setServico(addServico);
			formaspagamento.setDesconto(descontoFormaPagamento);
			formaspagamento.setValorliquido(valorFormaPagamento * quantidadeServico);
			formaspagamento.setValorliquido(formaspagamento.getValorliquido() - descontoFormaPagamento);
			formaspagamento.setQuantidade(quantidadeServico);
			valorRestante = formaspagamento.getValorliquido();
			vendas.setValorvenda(formaspagamento.getValorliquido());
			valorParcelar = valorRestante;
			listaFormasPagamento.add(formaspagamento);
			addServico = false;
			descricaoFormaPagamento = "";
			valorFormaPagamento = 0.0f;
			descontoFormaPagamento = 0.0f;
		}
	}

	public void excluirFormaPagamento(String ilinha) {
		int linha = Integer.parseInt(ilinha);
		if (linha >= 0) {
			if (listaFormasPagamento.get(linha).getIdformaspagamento() != null) {
				FormasPagamentoFacade formasPagamentoFacade = new FormasPagamentoFacade();
				formasPagamentoFacade.excluir(listaFormasPagamento.get(linha).getIdformaspagamento());
			}
			valorRestante = valorRestante - listaFormasPagamento.get(linha).getValorliquido();
			vendas.setValorvenda(vendas.getValorvenda() - listaFormasPagamento.get(linha).getValorliquido());
			listaFormasPagamento.remove(linha);
		}
	}

	public void buscarendereco() {
		ControladorCEPBean cep = new ControladorCEPBean();
		cep.setCep(this.cep);
		EnderecoBean endereco = cep.carregarEndereco();
		if (endereco.getLogradouro() != null) {
			cliente.setCep(this.cep);
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
			cliente.setLogradouro(tipo + " " + logradouro);
			teste = logradouro;
			Mensagem.lancarMensagemInfo("Atenção", "CEP encontrado com sucesso");
		}
	}

	public void dadosProdutos() {
		if (servicos != null) {
			if (!servicos.getTiposervicos().isDadoscliente()) {
				listaCliente = new ArrayList<Vendascliente>();
			}
			valorServico = servicos.getValor();
			cargahoraria = servicos.getCargahoraria();
			descricaoFormaPagamento = servicos.getNomeservicos();
			valorFormaPagamento = servicos.getValor();
			descontoServico = 0.0f;
			if (servicos.isConsultorvinculado()) {
				ConsultoresFacade consultoresFacade = new ConsultoresFacade();
				nomeConsultor = consultoresFacade.consultar(servicos.getIdconsultores()).getNome();
			} else {
				nomeConsultor = "";
			}
			addServico = true;
			if (listaCliente.size() > 1) {
				quantidadeServico = listaCliente.size();
			} else {
				quantidadeServico = 1;
			}
			adicionarFormaPagamento();
		}
	}

	public void alterarFormaPagamento() {
		if (listaFormasPagamento == null) {
			listaFormasPagamento = new ArrayList<Formaspagamento>();
		}
		for (int i = 0; i < listaFormasPagamento.size(); i++) {
			if (listaFormasPagamento.get(i).isServico()) {
				vendas.setValorvenda(vendas.getValorvenda() - listaFormasPagamento.get(i).getValorliquido());
				valorRestante = valorRestante - listaFormasPagamento.get(i).getValorliquido();
				valorParcelar = valorParcelar - listaFormasPagamento.get(i).getValorliquido();
				listaFormasPagamento.get(i).setValor(valorServico);
				listaFormasPagamento.get(i).setDesconto(descontoServico);
				listaFormasPagamento.get(i).setQuantidade(quantidadeServico);
				listaFormasPagamento.get(i).setValorliquido(valorServico * quantidadeServico);
				listaFormasPagamento.get(i)
						.setValorliquido(listaFormasPagamento.get(i).getValorliquido() - descontoServico);
				valorRestante = valorRestante + listaFormasPagamento.get(i).getValorliquido();
				vendas.setValorvenda(vendas.getValorvenda() + listaFormasPagamento.get(i).getValorliquido());
				valorParcelar = valorParcelar + valorRestante;
			}
		}
	}

	public void calcularParcelas() {
		if (contasreceber != null) {
			if (valorParcelar > 0.0f && contasreceber.getNparcela() > 0) {
				if (valorParcelar <= valorRestante) {
					contasreceber.setValorparcela(valorParcelar / contasreceber.getNparcela());
					adicionarContas();
				} else {
					Mensagem.lancarMensagemInfo("Atenção", "Valor a Parcelar maior que o valor total da venda");
				}
			} else {
				Mensagem.lancarMensagemInfo("Atenção", "Digite o valor a parcelar, junto com o número de parcelas");
			}
		}
	}

	public void adicionarContas() {
		if (listaContasReceber == null) {
			listaContasReceber = new ArrayList<Contasreceber>();
		}
		if (contasreceber != null) {
			float valorparcela = contasreceber.getValorparcela();
			int nParcela = contasreceber.getNparcela();
			String forma = contasreceber.getFormapagamento();
			boolean segundavez = false;
			Date datavencimento = contasreceber.getDatavencimento();
			if (contasreceber.getValorparcela() > 0 && contasreceber.getDatavencimento() != null
					&& contasreceber.getNparcela() > 0) {
				for (int i = 1; i <= nParcela; i++) {
					if (segundavez) {
						datavencimento = gerarParcelas(nParcela, datavencimento);
					}
					contasreceber.setDatavencimento(datavencimento);
					contasreceber.setFormapagamento(forma);
					contasreceber.setNparcela(nParcela);
					contasreceber.setNumeroparcela(i);
					contasreceber.setCorstatus("red");
					contasreceber.setStatus("x-circle");
					contasreceber.setPago(false);
					contasreceber.setValorparcela(valorparcela);
					if (vendas.getIdvendas() != null) {
						contasreceber.setVendas(vendas);
					}
					listaContasReceber.add(contasreceber);
					valorRestante = valorRestante - contasreceber.getValorparcela();
					valorParcelar = valorRestante;
					contasreceber = new Contasreceber();
					segundavez = true;
				}
			}
			segundavez = false;
			valorParcelar = 0.0f;
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
			salvarContratante();
			vendas.setContratante(contratante);
			vendas.setServicos(servicos);
			VendasFacade vendasFacade = new VendasFacade();
			vendas = vendasFacade.salvar(vendas);
			salvarCliente();
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

		if (valorRestante < 0.00f) {
			Mensagem.lancarMensagemInfo("Atenção", "Valor restante de pagamento consta negativo!!");
			return false;
		}

		if (valorRestante > 0.01f) {
			Mensagem.lancarMensagemInfo("Atençao", "Valor restante ainda consta em aberto para pagamento!!");
			return false;
		}

		if (cliente == null) {
			Mensagem.lancarMensagemInfo("Atenção", "Favor inserir um Aluno a esta venda!!");
			return false;
		}

		if (servicos == null) {
			Mensagem.lancarMensagemInfo("Atenção", "Favor inserir algum produto");
			return false;
		}

		if (contratante.getCpfcnpj() == null || contratante.getCpfcnpj().length() <= 0) {
			Mensagem.lancarMensagemInfo("Atenção", "Favor informar o contratante!!");
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
			valorRestante = valorRestante + listaFormasPagamento.get(i).getValorliquido();
		}

		for (int i = 0; i < listaContasReceber.size(); i++) {
			valorRestante = valorRestante - listaContasReceber.get(i).getValorparcela();
		}
	}

	public void salvarCliente() {
		VendasClienteDao vendasClienteDao = new VendasClienteDao();
		for (int i = 0; i < listaCliente.size(); i++) {
			listaCliente.get(i).setVendas(vendas);
			vendasClienteDao.salvar(listaCliente.get(i));
		}
		if (vendasClienteFinanceiro != null) {
			if (vendasClienteFinanceiro.getVendas() == null) {
				vendasClienteFinanceiro.setVendas(vendas);
			}
			vendasClienteDao.salvar(vendasClienteFinanceiro);
		}
	}

	public void buscarContasReceber() {
		if (vendas != null) {
			ContasReceberFacade contasReceberFacade = new ContasReceberFacade();
			listaContasReceber = contasReceberFacade
					.listar("Select c From Contasreceber c WHERE c.vendas.idvendas=" + vendas.getIdvendas());
			if (listaContasReceber == null) {
				listaContasReceber = new ArrayList<Contasreceber>();
			}
		}
	}

	public void buscarFormasPagamento() {
		if (vendas != null) {
			FormasPagamentoFacade formasPagamentoFacade = new FormasPagamentoFacade();
			listaFormasPagamento = formasPagamentoFacade
					.listar("Select f From Formaspagamento f WHERE f.vendas.idvendas=" + vendas.getIdvendas());
			if (listaFormasPagamento == null) {
				listaFormasPagamento = new ArrayList<Formaspagamento>();
			}
			buscarServico();
		}
	}

	public void listarTipoServicos() {
		TipoServicosFacade tipoServicosFacade = new TipoServicosFacade();
		listaTipoServicos = tipoServicosFacade.listar("Select t From Tiposervicos t");
		if (listaTipoServicos == null) {
			listaTipoServicos = new ArrayList<Tiposervicos>();
		}
	}

	public void adicionarCliente() {
		if (cliente != null) {
			if (validarDadosCliente()) {
				cliente.setCep(this.cep);
				this.cep = "";
				cliente.setCpf(cpfCliente);
				cpfCliente = "";
				Vendascliente vendascliente = new Vendascliente();
				vendascliente.setCliente(cliente);
				listaCliente.add(vendascliente);
				if (listaCliente.size() > 1) {
					quantidadeServico = quantidadeServico + 1;
				}
				alterarFormaPagamento();
				cliente = new Cliente();
				cliente.setFinanceiro(false);
			}
		}
	}

	public boolean validarDadosCliente() {
		if (cliente.getNome() != null && cliente.getNome().length() <= 0) {
			Mensagem.lancarMensagemInfo("Atenção", "Favor informar nome do cliente");
			return false;
		}

		if (cliente.getCpf() != null && cliente.getCpf().length() <= 0) {
			Mensagem.lancarMensagemInfo("Atenção", "Favor informar CPF do cliente");
			return false;
		}
		return true;
	}

	public void excluirCliente(String ilinha) {
		int linha = Integer.parseInt(ilinha);
		if (linha >= 0) {
			if (vendas != null && vendas.getIdvendas() != null) {
				VendasClienteFacade vendasClienteFacade = new VendasClienteFacade();
				vendasClienteFacade.excluir(listaCliente.get(linha).getVendas().getIdvendas(),
						listaCliente.get(linha).getCliente().getIdcliente());
			}
			listaCliente.remove(linha);
			quantidadeServico = quantidadeServico - 1;
			alterarFormaPagamento();
		}
	}

	public void listarClientes() {
		VendasClienteFacade vendasClienteFacade = new VendasClienteFacade();
		listaCliente = vendasClienteFacade
				.listar("Select v From Vendascliente v Where v.vendas.idvendas=" + vendas.getIdvendas()
						+ " and v.cliente.financeiro=false");
		if (listaCliente == null) {
			listaCliente = new ArrayList<Vendascliente>();
		}
		List<Vendascliente> listaFinanceiro = vendasClienteFacade.listar("Select v From Vendascliente "
				+ "v Where v.vendas.idvendas=" + vendas.getIdvendas()
				+ " and v.cliente.financeiro=true");
		if (listaFinanceiro == null) {
			listaFinanceiro = new ArrayList<Vendascliente>();
		}
		for (int i = 0; i < listaFinanceiro.size(); i++) {
			vendasClienteFinanceiro = listaFinanceiro.get(i);
		}
	}

	public Date gerarParcelas(int nParcela, Date datavencimento) {
		String data = Formatacao.ConvercaoDataPadrao(datavencimento);
		String mes = data.substring(3, 5);
		String ano = data.substring(6, 10);
		String dia = data.substring(0, 2);
		int cmes = Integer.parseInt(mes);
		int cano = Integer.parseInt(ano);
		int cdia = Integer.parseInt(dia);

		if (cmes == 12) {
			cmes = 1;
			cano = cano + 1;
		} else {
			cmes = cmes + 1;
		}

		if (cmes == 2) {
			if (cdia > 28) {
				cdia = 1;
				cmes = cmes + 1;
			}
		}

		if (cmes < 10) {
			data = String.valueOf(cdia) + "/" + "0" + String.valueOf(cmes) + "/" + String.valueOf(cano);
		} else {
			data = String.valueOf(cdia) + "/" + String.valueOf(cmes) + "/" + String.valueOf(cano);
		}
		Date cdata = Formatacao.ConvercaoStringDataBrasil(data);
		return cdata;
	}

	public void salvarContratante() {
		if (contratante.getCpfcnpj() != null && contratante.getCpfcnpj().length() > 0) {
			ContratanteFacade contratanteFacade = new ContratanteFacade();
			contratante = contratanteFacade.salvar(contratante);
		}
	}

	public void buscarServico() {
		for (int i = 0; i < listaFormasPagamento.size(); i++) {
			if (listaFormasPagamento.get(i).isServico()) {
				valorServico = listaFormasPagamento.get(i).getValor();
				descontoServico = listaFormasPagamento.get(i).getDesconto();
				quantidadeServico = listaFormasPagamento.get(i).getQuantidade();
			}
		}
	}

	public void trocarContratante() {
		if (contratante.getTipopessoa().equalsIgnoreCase("PF")) {
			verificarContratantePF = true;
			verificarContratantePJ = false;
		} else if (contratante.getTipopessoa().equalsIgnoreCase("PJ")) {
			verificarContratantePF = false;
			verificarContratantePJ = true;
		}
	}

}
