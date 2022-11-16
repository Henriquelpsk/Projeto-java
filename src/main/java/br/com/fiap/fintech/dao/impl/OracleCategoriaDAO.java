package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.Categoria;
import br.com.fiap.fintech.dao.CategoriaDAO;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleCategoriaDAO implements CategoriaDAO{
	
	 private Connection conexao;

	    public void insert(Categoria categoria){

	        PreparedStatement stmt = null;

	        try{
				conexao = ConnectionManager.getInstance().getConnection();
	            conexao.setAutoCommit(false);

	            String sql = "INSERT INTO T_CATEGORIA(CD_CATEGORIA, NM_CATEGORIA, CD_USUARIO) " +
	                    "VALUES (SEQ_CATEGORIA.NEXTVAL, ?, ?)";
	            stmt = conexao.prepareStatement(sql);

	            stmt.setString(1, categoria.getNome());
	            stmt.setInt(2, categoria.getCodigoUsuario());

	            stmt.executeUpdate();
	            conexao.commit();

	            System.out.println("Categoria " + categoria.getNome() + " criada com sucesso!");

	        }catch(SQLException e){
	            e.printStackTrace();
	        }finally {
	            try{
	                conexao.rollback();
	                stmt.close();
	                conexao.close();
	            }catch(SQLException e){
	                e.printStackTrace();
	            }
	        }
	    }

	    public void update(Categoria categoria){
	        PreparedStatement stmt = null;

	        try{
				conexao = ConnectionManager.getInstance().getConnection();
	            conexao.setAutoCommit(false);

	            String sql = "UPDATE T_CATEGORIA SET NM_CATEGORIA=? WHERE CD_CATEGORIA = ?";
	            stmt = conexao.prepareStatement(sql);

	            stmt.setString(1, categoria.getNome());
	            stmt.setInt(2, categoria.getCodigo());

	            stmt.executeUpdate();
	            conexao.commit();

	            System.out.println("Categoria " + categoria.getNome() + " alterada com sucesso!");


	        } catch (SQLException e){
	            e.printStackTrace();
	        } finally {
	            try{
	                conexao.rollback();
	                stmt.close();
	                conexao.close();
	            }catch (SQLException e){
	                e.printStackTrace();
	            }
	        }
	    }

	    public void delete(int codigo){

	        PreparedStatement stmt = null;

	        try {
				conexao = ConnectionManager.getInstance().getConnection();

	            String sql = "DELETE FROM T_CATEGORIA WHERE CD_CATEGORIA = ?";
	            stmt = conexao.prepareStatement(sql);
	            stmt.setInt(1, codigo);

	            stmt.executeUpdate();

	            System.out.println("Categoria removida com sucesso!");

	        } catch (SQLException e){
	            e.printStackTrace();
	        } finally {
	            try {
	                stmt.close();
	                conexao.close();
	            } catch (SQLException e){
	                e.printStackTrace();
	            }
	        }
	    }

	    public Categoria getById(int codigoBusca){

	        Categoria categoria = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        try {
				conexao = ConnectionManager.getInstance().getConnection();
	            stmt = conexao.prepareStatement("SELECT * FROM T_CATEGORIA WHERE CD_CATEGORIA = ?");

	            stmt.setInt(1, codigoBusca);
	            rs = stmt.executeQuery();

	            if (rs.next()){
	                int codigo = rs.getInt("CD_CATEGORIA");
	                String nomeCategoria = rs.getString("NM_CATEGORIA");
	                int codigoUsuario = rs.getInt("CD_USUARIO");

	                categoria = new Categoria(codigo, nomeCategoria, codigoUsuario);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	            try {
	                stmt.close();
	                rs.close();
	                conexao.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return categoria;
	    }

	    public List<Categoria> getAll(){

	        List<Categoria> lista = new ArrayList<Categoria>();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        try {
				conexao = ConnectionManager.getInstance().getConnection();
	            stmt = conexao.prepareStatement("SELECT * FROM T_CATEGORIA ORDER BY CD_CATEGORIA");
	            rs = stmt.executeQuery();

	            while(rs.next()){
	                int codigo = rs.getInt("CD_CATEGORIA");
	                String nomeCategoria = rs.getString("NM_CATEGORIA");
	                int codigoUsuario = rs.getInt("CD_USUARIO");

	                Categoria categoria = new Categoria(codigo, nomeCategoria, codigoUsuario);
	                lista.add(categoria);
	            }
	        } catch (SQLException e){
	            e.printStackTrace();
	        } finally {
	            try {
	                stmt.close();
	                conexao.close();
	            } catch (SQLException e){
	                e.printStackTrace();
	            }
	        }
	        return lista;
	    }


}
