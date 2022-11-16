package br.com.fiap.fintech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.fintech.bean.Categoria;
import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.dao.CategoriaDAO;
import br.com.fiap.fintech.factory.DAOFactory;

/**
 * Servlet implementation class CategoriaServlet
 */
@WebServlet("/categoria")
public class CategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CategoriaDAO dao;

    public CategoriaServlet() {
        dao = DAOFactory.getCategoriaDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");
		
        switch (acao) {
    	case("abrir-cadastro-categoria"):
    	request.getRequestDispatcher("category.jsp").forward(request, response);
    	case("abrir-edicao-categoria"):
    	Categoria categoria = dao.getById(Integer.parseInt(request.getParameter("codigo")));
    	request.setAttribute("categoria", categoria);
    	
    	request.getRequestDispatcher("categoryEdit.jsp").forward(request, response);
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
		int codigoCategoria = Integer.parseInt(request.getParameter("codigoCategoria"));
		dao.delete(codigoCategoria);
		request.setAttribute("msg", "Categoria removida!");
		request.getRequestDispatcher("gerenciamento").forward(request, response);
		
	}

	private void editar(HttpServletRequest request, HttpServletResponse response, int codigo) throws ServletException, IOException {
		int codigoCategoria = Integer.parseInt(request.getParameter("codigoCategoria"));
		String nome = request.getParameter("nomeCategoria");
		
		Categoria categoria = new Categoria(codigoCategoria, nome, codigo);
		
		dao.update(categoria);
		
		request.getRequestDispatcher("gerenciamento").forward(request, response);
		
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response, int codigo) throws ServletException, IOException {
		
		String nomeCategoria = request.getParameter("nomeCategoria");
		
		Categoria categoria = new Categoria(0,nomeCategoria,codigo);
		
		dao.insert(categoria);
		
		request.getRequestDispatcher("dashboard").forward(request, response);
		
	}

}
