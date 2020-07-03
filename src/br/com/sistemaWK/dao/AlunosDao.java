package br.com.sistemaWK.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sistemaWK.model.Alunos;
import br.com.sistemaWK.util.ConectionFactory;

public class AlunosDao {

	
	public Alunos salvar(Alunos Alunos) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Alunos = manager.merge(Alunos);
		tx.commit();
		manager.close();
		return Alunos;
	}

	public Alunos consultar(int idAlunos) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Query q = manager.createQuery("select a from Alunos a where a.idalunos=" + idAlunos);
		Alunos Alunos = null;
		if (q.getResultList().size() > 0) {
			Alunos = (Alunos) q.getResultList().get(0);
		}
		tx.commit();
		manager.close();
		return Alunos;
	}

	@SuppressWarnings("unchecked")
	public List<Alunos> lista(String sql) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql);
		List<Alunos> lista = q.getResultList();
		manager.close();
		return lista;
	}
}
