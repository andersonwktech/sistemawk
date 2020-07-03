package br.com.sistemaWK.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sistemaWK.model.Vendascomissao;
import br.com.sistemaWK.util.ConectionFactory;

public class VendasComissaoDao {

	public Vendascomissao salvar(Vendascomissao Vendascomissao) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Vendascomissao = manager.merge(Vendascomissao);
		tx.commit();
		manager.close();
		return Vendascomissao;
	}

	public Vendascomissao consultar(int idVendascomissao) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Query q = manager.createQuery("select v from Vendascomissao v where v.idvendascomissao=" + idVendascomissao);
		Vendascomissao Vendascomissao = null;
		if (q.getResultList().size() > 0) {
			Vendascomissao = (Vendascomissao) q.getResultList().get(0);
		}
		tx.commit();
		manager.close();
		return Vendascomissao;
	}

	@SuppressWarnings("unchecked")
	public List<Vendascomissao> lista(String sql) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql);
		List<Vendascomissao> lista = q.getResultList();
		manager.close();
		return lista;
	}
}
