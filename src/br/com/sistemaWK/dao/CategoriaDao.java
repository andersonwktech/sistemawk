package br.com.sistemaWK.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sistemaWK.model.Categoria;
import br.com.sistemaWK.util.ConectionFactory;

public class CategoriaDao {

	public Categoria salvar(Categoria categoria) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		categoria = manager.merge(categoria);
		tx.commit();
		manager.close();
		return categoria;
	}

	public Categoria consultar(int idcategoria) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Query q = manager.createQuery("select c from Categoria c where c.idcategoria=" + idcategoria);
		Categoria categoria = null;
		if (q.getResultList().size() > 0) {
			categoria = (Categoria) q.getResultList().get(0);
		}
		tx.commit();
		manager.close();
		return categoria;
	}

	@SuppressWarnings("unchecked")
	public List<Categoria> lista(String sql) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql);
		List<Categoria> lista = q.getResultList();
		manager.close();
		return lista;
	}
	
	
	public void excluir(int idcategoria) {
    	EntityManager manager;
    	manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
        Query q = manager.createQuery("Select c from Categoria c where c.idcategoria=" + idcategoria);
        if (q.getResultList().size()>0){
        	Categoria categoria = (Categoria) q.getResultList().get(0);
            manager.remove(categoria);
        }
        tx.commit();
        manager.close();
    }
}
