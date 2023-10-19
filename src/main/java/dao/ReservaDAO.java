package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Reserva;

public class ReservaDAO {
	public static void cadastrar(Reserva reserva) {
		String sql = "INSERT INTO Reserva(idCliente, idDestino, idPacote, dataPartida, dataRetorno, valorTotal)" + "VALUES(?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = ConnectionFactory.createConnection();
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, reserva.getCliente().getId());
			pstm.setInt(2, reserva.getDestino().getId());
			pstm.setInt(3, reserva.getPacote().getId());
			pstm.setDate(4, new Date(reserva.getDataPartida().getTime()));
			pstm.setDate(5, new Date(reserva.getDataRetorno().getTime()));
			pstm.setFloat(6, reserva.getValorTotal());
			
			
			pstm.execute();
			System.out.println("Reserva cadastrada com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(con != null) {
					con.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void listarReserva(){
		String sql = "SELECT * FROM Reserva";
		List<Reserva> Reservas = new ArrayList<Reserva>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			con = ConnectionFactory.createConnection();
			pstm = con.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Reserva reserva = new Reserva();
				int idCliente = rset.getInt("idCliente");
				int idDestino = rset.getInt("idDestino");
				int idPacote = rset.getInt("idPacote");

				reserva.setId(rset.getInt("idReserva"));
				reserva.setCliente(ClienteDAO.consultarCliente(idCliente));
				reserva.setDestino(DestinoDAO.consultarDestino(idDestino));
				reserva.setPacote(PacoteDAO.consultarPacote(idPacote));
				reserva.setDataPartida(rset.getDate("dataPartida"));
				reserva.setDataRetorno(rset.getDate("dataRetorno"));
				reserva.setValorTotal(rset.getFloat("valorTotal"));
				
				Reservas.add(reserva);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(con != null) {
					con.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (Reserva reserva : Reservas) {
			reserva.mostrar();
		}
	}
	
	public static Reserva consultarReserva(int id) {
		String sql = "select * from reserva WHERE idReserva = ?";

		Reserva reserva = new Reserva();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			con = ConnectionFactory.createConnection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				int idCliente = rset.getInt("idCliente");
				int idDestino = rset.getInt("idDestino");
				int idPacote = rset.getInt("idPacote");
				
				reserva.setId(rset.getInt("idReserva"));
				reserva.setCliente(ClienteDAO.consultarCliente(idCliente));
				reserva.setDestino(DestinoDAO.consultarDestino(idDestino));
				reserva.setPacote(PacoteDAO.consultarPacote(idPacote));
				reserva.setDataPartida(rset.getDate("dataPartida"));
				reserva.setDataRetorno(rset.getDate("dataRetorno"));
				reserva.setValorTotal(rset.getFloat("valorTotal"));				
			}
			
				
			
		} catch (Exception e) {
			System.out.println("Reserva nao encontrada.");
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(con != null) {
					con.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return reserva;
	}
	
	public static void atualizar(Reserva reserva) {
		String sql = "UPDATE reserva SET idCliente = ?, idDestino = ?, idPacote = ?, dataPartida = ?, dataRetorno = ?, valorTotal = ? " + "WHERE idReserva = ?";
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = ConnectionFactory.createConnection();
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, reserva.getCliente().getId());
			pstm.setInt(2, reserva.getDestino().getId());
			pstm.setInt(3, reserva.getPacote().getId());
			pstm.setDate(4, new Date(reserva.getDataPartida().getTime()));
			pstm.setDate(5, new Date(reserva.getDataRetorno().getTime()));
			pstm.setFloat(6, reserva.getValorTotal());
			pstm.setInt(7, reserva.getId());
			
			pstm.execute();
			
			System.out.println("Registro alterado com sucesso!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(con != null) {
					con.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void removerPorId(int id) {
		String sql = "DELETE FROM reserva WHERE idReserva = ?";
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = ConnectionFactory.createConnection();
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			System.out.println("Reserva removida com sucesso!!!");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(con != null) {
					con.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
