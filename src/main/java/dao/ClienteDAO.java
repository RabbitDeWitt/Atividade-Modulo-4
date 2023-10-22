package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Cliente;

public class ClienteDAO {
	public static void save(Cliente cliente) {
		String sql;
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			
			sql = cliente.getId() == 0 ? 
				"INSERT INTO cliente(nome, dataNasc, telefone, numPassaporte) VALUES(?,?,?,?)"
			:
				"UPDATE cliente SET nome = ?, dataNasc = ?, telefone = ?, numPassaporte = ? WHERE idCliente = ?"				
			;
			
			con = ConnectionFactory.createConnection();
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, cliente.getNome());
			pstm.setDate(2, new Date(cliente.getDataNasc().getTime()));
			pstm.setString(3,cliente.getTelefone());
			pstm.setString(4, cliente.getNumPassaporte());
			
			if(cliente.getId() != 0) {
				pstm.setInt(5, cliente.getId());
			}
			
			pstm.execute();
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
	
	public static List<Cliente> read(){
		String sql = "SELECT * FROM Cliente";
		List<Cliente> clientes = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			con = ConnectionFactory.createConnection();
			pstm = con.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rset.getInt("idCliente"));
				cliente.setNome(rset.getString("nome"));
				cliente.setDataNasc(rset.getDate("dataNasc"));
				cliente.setTelefone(rset.getString("telefone"));
				cliente.setNumPassaporte(rset.getString("numPassaporte"));
				
				clientes.add(cliente);
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
		return clientes;
	}
	
	public static Cliente readById(int id) {
		String sql = "select * from cliente WHERE idCliente = ?";
	
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Cliente cliente = new Cliente();
		
		try {
			con = ConnectionFactory.createConnection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				cliente.setId(rset.getInt("idCliente"));
				cliente.setNome(rset.getString("nome"));
				cliente.setDataNasc(rset.getDate("dataNasc"));
				cliente.setTelefone(rset.getString("telefone"));
				cliente.setNumPassaporte(rset.getString("numPassaporte"));					
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
		return cliente;
	}
	
	
//	public static void atualizar(Cliente cliente) {
//		String sql = "UPDATE cliente SET nome = ?, dataNasc = ?, telefone = ?, numPassaporte = ?" + "WHERE idCliente = ?";
//		Connection con = null;
//		PreparedStatement pstm = null;
//		
//		try {
//			con = ConnectionFactory.createConnection();
//			pstm = con.prepareStatement(sql);
//			
//			pstm.setString(1, cliente.getNome());
//			pstm.setDate(2, new Date(cliente.getDataNasc().getTime()));
//			pstm.setString(3, cliente.getTelefone());
//			pstm.setString(4, cliente.getNumPassaporte());
//			pstm.setInt(5, cliente.getId());
//			
//			pstm.execute();
//			
//			System.out.println("Registro alterado com sucesso!!!");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(pstm != null) {
//					pstm.close();
//				}
//				if(con != null) {
//					con.close();
//				}
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
	public static void deleteById(int id) {
		String sql = "DELETE FROM cliente WHERE IdCliente = ?";
		
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
