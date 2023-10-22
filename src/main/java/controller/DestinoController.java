package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoDAO;
import model.Destino;

@WebServlet("/destino-save")
public class DestinoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DestinoController() {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Destino destino = new Destino();
		destino.setNome(req.getParameter("nome"));
		destino.setEstado(req.getParameter("estado"));
		destino.setPais(req.getParameter("pais"));
		destino.setValor(Float.parseFloat(req.getParameter("valor")));
		
		DestinoDAO.save(destino);
		resp.sendRedirect("/Atividade-Modulo-4/pages/home/index.html");
	}
}
