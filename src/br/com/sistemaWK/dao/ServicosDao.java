package br.com.sistemaWK.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sistemaWK.model.Servicos;
import br.com.sistemaWK.util.ConectionFactory;

public class ServicosDao {

	public Servicos salvar(Servicos servicos) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		servicos = manager.merge(servicos);
		tx.commit();
		manager.close();
		return servicos;
	}

	public Servicos consultar(int idServicos) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Query q = manager.createQuery("select s from Servicos s where s.idservicos=" + idServicos);
		Servicos servicos = null;
		if (q.getResultList().size() > 0) {
			servicos = (Servicos) q.getResultList().get(0);
		}
		tx.commit();
		manager.close();
		return servicos;
	}

	@SuppressWarnings("unchecked")
	public List<Servicos> lista(String sql) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql);
		List<Servicos> lista = q.getResultList();
		manager.close();
		return lista;
	}
}
