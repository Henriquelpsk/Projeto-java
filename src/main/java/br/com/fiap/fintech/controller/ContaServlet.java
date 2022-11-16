package br.com.fiap.fintech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.factory.DAOFactory;


@WebServlet("/conta")
public class ContaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ContaDAO dao;
       
    public ContaServlet() {
        dao = DAOFactory.getContaDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        
        switch (acao) {
        	case("abrir-cadastro-conta"):
        	request.getRequestDispatcher("account.jsp").forward(request, response);
        	case("abrir-edicao-conta"):
        	Conta conta = dao.getById(Integer.parseInt(request.getParameter("codigo")));
        	request.setAttribute("conta", conta);
        	
        	request.getRequestDispatcher("accountEdit.jsp").forward(request, response);
        }
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        int codigo = (int) session.getAttribute("codigo");
        String acao = request.getParameter("acao");
        
		switch (acao) {
		case "cadastrar":
			cadastrar(request, response, codigo);
			break;
		case "editar":
			editar(request,response, codigo);
			break;
		case "excluir":
			excluir(request, response);
			break;
		}
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigoConta = Integer.parseInt(request.getParameter("codigoConta"));
		dao.delete(codigoConta);
		request.setAttribute("msg", "Conta removida!");
		request.getRequestDispatcher("gerenciamento").forward(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response, int codigo) throws ServletException, IOException {
		int codigoConta = Integer.parseInt(request.getParameter("codigoConta"));
		String nome = request.getParameter("nome");
		String banco = request.getParameter("banco");
		String agencia = request.getParameter("agencia");
		String contaNumero = request.getParameter("conta");
		Double saldo = Double.parseDouble(request.getParameter("saldo"));
		
		Conta conta = new Conta(codigoConta, nome, banco, agencia, contaNumero, saldo, codigo);
		
		dao.update(conta);
		
		request.getRequestDispatcher("gerenciamento").forward(request, response);

	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response, int codigo) throws ServletException, IOException {
        
		String nome = request.getParameter("nome");
		String banco = request.getParameter("banco");
		String agencia = request.getParameter("agencia");
		String contaNumero = request.getParameter("conta");
		Double saldo = Double.parseDouble(request.getParameter("saldo"));
		
		Conta conta = new Conta(0, nome, banco, agencia, contaNumero, saldo, codigo);
		
		dao.insert(conta);

		request.getRequestDispatcher("dashboard").forward(request, response);
	}

}
