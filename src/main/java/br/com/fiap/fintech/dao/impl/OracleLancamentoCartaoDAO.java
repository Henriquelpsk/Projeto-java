package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.bean.LancamentoCartao;
import br.com.fiap.fintech.dao.LancamentoCartaoDAO;
import br.com.fiap.fintech.singleton.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OracleLancamentoCartaoDAO implements LancamentoCartaoDAO{
    private Connection conexao;

    public void insert(LancamentoCartao lancamentoCartao){

        PreparedStatement stmt = null;

        try{
			conexao = ConnectionManager.getInstance().getConnection();
            conexao.setAutoCommit(false);

            String sql = "INSERT INTO T_LANCAMENTO_CARTAO(CD_LANCAMENTO_CARTAO, DS_TIPO_LANCAMENTO, VL_LANCAMENTO, DS_LANCAMENTO, DT_LANCAMENTO, DS_CATEGORIA, CD_CARTAO) " +
                    "VALUES (SEQ_LANCAMENTO_CARTAO.NEXTVAL, ?, ?, ?, ? ,? ,?)";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1,lancamentoCartao.getTipo());
            stmt.setDouble(2, lancamentoCartao.getValor());
            stmt.setString(3, lancamentoCartao.getDescricao());
            java.sql.Date data = new java.sql.Date(lancamentoCartao.getData().getTimeInMillis());
            stmt.setDate(4, data);
            stmt.setInt(5, lancamentoCartao.getCategoria());
            stmt.setInt(6, lancamentoCartao.getCodigoCartao());

            stmt.executeUpdate();
            conexao.commit();

            System.out.println("Lançamento no cartão efetuado com sucesso!");

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

    public void update(LancamentoCartao lancamentoCartao){
        PreparedStatement stmt = null;

        try{
			conexao = ConnectionManager.getInstance().getConnection();
            conexao.setAutoCommit(false);

            String sql = "UPDATE T_LANCAMENTO_CARTAO SET DS_TIPO_LANCAMENTO=?, VL_LANCAMENTO=?, DS_LANCAMENTO=?, DT_LANCAMENTO=?, DS_CATEGORIA=? WHERE CD_LANCAMENTO_CARTAO=?";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, lancamentoCartao.getTipo());
            stmt.setDouble(2, lancamentoCartao.getValor());
            stmt.setString(3, lancamentoCartao.getDescricao());
            java.sql.Date data = new java.sql.Date(lancamentoCartao.getData().getTimeInMillis());
            stmt.setDate(4, data);
            stmt.setInt(5, lancamentoCartao.getCategoria());
            stmt.setInt(6,lancamentoCartao.getCodigo());

            stmt.executeUpdate();
            conexao.commit();

            System.out.println("Lançamento no cartão alterado com sucesso!");


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

            String sql = "DELETE FROM T_LANCAMENTO_CARTAO WHERE CD_LANCAMENTO_CARTAO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);

            stmt.executeUpdate();

            System.out.println("Lançamento do cartão removido com sucesso!");

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

    public LancamentoCartao getById(int codigoBusca){

        LancamentoCartao lancamentoCartao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
			conexao = ConnectionManager.getInstance().getConnection();
            stmt = conexao.prepareStatement("SELECT * FROM T_LANCAMENTO_CARTAO WHERE CD_LANCAMENTO_CARTAO = ?");

            stmt.setInt(1, codigoBusca);
            rs = stmt.executeQuery();

            if (rs.next()){
                int codigo = rs.getInt("CD_LANCAMENTO_CARTAO");
                String tipo = rs.getString("DS_TIPO_LANCAMENTO");
                double valor = rs.getDouble("VL_LANCAMENTO");
                String descricao = rs.getString("DS_LANCAMENTO");
                java.sql.Date data = rs.getDate("DT_LANCAMENTO");
                Calendar dataLancamento = Calendar.getInstance();
                dataLancamento.setTimeInMillis(data.getTime());
                int categoria = rs.getInt("DS_CATEGORIA");
                int codigoCartao = rs.getInt("CD_CARTAO");

                lancamentoCartao = new LancamentoCartao(codigo,tipo,valor,descricao,dataLancamento,categoria,codigoCartao);
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
        return lancamentoCartao;
    }

    public List<LancamentoCartao> getAll(){

        List<LancamentoCartao> lista = new ArrayList<LancamentoCartao>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
			conexao = ConnectionManager.getInstance().getConnection();
            stmt = conexao.prepareStatement("SELECT * FROM T_LANCAMENTO_CARTAO ORDER BY CD_LANCAMENTO_CARTAO");
            rs = stmt.executeQuery();

            while(rs.next()){
                int codigo = rs.getInt("CD_LANCAMENTO_CARTAO");
                String tipo = rs.getString("DS_TIPO_LANCAMENTO");
                double valor = rs.getDouble("VL_LANCAMENTO");
                String descricao = rs.getString("DS_LANCAMENTO");
                java.sql.Date data = rs.getDate("DT_LANCAMENTO");
                Calendar dataLancamento = Calendar.getInstance();
                dataLancamento.setTimeInMillis(data.getTime());
                int categoria = rs.getInt("DS_CATEGORIA");
                int codigoCartao = rs.getInt("CD_CARTAO");

                LancamentoCartao lancamentoCartao = new LancamentoCartao(codigo,tipo,valor,descricao,dataLancamento,categoria,codigoCartao);
                lista.add(lancamentoCartao);
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
