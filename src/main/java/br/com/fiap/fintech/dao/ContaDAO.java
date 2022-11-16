package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.bean.Conta;

import java.util.List;

public interface ContaDAO {
	
    void insert(Conta conta);

    void update(Conta conta);

    void delete(int codigoBusca);

    Conta getById(int codigo);

    List<Conta> getAll();
}
