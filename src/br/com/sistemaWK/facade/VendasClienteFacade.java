package br.com.sistemaWK.facade;

import java.util.List;

import br.com.sistemaWK.dao.VendasClienteDao;
import br.com.sistemaWK.model.Vendascliente;


public class VendasClienteFacade {
	
	VendasClienteDao vendasClienteDao;
	
	
	public Vendascliente salvar(Vendascliente vendascliente) {
		 vendasClienteDao = new VendasClienteDao();
		return vendasClienteDao.salvar(vendascliente);
	}

	public Vendascliente consultar(int idvendascliente) {
		vendasClienteDao = new VendasClienteDao();
		return vendasClienteDao.consultar(idvendascliente);
	}

	public List<Vendascliente> listar(String sql) {
		vendasClienteDao = new VendasClienteDao();
		return vendasClienteDao.lista(sql);
	}
	
	public void excluir(int idvendas, int idcliente) {
		vendasClienteDao = new VendasClienteDao();
		vendasClienteDao.excluir(idvendas, idcliente);
	}
}
