package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import br.com.fiap.fintech.bean.CartaoDeCredito;
import br.com.fiap.fintech.bean.Categoria;
import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.bean.Lancamento;
import br.com.fiap.fintech.bean.LancamentoCartao;
import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.CartaoDAO;
import br.com.fiap.fintech.dao.CategoriaDAO;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.dao.LancamentoCartaoDAO;
import br.com.fiap.fintech.dao.LancamentoDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.factory.DAOFactory;

/**
 * Servlet implementation class ExtratoServlet
 */
@WebServlet("/extrato")
public class ExtratoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LancamentoDAO daoLancamento;
	private LancamentoCartaoDAO daoLancamentoCartao;
	private ContaDAO daoConta;
	private CartaoDAO daoCartao;
	private CategoriaDAO daoCategoria;
	private UsuarioDAO dao;
       
    public ExtratoServlet() {
        daoLancamento = DAOFactory.getLancamentoDAO();
        daoLancamentoCartao = DAOFactory.getLancamentoCartaoDAO();
        daoConta = DAOFactory.getContaDAO();
        daoCartao = DAOFactory.getCartaoDAO();
        daoCategoria = DAOFactory.getCategoriaDAO();
        dao = DAOFactory.getUsuarioDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
        String email = (String) session.getAttribute("user");
		String acao = request.getParameter("acao");
        List<Conta> listaConta = daoConta.getAll();
        List<CartaoDeCredito> listaCartao = daoCartao.getAll();
        List<Categoria> listaCategoria = daoCategoria.getAll();
		
		switch (acao) {
		case "listar":
			listar(request, response);
			break;
		case "abrir-form-edicao":
			abrirFormEdicao(request, response, listaConta, listaCartao, listaCategoria);
			break;
			
		case "abrir-form-cadastro":
			abrirFormCadastro(request, response, listaConta, listaCartao, listaCategoria);
		}
        
        listar(request, response);
	}

	private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response, List<Conta> listaConta, List<CartaoDeCredito> listaCartao, List<Categoria> listaCategoria) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String email = (String) session.getAttribute("user");
        
        request.setAttribute("listaConta", listaConta);
        request.setAttribute("listaCartao", listaCartao);
        request.setAttribute("listaCategoria",listaCategoria);
		
		request.getRequestDispatcher("newData.jsp").forward(request, response);
		
	}

	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response, List<Conta> listaConta, List<CartaoDeCredito> listaCartao, List<Categoria> listaCategoria) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("codigo"));
		String tipo = request.getParameter("tipo");
		request.setAttribute("listaCategoria", listaCategoria);
		
		if(tipo.equals("conta")) {
			request.setAttribute("lista", listaConta);
			Lancamento lancamento = daoLancamento.getById(id);
			request.setAttribute("lancamento", lancamento);	
		}
		if(tipo.equals("cartao")) {
			request.setAttribute("lista", listaCartao);
			LancamentoCartao lancamento = daoLancamentoCartao.getById(id);
			request.setAttribute("lancamento", lancamento);	
		}

		request.getRequestDispatcher("extratoEdit.jsp").forward(request, response);
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Lancamento> listaLancamento = daoLancamento.getAll();
        List<LancamentoCartao> listaLancamentoCartao = daoLancamentoCartao.getAll();
        List<Categoria> listaCategoria = daoCategoria.getAll();

        request.setAttribute("listaLancamento", listaLancamento);
        request.setAttribute("listaLancamentoCartao", listaLancamentoCartao);
        request.setAttribute("listaCategoria", listaCategoria);
        
 
		request.getRequestDispatcher("extrato.jsp").forward(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
        String email = (String) session.getAttribute("user");
		String acao = request.getParameter("acao");
		
        Usuario usuario = dao.capturaNome(email);
        int codigo = usuario.getCodigo();
		
		switch (acao) {
		case "cadastrar":
			cadastrar(request, response, codigo);
			break;
		case "editar":
			editar(request,response);
			break;
		case "excluir":
			excluir(request, response);
			break;
		}
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response, int codigo) throws ServletException, IOException {
		try {
			Double valor = Double.parseDouble(request.getParameter("valor")) ;
			String radio = request.getParameter("btnradio");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar data = Calendar.getInstance();
			try {
				data.setTime(format.parse(request.getParameter("date")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String descricao = request.getParameter("descricao");
			int categoria = Integer.parseInt(request.getParameter("categoria"));
			int codigoPai = Integer.parseInt(request.getParameter("select"));
			
			if(codigoPai % 2 != 0) {
				Lancamento lancamento = new Lancamento(0,radio,valor,descricao,data,categoria,codigoPai);
				daoLancamento.insert(lancamento);
				request.setAttribute("msg", "Lancamento criado!");
				listar(request,response);
			}else {
				LancamentoCartao lancamento = new LancamentoCartao(0,radio,valor,descricao,data,categoria,codigoPai);
				daoLancamentoCartao.insert(lancamento);
				request.setAttribute("msg", "Lancamento criado!");
				listar(request,response);
			}
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		}
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int codigoLancamento = Integer.parseInt(request.getParameter("codigoLancamento"));
			Double valor = Double.parseDouble(request.getParameter("valor")) ;
			String radio = request.getParameter("btnradio");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar data = Calendar.getInstance();
			try {
				data.setTime(format.parse(request.getParameter("date")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String descricao = request.getParameter("descricao");
			int categoria = Integer.parseInt(request.getParameter("categoria"));
			int codigoPai = Integer.parseInt(request.getParameter("select"));
			
			
			if(codigoPai % 2 == 0) {
				LancamentoCartao lancamento = new LancamentoCartao(codigoLancamento,radio,valor,descricao,data,categoria,codigoPai);
			    daoLancamentoCartao.update(lancamento);
			}else {
				Lancamento lancamento = new Lancamento(codigoLancamento,radio,valor,descricao,data,categoria,codigoPai);
				daoLancamento.update(lancamento);
			}
			request.setAttribute("msg", "Lancamento atualizado!");
		listar(request,response);
		
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		System.out.println();
		try {
				if(codigo % 2 == 0) {
					daoLancamentoCartao.delete(codigo);
				}
				else {
					daoLancamento.delete(codigo);
				}
				listar(request,response);
				request.setAttribute("msg", "Produto removido!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao remover");
		}

		listar(request,response);
	}

}
