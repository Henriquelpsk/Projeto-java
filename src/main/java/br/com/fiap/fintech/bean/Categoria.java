package br.com.fiap.fintech.bean;

public class Categoria {
	private int codigo;
	private String nome;
	private int codigoUsuario;

	public Categoria() {
		super();
	}
	
	public Categoria(String nome , int codigoUsuario) {
		super();
		this.nome = nome;
		this.codigoUsuario = codigoUsuario;
	}
	
	public Categoria(int codigo, String nome, int codigoUsuario) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.codigoUsuario = codigoUsuario;
	}

	public int getCodigo() {
		return codigo;
	}
	

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
