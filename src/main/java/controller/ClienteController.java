package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;

@WebServlet(urlPatterns = {"/cliente", "/cliente-save", "/cliente-delete"})
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClienteController() {
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String route = req.getServletPath();
		
		switch (route) {
		case "/cliente":
			read(req, resp);
			break;
		case "/cliente-save":
			save(req, resp);
			break;
		case "/cliente-delete":
			delete(req, resp);
			break;

		default:
			break;
		}
	}
	
	protected void read(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		List<Cliente> clientes = ClienteDAO.read();
		req.setAttribute("clientes", clientes);
		RequestDispatcher rd = req.getRequestDispatcher("./pages/cadastros/cliente.jsp");
		rd.forward(req, resp);
	}

	protected void save(HttpServletRequest req, HttpServletResponse resp)
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
		resp.sendRedirect("/Atividade-Modulo-4/cliente");
	}
	
	protected void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		ClienteDAO.deleteById(id);
		resp.sendRedirect("/Atividade-Modulo-4/cliente");
	}
}
