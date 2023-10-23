package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Pacote;

public class PacoteDAO {
	public static void save(Pacote pacote) {
		String sql;
		
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			sql = pacote.getId() == 0 ?
				"INSERT INTO Pacote(nome, valorPacote) VALUES(?,?)"
			:
				 "UPDATE Pacote SET nome = ?, valorPacote = ? WHERE idPacote = ?"
			;
		
			con = ConnectionFactory.createConnection();
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, pacote.getNome());
			pstm.setFloat(2, pacote.getValor());
			
			if(pacote.getId() != 0) {
				pstm.setInt(3, pacote.getId());
			}
			
			pstm.execute();
			System.out.println("Pacote cadastrado com sucesso!!!");
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
	
	public static List<Pacote> read(){
		String sql = "SELECT * FROM Pacote";
		List<Pacote> pacotes = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			con = ConnectionFactory.createConnection();
			pstm = con.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Pacote pacote = new Pacote();
				pacote.setId(rset.getInt("idPacote"));
				pacote.setNome(rset.getString("nome"));
				pacote.setValor(rset.getFloat("valorPacote"));
				
				pacotes.add(pacote);
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
		return pacotes;
	}
	
	public static Pacote readById(int id) {
		String sql = "select * from pacote WHERE idPacote = ?";

		Pacote pacote = new Pacote();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			con = ConnectionFactory.createConnection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				pacote.setId(rset.getInt("idPacote"));
				pacote.setNome(rset.getString("nome"));
				pacote.setValor(rset.getFloat("valorPacote"));				
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
		return pacote;
	}
	
	
	public static void deleteById(int id) {
		String sql = "DELETE FROM Pacote WHERE idPacote = ?";
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = ConnectionFactory.createConnection();
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
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
