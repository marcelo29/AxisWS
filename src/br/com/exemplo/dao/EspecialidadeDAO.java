package br.com.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.com.exemplo.fatory.ConnectionFactory;
import br.com.exemplo.model.Especialidade;

public class EspecialidadeDAO extends ConnectionFactory {

	private static ResultSet rs = null;
	private static PreparedStatement stmt;

	Connection conn = criaConexao();

	private EspecialidadeDAO instance = null;

	public EspecialidadeDAO getInstance() {
		if (instance == null) {
			return new EspecialidadeDAO();
		}
		return instance;
	}

	public ArrayList<Especialidade> listarTodasEspecialidades() {
		ArrayList<Especialidade> lista = new ArrayList<Especialidade>();

		try {
			stmt = conn.prepareStatement("select * from tb_especialidade");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Especialidade esp = new Especialidade();

				esp.setId(rs.getLong("id"));
				esp.setNome(rs.getString("nome"));
				lista.add(esp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
}