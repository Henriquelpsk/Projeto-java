package br.com.fiap.fintech.teste;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.factory.DAOFactory;
import br.com.fiap.fintech.util.CriptografiaUtils;

public class UsuarioDAOTeste {
	public static void main(String[] args) throws Exception {
		UsuarioDAO dao = DAOFactory.getUsuarioDAO();
		
		//Cadastrar um produto
		Usuario usuario = new Usuario(0,"joseTeste@gmail.com",CriptografiaUtils.criptografar("123456"),"jose","11977854587",Calendar.getInstance());
		dao.insert(usuario);
		System.out.println("Usuario cadastrado.");

		//Buscar um produto pelo código e atualizar
		usuario = dao.getById(1);
		usuario.setNome("Não mais josé");
		usuario.setTelefone("11987788778");
		dao.update(usuario);
		System.out.println("Usuario atualizado.");
		
		//Listar os produtos
		List<Usuario> lista = dao.getAll();
		for (Usuario item : lista) {
			System.out.println(item.getNome() + " " + item.getEmail() + " " + item.getSenha() + " " + item.getTelefone() + " " + item.getDtNascimento().getTime());
		}
		
		dao.delete(1);
		System.out.println("Usuario removido.");	
	}	

}
