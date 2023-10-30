package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDAO;
import model.Contato;

@WebServlet(urlPatterns = {"/pages/cadastros/contato", "/contato-save", "/contato-delete"})
public class ContatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ContatoController() {
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String route = req.getServletPath();
		
		switch (route) {
		case "/pages/cadastros/contato":
			read(req, resp);
			break;
		case "/contato-save":
			create(req, resp);
			break;
		case "/contato-delete":
			delete(req, resp);
			break;
		default:
			break;
		}
	}
	
	protected void read(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		List<Contato> contatos = ContatoDAO.read();
		req.setAttribute("contatos", contatos);
		RequestDispatcher rd = req.getRequestDispatcher("./contato.jsp");
		rd.forward(req, resp);
	}

	protected void create(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Contato contato = new Contato();
		
		if(req.getParameter("id") != null) {
			contato.setId(Integer.parseInt(req.getParameter("id")));
		}
		
		contato.setNome(req.getParameter("nome"));
		contato.setEmail(req.getParameter("email"));
		contato.setMensagem(req.getParameter("msg"));
		
		ContatoDAO.save(contato);
		
		resp.sendRedirect("/Atividade-Modulo-4/pages/cadastros/contato");
	}
	
	protected void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		ContatoDAO.deleteById(id);
		resp.sendRedirect("/Atividade-Modulo-4/pages/cadastros/contato");
	}
}
