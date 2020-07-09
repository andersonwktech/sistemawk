package br.com.sistemaWK.facade;

import java.util.List;

import br.com.sistemaWK.dao.ContratanteDao;
import br.com.sistemaWK.model.Contratante;


public class ContratanteFacade {

	ContratanteDao contratanteDao;
	
	public Contratante salvar(Contratante contratante) {
		contratanteDao = new ContratanteDao();
		return contratanteDao.salvar(contratante);
	}

	public Contratante consultar(int idcontratante) {
		contratanteDao = new ContratanteDao();
		return contratanteDao.consultar(idcontratante);
	}

	public List<Contratante> listar(String sql) {
		contratanteDao = new ContratanteDao();
		return contratanteDao.lista(sql);
	}
}
