package br.com.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.exemplo.fatory.ConnectionFactory;
import br.com.exemplo.model.Especialidade;
import br.com.exemplo.model.Medico;

public class MedicoDAO extends ConnectionFactory {

	private static ResultSet rs = null;
	private static PreparedStatement stmt;

	Connection conn = criaConexao();

	private MedicoDAO instance = null;

	public MedicoDAO getInstance() {
		if (instance == null) {
			return new MedicoDAO();
		}
		return instance;
	}

	public ArrayList<Medico> listarTodasEspecialidades() {
		ArrayList<Medico> lista = new ArrayList<Medico>();

		try {
			stmt = conn.prepareStatement("select * from tb_medico");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Medico med = new Medico();

				med.setId(rs.getLong("id"));
				med.setCrm(rs.getInt("crm"));
				med.setNome(rs.getString("nome"));

				Especialidade esp = new EspecialidadeDAO().buscaEspecialidade(rs.getInt("idEspecialidade"));

				med.setEspecialidade(esp);

				lista.add(med);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
}
