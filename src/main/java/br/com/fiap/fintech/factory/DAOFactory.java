package br.com.fiap.fintech.factory;

import br.com.fiap.fintech.dao.CartaoDAO;
import br.com.fiap.fintech.dao.CategoriaDAO;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.dao.LancamentoCartaoDAO;
import br.com.fiap.fintech.dao.LancamentoDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.dao.impl.OracleCartaoDAO;
import br.com.fiap.fintech.dao.impl.OracleCategoriaDAO;
import br.com.fiap.fintech.dao.impl.OracleContaDAO;
import br.com.fiap.fintech.dao.impl.OracleLancamentoCartaoDAO;
import br.com.fiap.fintech.dao.impl.OracleLancamentoDAO;
import br.com.fiap.fintech.dao.impl.OracleUsuarioDAO;

public class DAOFactory {
	
	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}
	
	public static ContaDAO getContaDAO() {
		return new OracleContaDAO();
	}
	
	public static CartaoDAO getCartaoDAO() {
		return new OracleCartaoDAO();
	}

	public static LancamentoDAO getLancamentoDAO() {
		return new OracleLancamentoDAO();
	}
	
	public static LancamentoCartaoDAO getLancamentoCartaoDAO() {
		return new OracleLancamentoCartaoDAO();
	}
	
	public static CategoriaDAO getCategoriaDAO(){
		return new OracleCategoriaDAO();
	}

}
