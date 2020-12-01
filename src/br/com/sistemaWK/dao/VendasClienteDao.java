package br.com.sistemaWK.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sistemaWK.model.Vendascliente;
import br.com.sistemaWK.util.ConectionFactory;

public class VendasClienteDao {

	
	public Vendascliente salvar(Vendascliente vendascliente) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		vendascliente = manager.merge(vendascliente);
		tx.commit();
		manager.close();
		return vendascliente;
	}

	public Vendascliente consultar(int idvendascliente) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Query q = manager.createQuery("select v from Vendascliente v where v.idvendascliente=" + idvendascliente);
		Vendascliente vendascliente = null;
		if (q.getResultList().size() > 0) {
			vendascliente = (Vendascliente) q.getResultList().get(0);
		}
		tx.commit();
		manager.close();
		return vendascliente;
	}

	@SuppressWarnings("unchecked")
	public List<Vendascliente> lista(String sql) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql);
		List<Vendascliente> lista = q.getResultList();
		manager.close();
		return lista;
	}
	
	public void excluir(int idvendas, int idcliente) {
    	EntityManager manager;
    	manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
        Query q = manager.createQuery("Select v from Vendascliente v where v.cliente.idcliente=" + idcliente + 
        		" AND v.vendas.idvendas=" + idvendas);
        if (q.getResultList().size()>0){
        	Vendascliente vendascliente = (Vendascliente) q.getResultList().get(0);
            manager.remove(vendascliente);
        }
        tx.commit();
        manager.close();
    }
}
