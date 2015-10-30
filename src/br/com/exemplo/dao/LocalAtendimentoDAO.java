package br.com.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.exemplo.fatory.ConnectionFactory;
import br.com.exemplo.model.LocalAtendimento;

public class LocalAtendimentoDAO extends ConnectionFactory {

	private static ResultSet rs = null;
	private static PreparedStatement stmt;

	Connection conn = criaConexao();

	private LocalAtendimentoDAO instance = null;

	public LocalAtendimentoDAO getInstance() {
		if (instance == null) {
			return new LocalAtendimentoDAO();
		}
		return instance;
	}

	public ArrayList<LocalAtendimento> listarTodosLocais() {
		ArrayList<LocalAtendimento> lista = new ArrayList<LocalAtendimento>();

		try {
			stmt = conn.prepareStatement("select * from tb_local_atendimento");
			rs = stmt.executeQuery();
			while (rs.next()) {
				LocalAtendimento local = new LocalAtendimento();

				local.setNome(rs.getString("nome"));
				local.setEndereco(rs.getString("endereco"));

				lista.add(local);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
}