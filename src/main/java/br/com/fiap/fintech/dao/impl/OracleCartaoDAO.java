package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.bean.CartaoDeCredito;
import br.com.fiap.fintech.dao.CartaoDAO;
import br.com.fiap.fintech.singleton.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OracleCartaoDAO implements CartaoDAO{

    private Connection conexao;

    public void insert(CartaoDeCredito cartao){

        PreparedStatement stmt = null;

        try{
			conexao = ConnectionManager.getInstance().getConnection();
            conexao.setAutoCommit(false);

            String sql = "INSERT INTO T_CARTAO_DE_CREDITO(CD_CARTAO, NM_CARTAO, NR_CARTAO, DT_FECHAMENTO, VL_LIMITE, VL_USADO, DT_VENCIMENTO, CD_USUARIO) " +
                    "VALUES (SEQ_CARTAO.NEXTVAL, ?, ?, ?, ? ,? ,?, ?)";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1,cartao.getNome());
            stmt.setString(2,cartao.getNumero());
            java.sql.Date data = new java.sql.Date(cartao.getDataFechamento().getTimeInMillis());
            stmt.setDate(3, data);
            stmt.setDouble(4, cartao.getLimite());
            stmt.setDouble(5, cartao.getUsado());
            java.sql.Date data2 = new java.sql.Date(cartao.getVencimento().getTimeInMillis());
            stmt.setDate(6,data2);
            stmt.setInt(7, cartao.getCodigoUsuario());

            stmt.executeUpdate();
            conexao.commit();

            System.out.println("Cartão " + cartao.getNome() + " criado com sucesso!");

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

    public void update(CartaoDeCredito cartao){
        PreparedStatement stmt = null;

        try{
			conexao = ConnectionManager.getInstance().getConnection();
            conexao.setAutoCommit(false);

            String sql = "UPDATE T_CARTAO_DE_CREDITO SET NM_CARTAO=?, NR_CARTAO=?, DT_FECHAMENTO=?, VL_LIMITE=?, VL_USADO=?, DT_VENCIMENTO=? WHERE CD_CARTAO = ?";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, cartao.getNome());
            stmt.setString(2, cartao.getNumero());
            java.sql.Date dataFechamento = new java.sql.Date(cartao.getDataFechamento().getTimeInMillis());
            stmt.setDate(3, dataFechamento);
            stmt.setDouble(4, cartao.getLimite());
            stmt.setDouble(5, cartao.getUsado());
            java.sql.Date dataVencimento = new java.sql.Date(cartao.getVencimento().getTimeInMillis());
            stmt.setDate(6, dataVencimento);
            stmt.setInt(7, cartao.getCodigo());

            stmt.executeUpdate();
            conexao.commit();

            System.out.println("Cartão " + cartao.getNome() + " alterado com sucesso!");


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

            String sql = "DELETE FROM T_CARTAO_DE_CREDITO WHERE CD_CARTAO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);

            stmt.executeUpdate();

            System.out.println("Cartão removido com sucesso!");

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

    public CartaoDeCredito getById(int codigoBusca){

        CartaoDeCredito cartaoDeCredito = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
			conexao = ConnectionManager.getInstance().getConnection();
            stmt = conexao.prepareStatement(" SELECT * FROM T_CARTAO_DE_CREDITO WHERE CD_CARTAO = ?");

            stmt.setInt(1, codigoBusca);
            rs = stmt.executeQuery();

            if (rs.next()){
                int codigo = rs.getInt("CD_CARTAO");
                String nomeCartao = rs.getString("NM_CARTAO");
                String numeroCartao = rs.getString("NR_CARTAO");
                java.sql.Date data1 = rs.getDate("DT_FECHAMENTO");
                Calendar dataFechamento = Calendar.getInstance();
                dataFechamento.setTimeInMillis(data1.getTime());
                double limite = rs.getDouble("VL_LIMITE");
                double usado = rs.getDouble("VL_USADO");
                java.sql.Date data2 = rs.getDate("DT_VENCIMENTO");
                Calendar dataVencimento = Calendar.getInstance();
                dataVencimento.setTimeInMillis(data2.getTime());
                int codigoUsuario = rs.getInt("CD_USUARIO");

                cartaoDeCredito = new CartaoDeCredito(codigo, nomeCartao, numeroCartao , dataFechamento, limite, usado, dataVencimento, codigoUsuario);
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
        return cartaoDeCredito;
    }

    public List<CartaoDeCredito> getAll(){

        List<CartaoDeCredito> lista = new ArrayList<CartaoDeCredito>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
			conexao = ConnectionManager.getInstance().getConnection();
            stmt = conexao.prepareStatement("SELECT * FROM T_CARTAO_DE_CREDITO ORDER BY CD_CARTAO");
            rs = stmt.executeQuery();

            while(rs.next()){
                int codigo = rs.getInt("CD_CARTAO");
                String nomeCartao = rs.getString("NM_CARTAO");
                String numeroCartao = rs.getString("NR_CARTAO");
                java.sql.Date data1 = rs.getDate("DT_FECHAMENTO");
                Calendar dataFechamento = Calendar.getInstance();
                dataFechamento.setTimeInMillis(data1.getTime());
                double limite = rs.getDouble("VL_LIMITE");
                double usado = rs.getDouble("VL_USADO");
                java.sql.Date data2 = rs.getDate("DT_VENCIMENTO");
                Calendar dataVencimento = Calendar.getInstance();
                dataVencimento.setTimeInMillis(data2.getTime());
                int codigoUsuario = rs.getInt("CD_USUARIO");


                CartaoDeCredito cartao = new CartaoDeCredito(codigo, nomeCartao, numeroCartao , dataFechamento, limite, usado, dataVencimento, codigoUsuario);
                lista.add(cartao);
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
