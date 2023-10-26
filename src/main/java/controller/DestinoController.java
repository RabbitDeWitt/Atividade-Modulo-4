package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoDAO;
import model.Destino;

@WebServlet(urlPatterns = {"/destino", "/destino-save", "/destino-delete"})
public class DestinoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DestinoController() {
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String route = req.getServletPath();
		
		switch (route) {
		case "/destino":
			read(req, resp);
			break;
		case "/destino-save":
			save(req, resp);
			break;
		case "/destino-delete":
			delete(req, resp);
			break;
		default:
			resp.sendRedirect("/Atividade-Modulo-4/pages/home/index.html");
			break;
		}
	}
	
	protected void read(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		List<Destino> destinos = DestinoDAO.read();
		req.setAttribute("destinos", destinos);
		RequestDispatcher rd = req.getRequestDispatcher("./pages/cadastros/destino.jsp");
		rd.forward(req, resp);
	}

	protected void save(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Destino destino = new Destino();

		if(req.getParameter("id") != null) {
			destino.setId(Integer.parseInt(req.getParameter("id")));
		}
		
		destino.setNome(req.getParameter("nome"));
		destino.setEstado(req.getParameter("estado"));
		destino.setPais(req.getParameter("pais"));
		destino.setValor(Float.parseFloat(req.getParameter("valor")));
		
		DestinoDAO.save(destino);
		resp.sendRedirect("/Atividade-Modulo-4/destino");
	}
	
	protected void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		DestinoDAO.deleteById(id);
		resp.sendRedirect("/Atividade-Modulo-4/destino");
	}
}
