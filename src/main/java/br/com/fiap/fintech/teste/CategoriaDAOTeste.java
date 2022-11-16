package br.com.fiap.fintech.teste;

import java.util.List;

import br.com.fiap.fintech.bean.Categoria;
import br.com.fiap.fintech.dao.CategoriaDAO;
import br.com.fiap.fintech.factory.DAOFactory;

public class CategoriaDAOTeste {
	public static void main(String[] args) {
		CategoriaDAO dao = DAOFactory.getCategoriaDAO();
		//Cadastrar um produto
		Categoria categoria = new Categoria(0,"Mercado",1);
		dao.insert(categoria);
		System.out.println("Categoria cadastrada.");

		//Buscar um produto pelo código e atualizar
		categoria = dao.getById(1);
		categoria.setNome("Compras");
		dao.update(categoria);
		System.out.println("Categoria atualizada.");
		
		//Listar os produtos
		List<Categoria> lista = dao.getAll();
		for (Categoria item : lista) {
			System.out.println(item.getNome());
		}
		
		//dao.delete(1);
		System.out.println("Usuario removido.");	
	}	
}
