package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.factory.DAOFactory;
import br.com.fiap.fintech.util.CriptografiaUtils;

/**
 * Servlet implementation class RegistroServlet
 */
@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO dao;
       
    public RegistroServlet() {
        dao = DAOFactory.getUsuarioDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nome = request.getParameter("name");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			senha = CriptografiaUtils.criptografar(senha);
			String phone = request.getParameter("phone");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(request.getParameter("data")));
			
			Usuario usuario = new Usuario(0, email, senha, nome, phone, data);
			
			dao.insert(usuario);
				
		}catch(Exception e) {
			request.setAttribute("msg", "Erro, Digite corretamente nos campos");
			e.printStackTrace();
			request.getRequestDispatcher("register.jsp").forward(request, response);

		}
		request.setAttribute("msg", "Conta Criada com sucesso!");
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
