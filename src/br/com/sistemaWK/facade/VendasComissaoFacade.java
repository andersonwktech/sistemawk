package br.com.sistemaWK.facade;

import java.util.List;

import br.com.sistemaWK.dao.VendasComissaoDao;
import br.com.sistemaWK.model.Vendascomissao;

public class VendasComissaoFacade {

private VendasComissaoDao VendasComissaoDao;
	
	public Vendascomissao salvar(Vendascomissao Vendascomissao) {
		 VendasComissaoDao = new VendasComissaoDao();
		return VendasComissaoDao.salvar(Vendascomissao);
	}

	public Vendascomissao consultar(int idVendascomissao) {
		VendasComissaoDao = new VendasComissaoDao();
		return VendasComissaoDao.consultar(idVendascomissao);
	}

	public List<Vendascomissao> listar(String sql) {
		VendasComissaoDao = new VendasComissaoDao();
		return VendasComissaoDao.lista(sql);
	}
}
