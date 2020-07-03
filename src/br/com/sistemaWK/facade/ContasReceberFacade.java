package br.com.sistemaWK.facade;

import java.util.List;

import br.com.sistemaWK.dao.ContasReceberDao;
import br.com.sistemaWK.model.Contasreceber;

public class ContasReceberFacade {
	
private ContasReceberDao ContasReceberDao;
	
	public Contasreceber salvar(Contasreceber Contasreceber) {
		 ContasReceberDao = new ContasReceberDao();
		return ContasReceberDao.salvar(Contasreceber);
	}

	public Contasreceber consultar(int idContasreceber) {
		ContasReceberDao = new ContasReceberDao();
		return ContasReceberDao.consultar(idContasreceber);
	}

	public List<Contasreceber> listar(String sql) {
		ContasReceberDao = new ContasReceberDao();
		return ContasReceberDao.lista(sql);
	}
}
