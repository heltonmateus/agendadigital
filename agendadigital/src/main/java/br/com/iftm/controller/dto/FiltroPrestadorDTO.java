package br.com.iftm.controller.dto;

import java.util.Set;

import br.com.iftm.entity.Cidade;
import br.com.iftm.entity.TipoServico;
import br.com.iftm.entity.enums.Estado;

public class FiltroPrestadorDTO {

	private String nome;

	private Estado estado;

	private Cidade cidade;

	private Set<TipoServico> tipoServicos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Set<TipoServico> getTipoServicos() {
		return tipoServicos;
	}

	public void setTipoServicos(Set<TipoServico> tipoServicos) {
		this.tipoServicos = tipoServicos;
	}

}
