package br.com.sistemaWK.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sistemaWK.model.Fornecedor;
import br.com.sistemaWK.util.ConectionFactory;

public class FornecedorDao {

	public Fornecedor salvar(Fornecedor fornecedor) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		fornecedor = manager.merge(fornecedor);
		tx.commit();
		manager.close();
		return fornecedor;
	}

	public Fornecedor consultar(int idfornecedor) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Query q = manager.createQuery("select f from Fornecedor f where f.idfornecedor=" + idfornecedor);
		Fornecedor fornecedor = null;
		if (q.getResultList().size() > 0) {
			fornecedor = (Fornecedor) q.getResultList().get(0);
		}
		tx.commit();
		manager.close();
		return fornecedor;
	}

	@SuppressWarnings("unchecked")
	public List<Fornecedor> lista(String sql) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql);
		List<Fornecedor> lista = q.getResultList();
		manager.close();
		return lista;
	}
	
	
	public void excluir(int idfornecedor) {
    	EntityManager manager;
    	manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
        Query q = manager.createQuery("Select f from Fornecedor f where f.idfornecedor=" + idfornecedor);
        if (q.getResultList().size()>0){
        	Fornecedor banco = (Fornecedor) q.getResultList().get(0);
            manager.remove(banco);
        }
        tx.commit();
        manager.close();
    }
}
