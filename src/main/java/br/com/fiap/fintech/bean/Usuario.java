package br.com.fiap.fintech.bean;


import java.util.Calendar;

public class Usuario{
    private int codigo;
    private String email;
    private String senha;
    private String telefone;
    private String nome;
    private Calendar dtNascimento;
    
    public Usuario(String email, String senha) {
    	super();
    	this.email= email;
    	this.senha= senha;
    }
    
    public Usuario(int codigo,String email,String senha,String nome) {
    	this.codigo = codigo;
    	this.email = email;
    	this.senha = senha;
    	this.nome = nome;
    }


    public Usuario(int codigo, String email, String senha, String nome, String telefone,Calendar dtNascimento){
        super();
        this.codigo = codigo;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.telefone = telefone;
        this.dtNascimento = dtNascimento;
    }

    public Usuario(String email, String senha, String nome, String telefone,Calendar dtNascimento){
        super();
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.telefone = telefone;
        this.dtNascimento = dtNascimento;
    }

    public Usuario(){ super(); }

    public int getCodigo() { return codigo; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Calendar getDtNascimento() { return dtNascimento; }

    public void setDtNascimento(Calendar dtNascimento) { this.dtNascimento = dtNascimento; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String consultaUsuario() {
        return "Nome:" + this.nome + "\n" +
                "Nascimento: " + this.dtNascimento + "\n" +
                "Email: " + this.email + "\n" +
                "Telefone: " + this.telefone;
    }

}