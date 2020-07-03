package br.com.sistemaWK.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sistemaWK.model.Vendas;
import br.com.sistemaWK.util.ConectionFactory;

public class VendasDao {

	
	public Vendas salvar(Vendas Vendas) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Vendas = manager.merge(Vendas);
		tx.commit();
		manager.close();
		return Vendas;
	}

	public Vendas consultar(int idVendas) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Query q = manager.createQuery("select v from Vendas v where v.idvendas=" + idVendas);
		Vendas Vendas = null;
		if (q.getResultList().size() > 0) {
			Vendas = (Vendas) q.getResultList().get(0);
		}
		tx.commit();
		manager.close();
		return Vendas;
	}

	@SuppressWarnings("unchecked")
	public List<Vendas> lista(String sql) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql);
		List<Vendas> lista = q.getResultList();
		manager.close();
		return lista;
	}
}
