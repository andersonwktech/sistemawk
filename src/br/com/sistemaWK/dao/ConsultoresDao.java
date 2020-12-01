package br.com.sistemaWK.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sistemaWK.model.Consultores;
import br.com.sistemaWK.util.ConectionFactory;

public class ConsultoresDao {

	public Consultores salvar(Consultores consultores) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		consultores = manager.merge(consultores);
		tx.commit();
		manager.close();
		return consultores;
	}

	public Consultores consultar(int idconsultores) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Query q = manager.createQuery("select c from Consultores c where c.idconsultores=" + idconsultores);
		Consultores consultores = null;
		if (q.getResultList().size() > 0) {
			consultores = (Consultores) q.getResultList().get(0);
		}
		tx.commit();
		manager.close();
		return consultores;
	}

	@SuppressWarnings("unchecked")
	public List<Consultores> lista(String sql) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql);
		List<Consultores> lista = q.getResultList();
		manager.close();
		return lista;
	}
}
