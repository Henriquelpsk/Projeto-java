package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.bean.Lancamento;

import java.util.List;

public interface LancamentoDAO {
	
    void insert(Lancamento lancamento);

    void update(Lancamento lancamento);

    void delete(int codigoBusca);

    Lancamento getById(int codigo);

    List<Lancamento> getAll();
}