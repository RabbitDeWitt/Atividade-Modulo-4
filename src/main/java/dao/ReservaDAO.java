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
	public static void save(Reserva reserva) {
		String sql;
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
		sql = reserva.getId() == 0 ?
					"INSERT INTO Reserva(idCliente, idDestino, idPacote, dataPartida, dataRetorno, valorTotal) VALUES(?,?,?,?,?,?)"
				:
					"UPDATE reserva SET idCliente = ?, idDestino = ?, idPacote = ?, dataPartida = ?, dataRetorno = ?, valorTotal = ? WHERE idReserva = ?"
				;
		
			con = ConnectionFactory.createConnection();
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, reserva.getCliente().getId());
			pstm.setInt(2, reserva.getDestino().getId());
			pstm.setInt(3, reserva.getPacote().getId());
			pstm.setDate(4, new Date(reserva.getDataPartida().getTime()));
			pstm.setDate(5, new Date(reserva.getDataRetorno().getTime()));
			pstm.setFloat(6, reserva.getValorTotal());
			
			if(reserva.getId() != 0) {
				pstm.setInt(7, reserva.getId());
			}
			
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
	
	public static List<Reserva> read(){
		String sql = "SELECT * FROM Reserva";
		List<Reserva> reservas = new ArrayList<Reserva>();
		
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
				reserva.setCliente(ClienteDAO.readById(idCliente));
				reserva.setDestino(DestinoDAO.readById(idDestino));
				reserva.setPacote(PacoteDAO.readById(idPacote));
				reserva.setDataPartida(rset.getDate("dataPartida"));
				reserva.setDataRetorno(rset.getDate("dataRetorno"));
				reserva.setValorTotal(rset.getFloat("valorTotal"));
				
				reservas.add(reserva);
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
		return reservas;
	}
	
	public static Reserva readById(int id) {
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
				reserva.setCliente(ClienteDAO.readById(idCliente));
				reserva.setDestino(DestinoDAO.readById(idDestino));
				reserva.setPacote(PacoteDAO.readById(idPacote));
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
	
	public static void deleteById(int id) {
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
