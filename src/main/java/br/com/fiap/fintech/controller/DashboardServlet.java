package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.fintech.bean.CartaoDeCredito;
import br.com.fiap.fintech.bean.Categoria;
import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.CartaoDAO;
import br.com.fiap.fintech.dao.CategoriaDAO;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.factory.DAOFactory;


@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO dao;
	private ContaDAO daoConta;
	private CartaoDAO daoCartao;
	private CategoriaDAO daoCategoria;

    public DashboardServlet() {
        dao = DAOFactory.getUsuarioDAO();
        daoConta = DAOFactory.getContaDAO();
        daoCartao = DAOFactory.getCartaoDAO();
        daoCategoria = DAOFactory.getCategoriaDAO();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String email = (String) session.getAttribute("user");


        List<Conta> listaConta = daoConta.getAll();
        List<CartaoDeCredito> listaCartao = daoCartao.getAll();
        List<Categoria> listaCategoria = daoCategoria.getAll();
        Usuario usuarioNome = dao.capturaNome(email);

        session.setAttribute("nome", usuarioNome.getNome());
        session.setAttribute("codigo", usuarioNome.getCodigo());
        session.setAttribute("listaConta", listaConta);
        session.setAttribute("listaCartao", listaCartao);
        session.setAttribute("listaCategoria", listaCategoria);
        
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
