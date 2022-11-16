package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.bean.LancamentoCartao;

import java.util.List;

public interface LancamentoCartaoDAO {
	
    void insert(LancamentoCartao lancamentoCartao);

    void update(LancamentoCartao lancamentoCartao);

    void delete(int codigoBusca);

    LancamentoCartao getById(int codigo);

    List<LancamentoCartao> getAll();
}