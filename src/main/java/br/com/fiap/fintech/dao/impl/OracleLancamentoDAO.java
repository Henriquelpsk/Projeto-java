package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.bean.Lancamento;
import br.com.fiap.fintech.bean.LancamentoCartao;
import br.com.fiap.fintech.dao.LancamentoDAO;
import br.com.fiap.fintech.singleton.ConnectionManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OracleLancamentoDAO implements LancamentoDAO{
    private Connection conexao;

    public void insert(Lancamento lancamento){

        PreparedStatement stmt = null;

        try{
			conexao = ConnectionManager.getInstance().getConnection();
            conexao.setAutoCommit(false);

            String sql = "INSERT INTO T_LANCAMENTO(CD_LANCAMENTO, DS_TIPO_LANCAMENTO, VL_LANCAMENTO, DS_LANCAMENTO, DT_LANCAMENTO, DS_CATEGORIA, CD_CONTA) " +
                    "VALUES (SEQ_LANCAMENTO.NEXTVAL, ?, ?, ?, ? ,? ,?)";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1,lancamento.getTipo());
            stmt.setDouble(2, lancamento.getValor());
            stmt.setString(3, lancamento.getDescricao());
            java.sql.Date data = new java.sql.Date(lancamento.getData().getTimeInMillis());
            stmt.setDate(4, data);
            stmt.setInt(5, lancamento.getCategoria());
            stmt.setInt(6, lancamento.getCodigoConta());

            stmt.executeUpdate();
            conexao.commit();

            System.out.println("Lançamento efetuado com sucesso!");

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

    public void update(Lancamento lancamento){

        PreparedStatement stmt = null;

        try{
			conexao = ConnectionManager.getInstance().getConnection();
            conexao.setAutoCommit(false);

            String sql = "UPDATE T_LANCAMENTO SET DS_TIPO_LANCAMENTO=?, VL_LANCAMENTO=?, DS_LANCAMENTO=?, DT_LANCAMENTO=?, DS_CATEGORIA=? WHERE CD_LANCAMENTO=?";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1,lancamento.getTipo());
            stmt.setDouble(2, lancamento.getValor());
            stmt.setString(3, lancamento.getDescricao());
            java.sql.Date data = new java.sql.Date(lancamento.getData().getTimeInMillis());
            stmt.setDate(4, data);
            stmt.setInt(5, lancamento.getCategoria());
            stmt.setInt(6, lancamento.getCodigo());

            stmt.executeUpdate();
            conexao.commit();

            System.out.println("Lançamento efetuado com sucesso!");

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

    public void delete(int codigo){

        PreparedStatement stmt = null;

        try {
			conexao = ConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM T_LANCAMENTO WHERE CD_LANCAMENTO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);

            stmt.executeUpdate();

            System.out.println("Lançamento removido com sucesso!");

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

    public Lancamento getById(int codigoBusca){

        Lancamento lancamento = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
			conexao = ConnectionManager.getInstance().getConnection();
            stmt = conexao.prepareStatement("SELECT * FROM T_LANCAMENTO WHERE CD_LANCAMENTO = ?");

            stmt.setInt(1, codigoBusca);
            rs = stmt.executeQuery();

            if (rs.next()){
                int codigo = rs.getInt("CD_LANCAMENTO");
                String tipo = rs.getString("DS_TIPO_LANCAMENTO");
                double valor = rs.getDouble("VL_LANCAMENTO");
                String descricao = rs.getString("DS_LANCAMENTO");
                java.sql.Date data = rs.getDate("DT_LANCAMENTO");
                Calendar dataLancamento = Calendar.getInstance();
                dataLancamento.setTimeInMillis(data.getTime());
                int categoria = rs.getInt("DS_CATEGORIA");
                int codigoConta = rs.getInt("CD_CONTA");

                lancamento = new Lancamento(codigo,tipo,valor,descricao,dataLancamento,categoria,codigoConta);
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
        return lancamento;
    }

    public List<Lancamento> getAll(){

        List<Lancamento> lista = new ArrayList<Lancamento>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
			conexao = ConnectionManager.getInstance().getConnection();
            stmt = conexao.prepareStatement("SELECT * FROM T_LANCAMENTO ORDER BY CD_LANCAMENTO");
            rs = stmt.executeQuery();

            while(rs.next()){
                int codigo = rs.getInt("CD_LANCAMENTO");
                String tipo = rs.getString("DS_TIPO_LANCAMENTO");
                double valor = rs.getDouble("VL_LANCAMENTO");
                String descricao = rs.getString("DS_LANCAMENTO");
                java.sql.Date data = rs.getDate("DT_LANCAMENTO");
                Calendar dataLancamento = Calendar.getInstance();
                dataLancamento.setTimeInMillis(data.getTime());
                int categoria = rs.getInt("DS_CATEGORIA");
                int codigoConta = rs.getInt("CD_CONTA");

                Lancamento lancamento = new Lancamento(codigo,tipo,valor,descricao,dataLancamento,categoria,codigoConta);
                lista.add(lancamento);
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
