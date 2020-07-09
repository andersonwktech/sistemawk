package br.com.sistemaWK.facade;

import java.util.List;

import br.com.sistemaWK.dao.TipoServicosDao;
import br.com.sistemaWK.model.Tiposervicos;


public class TipoServicosFacade {

	TipoServicosDao tipoServicosDao;
	
	public Tiposervicos salvar(Tiposervicos tiposervicos) {
		tipoServicosDao = new TipoServicosDao();
		return tipoServicosDao.salvar(tiposervicos);
	}

	public Tiposervicos consultar(int idtiposervicos) {
		tipoServicosDao = new TipoServicosDao();
		return tipoServicosDao.consultar(idtiposervicos);
	}

	public List<Tiposervicos> listar(String sql) {
		tipoServicosDao = new TipoServicosDao();
		return tipoServicosDao.lista(sql);
	}
}
