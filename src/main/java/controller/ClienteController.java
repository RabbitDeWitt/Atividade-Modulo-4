package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;

@WebServlet("/cliente-save")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClienteController() {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cliente cliente = new Cliente();
		cliente.setNome(req.getParameter("nome"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String data = req.getParameter("data"); 
		try {
			cliente.setDataNasc(sdf.parse(data));
		}catch (Exception e) {
		}
		cliente.setTelefone(req.getParameter("telefone"));
		cliente.setNumPassaporte(req.getParameter("numPassaporte"));
		
		ClienteDAO.save(cliente);
		resp.sendRedirect("/Atividade-Modulo-4/pages/home/index.html");
	}
}
