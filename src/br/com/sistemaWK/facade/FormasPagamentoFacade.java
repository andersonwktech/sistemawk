package br.com.sistemaWK.facade;

import java.util.List;

import br.com.sistemaWK.dao.FormasPagamentoDao;
import br.com.sistemaWK.model.Formaspagamento;


public class FormasPagamentoFacade {
	
	FormasPagamentoDao formasPagamentoDao;

	public Formaspagamento salvar(Formaspagamento formaspagamento) {
		 formasPagamentoDao = new FormasPagamentoDao();
		return formasPagamentoDao.salvar(formaspagamento);
	}

	public Formaspagamento consultar(int idFormasPagamento) {
		formasPagamentoDao = new FormasPagamentoDao();
		return formasPagamentoDao.consultar(idFormasPagamento);
	}

	public List<Formaspagamento> listar(String sql) {
		formasPagamentoDao = new FormasPagamentoDao();
		return formasPagamentoDao.lista(sql);
	}
	
	public void excluir(int idFormaspagamento) {
		formasPagamentoDao = new FormasPagamentoDao();
		formasPagamentoDao.excluir(idFormaspagamento);
	}
}
