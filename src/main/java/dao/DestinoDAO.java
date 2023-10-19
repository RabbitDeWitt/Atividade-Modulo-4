package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Destino;

public class DestinoDAO {
	public static void cadastrar(Destino destino) {
		String sql = "INSERT INTO destino(nome, valor, estado, pais) VALUES(?,?,?,?)";
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = ConnectionFactory.createConnection();
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, destino.getNome());
			pstm.setFloat(2, destino.getValor());
			pstm.setString(3,destino.getEstado());
			pstm.setString(4, destino.getPais());
			
			pstm.execute();
			System.out.println("Destino cadastrado com sucesso!!!");
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
	
	public static void listarDestino(){
		String sql = "SELECT * FROM destino";
		List<Destino> destinos = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			con = ConnectionFactory.createConnection();
			pstm = con.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Destino destino = new Destino();
				destino.setId(rset.getInt("idDestino"));
				destino.setNome(rset.getString("nome"));
				destino.setEstado(rset.getString("estado"));
				destino.setPais(rset.getString("pais"));
				destino.setValor(rset.getFloat("valor"));
				
				destinos.add(destino);
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
		for(Destino destino : destinos) {
			destino.mostrar();
		}
	}
	
	public static Destino consultarDestino(int id) {
		String sql = "select * from destino WHERE idDestino = ?";

		Destino destino = new Destino();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			con = ConnectionFactory.createConnection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				destino.setId(rset.getInt("idDestino"));
				destino.setNome(rset.getString("nome"));
				destino.setEstado(rset.getString("estado"));
				destino.setPais(rset.getString("pais"));
				destino.setValor(rset.getFloat("valor"));
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
		return destino;
	}
	
	public static void atualizar(Destino destino) {
		String sql = "UPDATE destino SET nome = ?, estado = ?, pais = ?, valor = ?" + "WHERE idDestino = ?";
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = ConnectionFactory.createConnection();
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, destino.getNome());
			pstm.setString(2, destino.getEstado());
			pstm.setString(3, destino.getPais());
			pstm.setFloat(4, destino.getValor());
			pstm.setInt(5, destino.getId());
			
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
		String sql = "DELETE FROM destino WHERE idDestino = ?";
		
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
