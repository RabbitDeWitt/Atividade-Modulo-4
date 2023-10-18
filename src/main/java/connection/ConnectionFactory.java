package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
	private static final String URL = "jdbc:mysql://localhost:3306/daviagens";

	public static Connection createConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		return con;
	}

	public static void main(String[]args) throws Exception{
		Connection con = createConnection();
		
		if(con != null) {
			System.out.println("O pai ta on!!!");
			con.close();
		}
	}
}
