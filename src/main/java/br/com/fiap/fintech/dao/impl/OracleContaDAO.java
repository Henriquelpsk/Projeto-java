package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.singleton.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleContaDAO implements ContaDAO{

    private Connection conexao;

    public void insert(Conta conta){

        PreparedStatement stmt = null;

        try{
			conexao = ConnectionManager.getInstance().getConnection();
            conexao.setAutoCommit(false);

            String sql = "INSERT INTO T_CONTA(CD_CONTA, NM_CONTA, NR_BANCO, NR_AGENCIA, NR_CONTA, VL_SALDO_CONTA, CD_USUARIO) " +
                    "VALUES (SEQ_CONTA.NEXTVAL, ?, ?, ?, ? ,? ,?)";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1,conta.getNome());
            stmt.setInt(2, Integer.parseInt(conta.getBanco()));
            stmt.setInt(3, Integer.parseInt(conta.getAgencia()));
            stmt.setInt(4, Integer.parseInt(conta.getConta()));
            stmt.setDouble(5, conta.getSaldo());
            stmt.setInt(6, conta.getCodigoUsuario());

            stmt.executeUpdate();
            conexao.commit();

            System.out.println("Usuario " + conta.getNome() + " criado com sucesso!");

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

    public void update(Conta conta){
        PreparedStatement stmt = null;

        try{
			conexao = ConnectionManager.getInstance().getConnection();
            conexao.setAutoCommit(false);

            String sql = "UPDATE T_CONTA SET NM_CONTA=?, NR_BANCO=?, NR_AGENCIA=?, NR_CONTA=?, VL_SALDO_CONTA=? WHERE CD_CONTA = ?";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, conta.getNome());
            stmt.setInt(2, Integer.parseInt(conta.getBanco()));
            stmt.setInt(3, Integer.parseInt(conta.getAgencia()));
            stmt.setInt(4, Integer.parseInt(conta.getConta()));
            stmt.setDouble(5, conta.getSaldo());
            stmt.setInt(6, conta.getCodigo());

            stmt.executeUpdate();
            conexao.commit();

            System.out.println("Usuario " + conta.getNome() + " alterado com sucesso!");


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

            String sql = "DELETE FROM T_CONTA WHERE CD_CONTA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);

            stmt.executeUpdate();

            System.out.println("Conta removida com sucesso!");

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

    public Conta getById(int codigoBusca){

        Conta conta = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
			conexao = ConnectionManager.getInstance().getConnection();
            stmt = conexao.prepareStatement("SELECT * FROM T_CONTA WHERE CD_CONTA = ?");

            stmt.setInt(1, codigoBusca);
            rs = stmt.executeQuery();

            if (rs.next()){
                int codigo = rs.getInt("CD_CONTA");
                String nomeConta = rs.getString("NM_CONTA");
                int banco = rs.getInt("NR_BANCO");
                int agencia = rs.getInt("NR_AGENCIA");
                int numeroConta = rs.getInt("NR_CONTA");
                double saldo = rs.getDouble("VL_SALDO_CONTA");
                int codigoUsuario = rs.getInt("CD_USUARIO");

                conta = new Conta(codigo, nomeConta, Integer.toString(banco), Integer.toString(agencia), Integer.toString(numeroConta), saldo, codigoUsuario);
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
        return conta;
    }

    public List<Conta> getAll(){

        List<Conta> lista = new ArrayList<Conta>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
			conexao = ConnectionManager.getInstance().getConnection();
            stmt = conexao.prepareStatement("SELECT * FROM T_CONTA ORDER BY CD_CONTA");
            rs = stmt.executeQuery();

            while(rs.next()){
                int codigo = rs.getInt("CD_CONTA");
                String nomeConta = rs.getString("NM_CONTA");
                int banco = rs.getInt("NR_BANCO");
                int agencia = rs.getInt("NR_AGENCIA");
                int numeroCOnta = rs.getInt("NR_CONTA");
                double saldo = rs.getDouble("VL_SALDO_CONTA");
                int codigoUsuario = rs.getInt("CD_USUARIO");

                Conta conta = new Conta(codigo, nomeConta, Integer.toString(banco), Integer.toString(agencia), Integer.toString(numeroCOnta), saldo, codigoUsuario);
                lista.add(conta);
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
