package br.com.sistemaWK.facade;

import java.util.List;

import br.com.sistemaWK.dao.ProfessoresDao;
import br.com.sistemaWK.model.Professores;


public class ProfessoresFacade {

private ProfessoresDao ProfessoresDao;
	
	public Professores salvar(Professores Professores) {
		 ProfessoresDao = new ProfessoresDao();
		return ProfessoresDao.salvar(Professores);
	}

	public Professores consultar(int idProfessores) {
		ProfessoresDao = new ProfessoresDao();
		return ProfessoresDao.consultar(idProfessores);
	}

	public List<Professores> listar(String sql) {
		ProfessoresDao = new ProfessoresDao();
		return ProfessoresDao.lista(sql);
	}
}
