package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Pacote;

public class PacoteDAO {
	public static void cadastrar(Pacote pacote) {
		String sql = "INSERT INTO Pacote(nome, valorPacote) VALUES(?,?)";
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = ConnectionFactory.createConnection();
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, pacote.getNome());
			pstm.setFloat(2, pacote.getValor());
			
			
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
	
	public static void listarPacote(){
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
		for (Pacote pacote : pacotes) {
			pacote.mostrar();
		}
	}
	
	public static Pacote consultarPacote(int id) {
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
	
	public static void atualizar(Pacote pacote) {
		String sql = "UPDATE Pacote SET nome = ?, valorPacote = ?" + "WHERE idPacote = ?";
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = ConnectionFactory.createConnection();
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, pacote.getNome());
			pstm.setFloat(2, pacote.getValor());
			pstm.setInt(3, pacote.getId());
			
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
