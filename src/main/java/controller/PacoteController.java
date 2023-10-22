package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PacoteDAO;
import model.Pacote;

@WebServlet("/pacote-save")
public class PacoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PacoteController() {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Pacote pacote = new Pacote();
		pacote.setNome(req.getParameter("nome"));
		pacote.setValor(Float.parseFloat(req.getParameter("valor")));
		
		PacoteDAO.save(pacote);
		resp.sendRedirect("/Atividade-Modulo-4/pages/home/index.html");
	}
}
