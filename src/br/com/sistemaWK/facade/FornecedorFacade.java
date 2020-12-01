package br.com.sistemaWK.facade;

import java.util.List;

import br.com.sistemaWK.dao.FornecedorDao;
import br.com.sistemaWK.model.Fornecedor;

public class FornecedorFacade {

	FornecedorDao fornecedorDao;
	
	
	public Fornecedor salvar(Fornecedor fornecedor) {
		 fornecedorDao = new FornecedorDao();
		return fornecedorDao.salvar(fornecedor);
	}

	public Fornecedor consultar(int idfornecedor) {
		fornecedorDao = new FornecedorDao();
		return fornecedorDao.consultar(idfornecedor);
	}

	public List<Fornecedor> listar(String sql) {
		fornecedorDao = new FornecedorDao();
		return fornecedorDao.lista(sql);
	}
}
