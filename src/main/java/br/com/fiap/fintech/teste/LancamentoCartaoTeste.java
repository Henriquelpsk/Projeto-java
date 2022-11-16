package br.com.fiap.fintech.teste;

import java.util.Calendar;

import br.com.fiap.fintech.bean.LancamentoCartao;
import br.com.fiap.fintech.dao.LancamentoCartaoDAO;
import br.com.fiap.fintech.factory.DAOFactory;

public class LancamentoCartaoTeste {
	public static void main(String[] args) {
		LancamentoCartaoDAO dao = DAOFactory.getLancamentoCartaoDAO();
		
		LancamentoCartao lancamento = dao.getById(10);
		lancamento.setTipo("Crédito");
		
		dao.update(lancamento);
		
		
	}

}
