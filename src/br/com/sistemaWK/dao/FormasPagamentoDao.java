package br.com.sistemaWK.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sistemaWK.model.Formaspagamento;
import br.com.sistemaWK.util.ConectionFactory;

public class FormasPagamentoDao {

	
	public Formaspagamento salvar(Formaspagamento formaspagamento) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		formaspagamento = manager.merge(formaspagamento);
		tx.commit();
		manager.close();
		return formaspagamento;
	}

	public Formaspagamento consultar(int idformaspagamento) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Query q = manager.createQuery("select f from Formaspagamento f where f.idformaspagamento=" + idformaspagamento);
		Formaspagamento formaspagamento = null;
		if (q.getResultList().size() > 0) {
			formaspagamento = (Formaspagamento) q.getResultList().get(0);
		}
		tx.commit();
		manager.close();
		return formaspagamento;
	}

	@SuppressWarnings("unchecked")
	public List<Formaspagamento> lista(String sql) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql);
		List<Formaspagamento> lista = q.getResultList();
		manager.close();
		return lista;
	}
	
	public void excluir(int idformaspagamento) {
    	EntityManager manager;
    	manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
        Query q = manager.createQuery("Select f from Formaspagamento f where f.idformaspagamento=" + idformaspagamento);
        if (q.getResultList().size()>0){
        	Formaspagamento formaspagamento = (Formaspagamento) q.getResultList().get(0);
            manager.remove(formaspagamento);
        }
        tx.commit();
        manager.close();
    }
}
