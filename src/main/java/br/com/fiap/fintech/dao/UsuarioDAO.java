package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.bean.Usuario;

import java.util.List;

public interface UsuarioDAO {
	
	Usuario capturaNome(String email);
	
	boolean validarUsuario(Usuario usuario);

    void insert(Usuario usuario);

    void update(Usuario usuario);

    void delete(int codigoBusca);

    Usuario getById(int codigo);

    List<Usuario> getAll();
}
