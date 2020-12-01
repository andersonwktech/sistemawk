package br.com.sistemaWK.facade;

import java.util.List;

import br.com.sistemaWK.dao.CategoriaDao;
import br.com.sistemaWK.model.Categoria;

public class CategoriaFacade {

	
	CategoriaDao categoriaDao;
	
	
	public Categoria salvar(Categoria categoria) {
		 categoriaDao = new CategoriaDao();
		return categoriaDao.salvar(categoria);
	}

	public Categoria consultar(int idcategoria) {
		categoriaDao = new CategoriaDao();
		return categoriaDao.consultar(idcategoria);
	}

	public List<Categoria> listar(String sql) {
		categoriaDao = new CategoriaDao();
		return categoriaDao.lista(sql);
	}
}
