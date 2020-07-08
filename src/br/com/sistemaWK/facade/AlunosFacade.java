package br.com.sistemaWK.facade;

import java.util.List;

import br.com.sistemaWK.dao.AlunosDao;
import br.com.sistemaWK.model.Alunos;

public class AlunosFacade {

private AlunosDao AlunosDao;
	
	public Alunos salvar(Alunos Alunos) {
		 AlunosDao = new AlunosDao();
		return AlunosDao.salvar(Alunos);
	}

	public Alunos consultar(int idAlunos) {
		AlunosDao = new AlunosDao();
		return AlunosDao.consultar(idAlunos);
	}

	public List<Alunos> listar(String sql) {
		AlunosDao = new AlunosDao();
		return AlunosDao.lista(sql);
	}
	
	public Alunos consultarCPF(String cpfAluno) {
		AlunosDao = new AlunosDao();
		return AlunosDao.consultarCPF(cpfAluno);
	}
}
