package br.com.sistemaWK.facade;

import java.util.List;

import br.com.sistemaWK.dao.ServicosDao;
import br.com.sistemaWK.model.Servicos;

public class ServicosFacade {

private ServicosDao servicosDao;
	
	public Servicos salvar(Servicos servicos) {
		 servicosDao = new ServicosDao();
		return servicosDao.salvar(servicos);
	}

	public Servicos consultar(int idServicos) {
		servicosDao = new ServicosDao();
		return servicosDao.consultar(idServicos);
	}

	public List<Servicos> listar(String sql) {
		servicosDao = new ServicosDao();
		return servicosDao.lista(sql);
	}
}
