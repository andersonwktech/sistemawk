package br.com.sistemaWK.facade;

import java.util.List;

import br.com.sistemaWK.dao.ContasPagarDao;
import br.com.sistemaWK.model.Contaspagar;

public class ContasPagarFacade {

	ContasPagarDao contasPagarDao;
	
	public Contaspagar salvar(Contaspagar contaspagar) {
		 contasPagarDao = new ContasPagarDao();
		return contasPagarDao.salvar(contaspagar);
	}

	public Contaspagar consultar(int idContasreceber) {
		contasPagarDao = new ContasPagarDao();
		return contasPagarDao.consultar(idContasreceber);
	}

	public List<Contaspagar> listar(String sql) {
		contasPagarDao = new ContasPagarDao();
		return contasPagarDao.lista(sql);
	}
	
	
	public void excluir(int idContasPagar) {
		contasPagarDao = new ContasPagarDao();
		contasPagarDao.excluir(idContasPagar);
	}
}
