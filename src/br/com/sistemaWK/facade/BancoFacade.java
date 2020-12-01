package br.com.sistemaWK.facade;

import java.util.List;

import br.com.sistemaWK.dao.BancoDao;
import br.com.sistemaWK.model.Banco;

public class BancoFacade {

	BancoDao bancoDao;
	
	
	public Banco salvar(Banco banco) {
		 bancoDao = new BancoDao();
		return bancoDao.salvar(banco);
	}

	public Banco consultar(int idbanco) {
		bancoDao = new BancoDao();
		return bancoDao.consultar(idbanco);
	}

	public List<Banco> listar(String sql) {
		bancoDao = new BancoDao();
		return bancoDao.lista(sql);
	}
}
