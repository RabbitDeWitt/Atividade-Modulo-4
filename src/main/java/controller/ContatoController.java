package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDAO;
import model.Contato;

@WebServlet(urlPatterns = {"/contato-save"})
public class ContatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ContatoController() {
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String route = req.getServletPath();
		
		switch (route) {
		case "/contato-save":
			create(req, resp);
			break;

		default:
			break;
		}
	}

	protected void create(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Contato contato = new Contato();
		contato.setNome(req.getParameter("nome"));
		contato.setEmail(req.getParameter("email"));
		contato.setMensagem(req.getParameter("msg"));
		
		ContatoDAO.save(contato);
		
		resp.sendRedirect("/Atividade-Modulo-4/pages/home/index.html");
	}
}
