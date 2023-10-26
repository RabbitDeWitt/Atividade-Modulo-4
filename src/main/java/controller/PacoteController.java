package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PacoteDAO;
import model.Pacote;

@WebServlet(urlPatterns = {"/pacote", "/pacote-save", "/pacote-delete"})
public class PacoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PacoteController() {
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String route = req.getServletPath();
		
		switch (route) {
		case "/pacote":
			read(req, resp);
			break;
		case "/pacote-save":
			save(req, resp);
			break;
		case "/pacote-delete":
			delete(req, resp);
			break;
		default:
			resp.sendRedirect("/Atividade-Modulo-4/pages/home/index.html");
			break;
		}
	}
	
	protected void read(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		List<Pacote> pacotes = PacoteDAO.read();
		req.setAttribute("pacotes", pacotes);
		RequestDispatcher rd = req.getRequestDispatcher("./pages/cadastros/pacote.jsp");
		rd.forward(req, resp);
	}

	protected void save(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Pacote pacote = new Pacote();
		
		if(req.getParameter("id") != null) {
			pacote.setId(Integer.parseInt(req.getParameter("id")));
		}
		
		pacote.setNome(req.getParameter("nome"));
		pacote.setValor(Float.parseFloat(req.getParameter("valor")));
		
		PacoteDAO.save(pacote);
		resp.sendRedirect("/Atividade-Modulo-4/pacote");
	}
	
	protected void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		PacoteDAO.deleteById(id);
		resp.sendRedirect("/Atividade-Modulo-4/pacote");
	}
}
