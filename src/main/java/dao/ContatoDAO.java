package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Contato;

public class ContatoDAO {
	public static void save(Contato contato) {
		String sql;
		sql = contato.getId() == 0 ?
			"INSERT INTO contato(nome, email, mensagem) VALUES(?,?,?)"
				:
			"UPDATE contato SET nome = ?, email = ?, mensagem = ? WHERE idContato = ?"
		;
				
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = ConnectionFactory.createConnection();
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getEmail());
			pstm.setString(3, contato.getMensagem());
			
			if(contato.getId() != 0) {
				pstm.setInt(4, contato.getId());
			}
			
			pstm.execute();
			System.out.println("Mensagem cadastrada com sucesso!!!");
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
	
	public static List<Contato> read(){
		String sql = "SELECT * FROM Contato";
		List<Contato> contatos = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			con = ConnectionFactory.createConnection();
			pstm = con.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Contato contato = new Contato();
				contato.setId(rset.getInt("idContato"));
				contato.setNome(rset.getString("nome"));
				contato.setEmail(rset.getString("email"));
				contato.setMensagem(rset.getString("mensagem"));
				
				contatos.add(contato);
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
		return contatos;
	}

	public static Contato readById(int id) {
		String sql = "select * from contato WHERE idContato = ?";
	
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Contato contato = new Contato();
		
		try {
			con = ConnectionFactory.createConnection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				contato.setId(rset.getInt("idContato"));
				contato.setNome(rset.getString("nome"));
				contato.setEmail(rset.getString("email"));
				contato.setMensagem(rset.getString("mensagem"));					
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
		return contato;
	}

	public static void deleteById(int id) {
		String sql = "DELETE FROM contato WHERE IdContato = ?";
		
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
