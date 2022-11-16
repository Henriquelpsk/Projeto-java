package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.fintech.bean.CartaoDeCredito;
import br.com.fiap.fintech.dao.CartaoDAO;
import br.com.fiap.fintech.factory.DAOFactory;

/**
 * Servlet implementation class CartaoServlet
 */
@WebServlet("/cartao")
public class CartaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CartaoDAO dao;
       
    public CartaoServlet() {
        dao = DAOFactory.getCartaoDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        
        switch (acao) {
        	case("abrir-cadastro-cartao"):
        	request.getRequestDispatcher("creditCard.jsp").forward(request, response);
        	case("abrir-edicao-cartao"):
        	CartaoDeCredito cartao = dao.getById(Integer.parseInt(request.getParameter("codigo")));
        	request.setAttribute("cartao", cartao);
        	
        	request.getRequestDispatcher("creditCardEdit.jsp").forward(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        int codigo = (int) session.getAttribute("codigo");
        String acao = request.getParameter("acao");
        
		switch (acao) {
		case "cadastrar":
			try {
				cadastrar(request, response, codigo);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		
		int codigoCartao = Integer.parseInt(request.getParameter("codigoCartao"));
		System.out.println(codigoCartao);
		dao.delete(codigoCartao);
		request.setAttribute("msg", "Cartão removido!");
		request.getRequestDispatcher("gerenciamento").forward(request, response);
		
	}

	private void editar(HttpServletRequest request, HttpServletResponse response, int codigo) throws ServletException, IOException{
		int codigoCartao = Integer.parseInt(request.getParameter("codigoCartao"));
		String nome = request.getParameter("nome");
		String numero = request.getParameter("numero");
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Calendar dataFecha = Calendar.getInstance();
		try {
			dataFecha.setTime(format.parse(request.getParameter("dataFecha")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar dataVence = Calendar.getInstance();
		try {
			dataVence.setTime(format.parse(request.getParameter("dataVence")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Double limite = Double.parseDouble(request.getParameter("limite"));
		Double usado = Double.parseDouble(request.getParameter("usado"));
		
		CartaoDeCredito cartao = new CartaoDeCredito(codigoCartao, nome, numero, dataFecha, limite, usado, dataVence, codigo);
		
		dao.update(cartao);
		
		request.getRequestDispatcher("gerenciamento").forward(request, response);
		
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response, int codigo) throws ParseException, ServletException, IOException {
		
			String nome = request.getParameter("nome");
			String numero = request.getParameter("numero");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataFecha = Calendar.getInstance();
			dataFecha.setTime(format.parse(request.getParameter("dataFecha")));
			Calendar dataVence = Calendar.getInstance();
			dataVence.setTime(format.parse(request.getParameter("dataVence")));
			Double limite = Double.parseDouble(request.getParameter("limite"));
			Double usado = Double.parseDouble(request.getParameter("usado"));
			
			CartaoDeCredito cartao = new CartaoDeCredito(0, nome, numero, dataFecha, limite, usado, dataVence, codigo);
			
			dao.insert(cartao);
			
			request.getRequestDispatcher("dashboard").forward(request, response);
	}

}
