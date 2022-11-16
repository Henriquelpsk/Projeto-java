package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.bean.CartaoDeCredito;

import java.util.List;

public interface CartaoDAO {
	
    void insert(CartaoDeCredito cartao);

    void update(CartaoDeCredito cartao);

    void delete(int codigoBusca);

    CartaoDeCredito getById(int codigo);

    List<CartaoDeCredito> getAll();
}
