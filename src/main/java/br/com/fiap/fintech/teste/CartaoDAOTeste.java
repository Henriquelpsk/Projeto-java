package br.com.fiap.fintech.teste;

import java.util.List;

import br.com.fiap.fintech.bean.CartaoDeCredito;
import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.dao.CartaoDAO;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

public class CartaoDAOTeste {
	public static void main(String[] args) throws DBException {
		CartaoDAO dao = DAOFactory.getCartaoDAO();
		
		//Cadastrar um produto
		//CartaoDeCredito cartao = new CartaoDeCredito(0,"cartaoTeste","1111555533334444","bandeira","12312312",1500.00,1);
		//dao.insert(cartao);
		System.out.println("Conta cadastrada.");

		//Buscar um produto pelo código e atualizar
		CartaoDeCredito cartao = dao.getById(1);
		cartao.setNome("ContaTeste2");
		dao.update(cartao);
		System.out.println("Conta atualizada.");
		
		//Listar os produtos
		List<CartaoDeCredito> lista = dao.getAll();
		for (CartaoDeCredito item : lista) {
			System.out.println(item.getNome() + " " + item.getNumero() + " " + item.getLimite() + " " + item.getUsado());
		}
		
		//dao.delete(1);
		System.out.println("Conta removida.");	
	}	

}