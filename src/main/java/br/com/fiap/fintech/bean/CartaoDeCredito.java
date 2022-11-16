package br.com.fiap.fintech.bean;

import java.util.Calendar;

public class CartaoDeCredito {
    private int codigo;
    private String nome;
    private String numero;
    private Calendar dataFechamento;
    private double limite;
    private double usado;
    private Calendar vencimento;
    private int codigoUsuario;

    public CartaoDeCredito(int codigo, String nome, String numero, Calendar dataFechamento, double limite, double usado, Calendar vencimento, int codigoUsuario) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.numero = numero;
        this.dataFechamento = dataFechamento;
        this.limite = limite;
        this.usado = usado;
        this.vencimento = vencimento;
        this.codigoUsuario = codigoUsuario;
    }

    public CartaoDeCredito(String nome, String numero, Calendar dataFechamento, double limite, double usado, Calendar vencimento, int codigoUsuario) {
        super();
        this.nome = nome;
        this.numero = numero;
        this.dataFechamento = dataFechamento;
        this.limite = limite;
        this.usado = usado;
        this.vencimento = vencimento;
        this.codigoUsuario = codigoUsuario;
    }

    public CartaoDeCredito() { super();};

    public int getCodigo() {
        return codigo;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Calendar getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Calendar dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getUsado() {
        return usado;
    }

    public void setUsado(double usado) {
        this.usado = usado;
    }

    public Calendar getVencimento() {
        return vencimento;
    }

    public void setVencimento(Calendar vencimento) {
        this.vencimento = vencimento;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }
}
