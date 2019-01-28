package br.com.iftm.dao;

import java.util.List;

import br.com.iftm.controller.dto.FiltroPrestadorDTO;
import br.com.iftm.entity.PrestadorServico;

public interface PrestadorServicoDAO {

	PrestadorServico create(PrestadorServico prestadorServico);

	List<PrestadorServico> read();

	// alterado nome
	List<PrestadorServico> readByCidade(String cidade);

	PrestadorServico update(PrestadorServico prestadorServico);

	void delete(Integer id);

	List<PrestadorServico> readyByFiltros(FiltroPrestadorDTO FiltroPrestadorDTO);

}
