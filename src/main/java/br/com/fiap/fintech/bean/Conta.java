package br.com.fiap.fintech.bean;



public class Conta {
    private int codigo;
    private String nome;
    private String banco;
    private String agencia;
    private String conta;
    private double saldo;
    private int codigoUsuario;

    public Conta(int codigo, String nome, String banco, String agencia, String conta, double saldo, int codigoUsuario) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
        this.saldo = saldo;
        this.codigoUsuario = codigoUsuario;
    }

    public Conta(String nome, String banco, String agencia, String conta, double saldo, int codigoUsuario) {
        super();
        this.nome = nome;
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
        this.saldo = saldo;
        this.codigoUsuario = codigoUsuario;
    }

    public Conta() { super(); }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }
}


