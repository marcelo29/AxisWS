package br.com.exemplo.fatory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

public class ConnectionFactory {

	private static final String DRIVER = "com.mysql.jdbc.driver";
	private static final String URL = "jdbc:mysql://localhost:3306/AxisWS";
	private static final String USER = "root";
	private static final String PASSWORD = "123";

	static Connection conn = null;

	public static Connection criaConexao() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			System.out.println("Erro na conexao com o banco de dados " + e);
			e.printStackTrace();
		}
		return conn;
	}

	public static void fechaConexao(Connection conn, ResultSet rs, PreparedStatement stmt) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			System.out.println("Erro na conexao com o banco de dados " + e);
			e.printStackTrace();
		}
	}
}