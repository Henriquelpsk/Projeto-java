package br.com.fiap.fintech.bean;


import java.util.Calendar;

public class Lancamento {
    private int codigo;
    private String tipo;
    private double valor;
    private String descricao;
    private Calendar data;
    private int categoria;
    private int codigoConta;

    public Lancamento(int codigo, String tipo, double valor, String descricao, Calendar data, int categoria, int codigoConta) {
        super();
        this.codigo = codigo;
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
        this.categoria = categoria;
        this.codigoConta = codigoConta;
    }

	public Lancamento(String tipo, double valor, String descricao, Calendar data, int categoria, int codigoConta) {
        super();
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
        this.categoria = categoria;
        this.codigoConta = codigoConta;
    }

    public Lancamento(){
        super();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getCodigoConta() {
        return codigoConta;
    }
    

}
