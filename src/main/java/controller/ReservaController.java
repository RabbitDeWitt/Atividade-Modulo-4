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
import dao.DestinoDAO;
import dao.PacoteDAO;
import dao.ReservaDAO;
import model.Cliente;
import model.Destino;
import model.Pacote;
import model.Reserva;

@WebServlet(urlPatterns = {"/reserva", "/reserva-save", "/reserva-delete"})
public class ReservaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReservaController() {
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("Served at: ").append(req.getContextPath());
		String route = req.getServletPath();
		List<Cliente> clientes = ClienteDAO.read();
		List<Destino> destinos = DestinoDAO.read();
		List<Pacote> pacotes = PacoteDAO.read();
		
		req.setAttribute("clientes", clientes);
		req.setAttribute("destinos", destinos);
		req.setAttribute("pacotes", pacotes);
		
		switch (route) {
		case "/reserva":
			read(req, resp);
			break;
		case "/reserva-save":
			save(req, resp);
			break;
		case "/reserva-delete":
			delete(req, resp);
			break;
		default:
			break;
		}
	}
	
	protected void read(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		List<Reserva> reservas = ReservaDAO.read();
		req.setAttribute("reservas", reservas);
		RequestDispatcher rd = req.getRequestDispatcher("./pages/cadastros/reserva.jsp");
		rd.forward(req, resp);
	}

	protected void save(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Reserva reserva = new Reserva();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		int idCliente = Integer.parseInt(req.getParameter("cliente"));
		int idDestino = Integer.parseInt(req.getParameter("destino"));
		int idPacote = Integer.parseInt(req.getParameter("pacote"));
		String dataPartida = req.getParameter("dataPartida");
		String dataRetorno = req.getParameter("dataRetorno");
		
		if(req.getParameter("id") != null) {
			reserva.setId(Integer.parseInt(req.getParameter("id")));
		}
		
		Destino destino = DestinoDAO.readById(idDestino);
		Pacote pacote = PacoteDAO.readById(idPacote);
		
		reserva.setCliente(ClienteDAO.readById(idCliente));
		reserva.setDestino(destino);
		reserva.setPacote(pacote);
		
		try {
			reserva.setDataPartida(sdf.parse(dataPartida));
			reserva.setDataRetorno(sdf.parse(dataRetorno));
		} catch (Exception e) {
		}
		
		reserva.setValorTotal(destino.getValor() + pacote.getValor());
		
		ReservaDAO.save(reserva);
		
		resp.sendRedirect("/Atividade-Modulo-4/reserva");
		
	}
	
	protected void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		ReservaDAO.deleteById(id);
		resp.sendRedirect("/Atividade-Modulo-4/reserva");
	}
}
