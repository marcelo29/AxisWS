package br.com.exemplo.fatory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

public class ConnectionFactory {

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/AxisWS";
	private static final String USER = "postgres";
	private static final String PASSWORD = "flf";

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