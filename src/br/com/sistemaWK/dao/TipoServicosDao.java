package br.com.sistemaWK.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sistemaWK.model.Tiposervicos;
import br.com.sistemaWK.util.ConectionFactory;

public class TipoServicosDao {

	public Tiposervicos salvar(Tiposervicos tiposervicos) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		tiposervicos = manager.merge(tiposervicos);
		tx.commit();
		manager.close();
		return tiposervicos;
	}

	public Tiposervicos consultar(int idtiposervicos) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Query q = manager.createQuery("select t from Tiposervicos t where t.idtiposervicos=" + idtiposervicos);
		Tiposervicos tiposervicos = null;
		if (q.getResultList().size() > 0) {
			tiposervicos = (Tiposervicos) q.getResultList().get(0);
		}
		tx.commit();
		manager.close();
		return tiposervicos;
	}

	@SuppressWarnings("unchecked")
	public List<Tiposervicos> lista(String sql) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql);
		List<Tiposervicos> lista = q.getResultList();
		manager.close();
		return lista;
	}
}
