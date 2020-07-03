package br.com.sistemaWK.facade;

import java.util.List;

import br.com.sistemaWK.dao.VendasDao;
import br.com.sistemaWK.model.Vendas;

public class VendasFacade {

private VendasDao VendasDao;
	
	public Vendas salvar(Vendas Vendas) {
		 VendasDao = new VendasDao();
		return VendasDao.salvar(Vendas);
	}

	public Vendas consultar(int idVendas) {
		VendasDao = new VendasDao();
		return VendasDao.consultar(idVendas);
	}

	public List<Vendas> listar(String sql) {
		VendasDao = new VendasDao();
		return VendasDao.lista(sql);
	}
}
