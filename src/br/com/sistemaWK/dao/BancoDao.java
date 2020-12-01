package br.com.sistemaWK.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sistemaWK.model.Banco;
import br.com.sistemaWK.util.ConectionFactory;

public class BancoDao {

	public Banco salvar(Banco banco) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		banco = manager.merge(banco);
		tx.commit();
		manager.close();
		return banco;
	}

	public Banco consultar(int idbanco) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Query q = manager.createQuery("select b from Banco b where b.idbanco=" + idbanco);
		Banco banco = null;
		if (q.getResultList().size() > 0) {
			banco = (Banco) q.getResultList().get(0);
		}
		tx.commit();
		manager.close();
		return banco;
	}

	@SuppressWarnings("unchecked")
	public List<Banco> lista(String sql) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql);
		List<Banco> lista = q.getResultList();
		manager.close();
		return lista;
	}
	
	
	public void excluir(int idbanco) {
    	EntityManager manager;
    	manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
        Query q = manager.createQuery("Select b from Banco b where b.idbanco=" + idbanco);
        if (q.getResultList().size()>0){
        	Banco banco = (Banco) q.getResultList().get(0);
            manager.remove(banco);
        }
        tx.commit();
        manager.close();
    }
}
