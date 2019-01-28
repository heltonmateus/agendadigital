package br.com.iftm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import br.com.iftm.controller.dto.FiltroPrestadorDTO;
import br.com.iftm.dao.PrestadorServicoDAO;
import br.com.iftm.entity.PrestadorServico;

@Repository
public class PrestadorServicoDAOImpl implements PrestadorServicoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private List<PrestadorServico> lista = new ArrayList<>();
	// private int indice = 0;

	@Override
	public PrestadorServico create(PrestadorServico prestadorServico) {

		sessionFactory.getCurrentSession().save(prestadorServico);
		sessionFactory.getCurrentSession().flush();

		// prestadorServico.setCodigo(indice++);
		// lista.add(prestadorServico);
		return prestadorServico;
	}

	@Override
	public List<PrestadorServico> read() {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PrestadorServico.class);

		return criteria.list();
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

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PrestadorServico.class);

		criteria.add(Restrictions.eq("cidade", cidade));

		return criteria.list();

		/*
		 * List<PrestadorServico> listaRetorno = new ArrayList<>();
		 * 
		 * for (PrestadorServico prestadorServico : lista) {
		 * 
		 * if (prestadorServico.getCidade().equals(cidade)) {
		 * listaRetorno.add(prestadorServico);
		 * 
		 * } }
		 * 
		 * return listaRetorno;
		 */
	}

	@Override
	public PrestadorServico update(PrestadorServico prestadorServico) {

		sessionFactory.getCurrentSession().update(prestadorServico);
		sessionFactory.getCurrentSession().flush();

		/*
		 * for (PrestadorServico prestadorServico2 : lista) {
		 * 
		 * if (prestadorServico2.getCodigo().equals(prestadorServico.getCodigo())) {
		 * prestadorServico2.setNome(prestadorServico.getNome()); // adicionado
		 * prestadorServico2.setBairro(prestadorServico.getBairro());
		 * prestadorServico2.setCidade(prestadorServico.getCidade());
		 * prestadorServico2.setCep(prestadorServico.getCep());
		 * prestadorServico2.setTipoLogradouro(prestadorServico.getTipoLogradouro());
		 * prestadorServico2.setLogradouro(prestadorServico.getLogradouro());
		 * prestadorServico2.setComplemento(prestadorServico.getComplemento());
		 * prestadorServico2.setNumero(prestadorServico.getNumero());
		 * prestadorServico2.setEmail(prestadorServico.getEmail());
		 * prestadorServico2.setNome(prestadorServico.getNome());
		 * 
		 * break; }
		 * 
		 * }
		 */
		return prestadorServico;
	}

	@Override
	public void delete(Integer id) {

		PrestadorServico prestadorServico = sessionFactory.getCurrentSession().get(PrestadorServico.class, id);

		sessionFactory.getCurrentSession().delete(prestadorServico);

		/*
		 * for (PrestadorServico prestadorServico2 : lista) { if
		 * (prestadorServico2.getCodigo().equals(id)) { lista.remove(prestadorServico2);
		 * break; }
		 */

	}

	@Override
	public List<PrestadorServico> readyByFiltros(FiltroPrestadorDTO filtroPrestadorDTO) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PrestadorServico.class);
		Criteria criteriaCidade = criteria.createCriteria("cidade");

		if (!StringUtils.isEmpty(filtroPrestadorDTO.getNome())) {
			criteria.add(Restrictions.like("nome", filtroPrestadorDTO.getNome(), MatchMode.ANYWHERE).ignoreCase());
		}

		if (filtroPrestadorDTO.getEstado() != null) {
			criteria.add(Restrictions.eq("estado", filtroPrestadorDTO.getEstado()));
		}

		if (filtroPrestadorDTO.getCidade() != null && filtroPrestadorDTO.getCidade().getCodigo() != null) {
			criteria.add(Restrictions.eq("cidade", filtroPrestadorDTO.getCidade()));
		}

		if (filtroPrestadorDTO.getTipoServicos() != null && filtroPrestadorDTO.getTipoServicos().isEmpty()) {
			criteria.add(Restrictions.in("tipoServicos", filtroPrestadorDTO.getTipoServicos()));
		}

		return criteria.list();
	}
}
