package br.com.fiap.fintech.teste;

import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.factory.DAOFactory;

public class ValidaTeste {
	public static void main(String[] args) {
		UsuarioDAO dao = DAOFactory.getUsuarioDAO();
		
		Usuario user1 = new Usuario("teste@fiap.com.br","123");
		System.out.println(dao.validarUsuario(user1)); 
		
		System.out.println(dao.getById(26)); 
	}

}
