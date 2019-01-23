package br.com.iftm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.iftm.dao.PrestadorServicoDAO;
import br.com.iftm.entity.PrestadorServico;

@Repository
public class PrestadorServicoDAOImpl implements PrestadorServicoDAO {

	private List<PrestadorServico> lista = new ArrayList<>();
	private int indice = 0;

	@Override
	public PrestadorServico create(PrestadorServico prestadorServico) {

		prestadorServico.setCodigo(indice++);
		lista.add(prestadorServico);
		return prestadorServico;
	}

	@Override
	public List<PrestadorServico> read() {

		return lista;
	}

	/*
	 * @Override public List<PrestadorServico> readByName(String nome) {
	 * 
	 * List<PrestadorServico> listaRetorno = new ArrayList<>();
	 * 
	 * for (PrestadorServico prestadorServico : lista) {
	 * 
	 * if (prestadorServico.getNome().toUpperCase().contains(nome.toUpperCase())) {
	 * listaRetorno.add(prestadorServico);
	 * 
	 * } }
	 * 
	 * return listaRetorno; }
	 */

	@Override
	public List<PrestadorServico> readByCidade(String cidade) {

		List<PrestadorServico> listaRetorno = new ArrayList<>();

		for (PrestadorServico prestadorServico : lista) {

			if (prestadorServico.getCidade().equals(cidade)) {
				listaRetorno.add(prestadorServico);

			}
		}

		return listaRetorno;
	}

	@Override
	public PrestadorServico update(PrestadorServico prestadorServico) {

		for (PrestadorServico prestadorServico2 : lista) {

			if (prestadorServico2.getCodigo().equals(prestadorServico.getCodigo())) {
				prestadorServico2.setNome(prestadorServico.getNome());
				// adicionado
				prestadorServico2.setBairro(prestadorServico.getBairro());
				prestadorServico2.setCidade(prestadorServico.getCidade());
				prestadorServico2.setCep(prestadorServico.getCep());
				prestadorServico2.setTipoLogradouro(prestadorServico.getTipoLogradouro());
				// completarrrrrr

				break;
			}

		}
		return prestadorServico;
	}

	@Override
	public void delete(Integer id) {

		for (PrestadorServico prestadorServico2 : lista) {
			if (prestadorServico2.getCodigo().equals(id)) {
				lista.remove(prestadorServico2);
				break;
			}

		}

	}

}
