package br.com.sistemaWK.facade;

import java.util.List;

import br.com.sistemaWK.dao.ClienteDao;
import br.com.sistemaWK.model.Cliente;

public class ClienteFacade {

private ClienteDao clienteDao;
	
	public Cliente salvar(Cliente cliente) {
		 clienteDao = new ClienteDao();
		return clienteDao.salvar(cliente);
	}

	public Cliente consultar(int idcliente) {
		clienteDao = new ClienteDao();
		return clienteDao.consultar(idcliente);
	}

	public List<Cliente> listar(String sql) {
		clienteDao = new ClienteDao();
		return clienteDao.lista(sql);
	}
	
	public Cliente consultarCPF(String cpfcliente) {
		clienteDao = new ClienteDao();
		return clienteDao.consultarCPF(cpfcliente);
	}
	
	
	public void excluir(int idcliente) {
		clienteDao = new ClienteDao();
		clienteDao.excluir(idcliente);
	}
}
