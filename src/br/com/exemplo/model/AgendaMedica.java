package br.com.exemplo.model;

import java.util.Date;

public class AgendaMedica {
	
	private Long id;
	private Date dataAgenda;
	private Medico medico;
	private LocalAtendimento localAtendimento;
	private Situacao situacao;
	
	public String toString() {
		return dataAgenda.toString(); 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataAgenda() {
		return dataAgenda;
	}

	public void setDataAgenda(Date dataAgenda) {
		this.dataAgenda = dataAgenda;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public LocalAtendimento getLocalAtendimento() {
		return localAtendimento;
	}

	public void setLocalAtendimento(LocalAtendimento localAtendimento) {
		this.localAtendimento = localAtendimento;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
}
