package br.com.sistemaWK.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sistemaWK.model.Professores;
import br.com.sistemaWK.util.ConectionFactory;

public class ProfessoresDao {

	public Professores salvar(Professores Professores) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Professores = manager.merge(Professores);
		tx.commit();
		manager.close();
		return Professores;
	}

	public Professores consultar(int idProfessores) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Query q = manager.createQuery("select p from Professores p where p.idprofessores=" + idProfessores);
		Professores Professores = null;
		if (q.getResultList().size() > 0) {
			Professores = (Professores) q.getResultList().get(0);
		}
		tx.commit();
		manager.close();
		return Professores;
	}

	@SuppressWarnings("unchecked")
	public List<Professores> lista(String sql) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql);
		List<Professores> lista = q.getResultList();
		manager.close();
		return lista;
	}
}
