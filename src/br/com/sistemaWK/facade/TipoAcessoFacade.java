package br.com.sistemaWK.facade;

import java.util.List;

import br.com.sistemaWK.dao.TipoAcessoDao;
import br.com.sistemaWK.model.Tipoacesso;

public class TipoAcessoFacade {

	private TipoAcessoDao tipoAcessoDao;

	public Tipoacesso salvar(Tipoacesso tipoacesso) {
		 tipoAcessoDao = new TipoAcessoDao();
		return tipoAcessoDao.salvar(tipoacesso);
	} 

	public Tipoacesso consultar(int idacesso) {
		tipoAcessoDao = new TipoAcessoDao();
		return tipoAcessoDao.consultar(idacesso);
	}

	public List<Tipoacesso> listar(String sql) {
		tipoAcessoDao = new TipoAcessoDao();
		return tipoAcessoDao.lista(sql);
	}
}
