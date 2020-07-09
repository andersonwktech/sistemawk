package br.com.sistemaWK.facade;

import java.util.List;

import br.com.sistemaWK.dao.ConsultoresDao;
import br.com.sistemaWK.model.Consultores;


public class ConsultoresFacade {

private ConsultoresDao consultoresDao;
	
	public Consultores salvar(Consultores consultores) {
		 consultoresDao = new ConsultoresDao();
		return consultoresDao.salvar(consultores);
	}

	public Consultores consultar(int idconsultores) {
		consultoresDao = new ConsultoresDao();
		return consultoresDao.consultar(idconsultores);
	}

	public List<Consultores> listar(String sql) {
		consultoresDao = new ConsultoresDao();
		return consultoresDao.lista(sql);
	}
}
