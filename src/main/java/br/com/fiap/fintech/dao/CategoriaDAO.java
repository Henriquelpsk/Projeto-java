package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.Categoria;


public interface CategoriaDAO {
	
	void insert(Categoria categoria);

    void update(Categoria categoria);

    void delete(int codigoBusca);

    Categoria getById(int codigo);

    List<Categoria> getAll();

}
