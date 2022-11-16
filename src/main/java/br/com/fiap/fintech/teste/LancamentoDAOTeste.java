package br.com.fiap.fintech.teste;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.fintech.bean.Lancamento;
import br.com.fiap.fintech.dao.LancamentoDAO;
import br.com.fiap.fintech.factory.DAOFactory;

public class LancamentoDAOTeste {
	public static void main(String[] args) {
		LancamentoDAO dao = DAOFactory.getLancamentoDAO();
		
		Lancamento lancamento = dao.getById(5);
		lancamento.setTipo("Crédito");
		//dao.insert(lancamento);
		dao.update(lancamento);
		List<Lancamento> lista = dao.getAll();
		
		for(Lancamento lancamento1 : lista) {
			System.out.println(lancamento1.getCodigo() + lancamento1.getDescricao() + lancamento1.getTipo());
		}
		
	}
}
