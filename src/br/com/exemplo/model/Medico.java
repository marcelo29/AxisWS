package br.com.exemplo.model;

public class Medico {

	private Long id;
	private String nome;
	private int crm;
	private Especialidade especialidade;
	
	public Medico(Long id, String nome, int crm, Especialidade especialidade) {
		this.id = id;
		this.nome = nome;
		this.crm = crm;
		this.especialidade = especialidade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCrm() {
		return crm;
	}
	public void setCrm(int crm) {
		this.crm = crm;
	}
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	
	
}
