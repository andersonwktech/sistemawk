package br.com.sistemaWK.facade;

import java.util.List;

import br.com.sistemaWK.dao.AcessoDao;
import br.com.sistemaWK.model.Acesso;

public class AcessoFacade {

private AcessoDao acessoDao;
	
	public Acesso salvar(Acesso acesso) {
		 acessoDao = new AcessoDao();
		return acessoDao.salvar(acesso);
	}

	public Acesso consultar(int idacesso) {
		acessoDao = new AcessoDao();
		return acessoDao.consultar(idacesso);
	}

	public List<Acesso> listar(String sql) {
		acessoDao = new AcessoDao();
		return acessoDao.lista(sql);
	}
}
