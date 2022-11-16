package br.com.fiap.fintech.teste;

import java.util.List;

import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

public class ContaDAOTeste {
	public static void main(String[] args) throws DBException {
		ContaDAO dao = DAOFactory.getContaDAO();
		
		//Cadastrar um produto
		Conta conta = new Conta(0,"contaTeste","11","1191","12312312",1500.00,1);
		dao.insert(conta);
		System.out.println("Conta cadastrada.");

		//Buscar um produto pelo código e atualizar
		conta = dao.getById(1);
		conta.setNome("ContaTeste2");
		conta.setAgencia("2121");
		dao.update(conta);
		System.out.println("Conta atualizada.");
		
		//Listar os produtos
		List<Conta> lista = dao.getAll();
		for (Conta item : lista) {
			System.out.println(item.getNome() + " " + item.getBanco() + " " + item.getAgencia() + " " + item.getConta() + " " + item.getSaldo());
		}
		
		dao.delete(1);
		System.out.println("Conta removida.");	
	}	

}