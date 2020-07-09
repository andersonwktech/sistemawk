package br.com.sistemaWK.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sistemaWK.model.Contratante;
import br.com.sistemaWK.util.ConectionFactory;

public class ContratanteDao {
	
	
	public Contratante salvar(Contratante contratante) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		contratante = manager.merge(contratante);
		tx.commit();
		manager.close();
		return contratante;
	}

	public Contratante consultar(int idcontratante) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Query q = manager.createQuery("select c from Contratante c where c.idcontratante=" + idcontratante);
		Contratante contratante = null;
		if (q.getResultList().size() > 0) {
			contratante = (Contratante) q.getResultList().get(0);
		}
		tx.commit();
		manager.close();
		return contratante;
	}

	@SuppressWarnings("unchecked")
	public List<Contratante> lista(String sql) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql);
		List<Contratante> lista = q.getResultList();
		manager.close();
		return lista;
	}
	
	public void excluir(int idcontratante) {
    	EntityManager manager;
    	manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
        Query q = manager.createQuery("Select c from Contratante c where c.idcontratante=" + idcontratante);
        if (q.getResultList().size()>0){
        	Contratante contratante = (Contratante) q.getResultList().get(0);
            manager.remove(contratante);
        }
        tx.commit();
        manager.close();
    }

}
