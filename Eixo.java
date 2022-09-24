package br.ifam.model.bean;

import java.io.Serializable;

public class Eixo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String nome;
	private String tipo;
	private String turma;
	private String observacao;
	private String curso;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
}
