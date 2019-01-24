package br.com.iftm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.iftm.dao.TipoServicoDAO;
import br.com.iftm.entity.TipoServico;

@Repository
public class TipoServicoDAOImpl implements TipoServicoDAO {

	// bd
	@Autowired
	private SessionFactory sessionFactory;

	private List<TipoServico> lista = new ArrayList<>();
	// private int indice = 0;

	@Override
	public TipoServico create(TipoServico tipoServico) {

		// tipoServico.setCodigo(indice++);
		// lista.add(tipoServico);

		sessionFactory.getCurrentSession().save(tipoServico);
		sessionFactory.getCurrentSession().flush();

		return tipoServico;
	}

	@Override
	public List<TipoServico> read() {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TipoServico.class);

		return criteria.list();
	}

	@Override
	public List<TipoServico> readByName(String nome) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TipoServico.class);

		criteria.add(Restrictions.like("nome", nome).ignoreCase());

		return criteria.list();

		/*
		 * List<TipoServico> listaRetorno = new ArrayList<>();
		 * 
		 * for (TipoServico tipoServico : lista) {
		 * 
		 * if (tipoServico.getNome().toUpperCase().contains(nome.toUpperCase())) {
		 * listaRetorno.add(tipoServico);
		 * 
		 * } }
		 * 
		 * return listaRetorno;
		 */
	}

	@Override
	public TipoServico update(TipoServico tipoServico) {

		sessionFactory.getCurrentSession().update(tipoServico);
		sessionFactory.getCurrentSession().flush();

		/*
		 * for (TipoServico tipoServico2 : lista) {
		 * 
		 * if (tipoServico2.getCodigo().equals(tipoServico.getCodigo())) {
		 * tipoServico2.setNome(tipoServico.getNome()); }
		 * 
		 * }
		 */
		return tipoServico;
	}

	@Override
	public void delete(Integer id) {
		
		TipoServico tipoServico = new TipoServico();
		tipoServico.setCodigo(id);
		
		sessionFactory.getCurrentSession().delete(tipoServico);

		/*for (TipoServico tipoServico2 : lista) {
			if (tipoServico2.getCodigo().equals(id)) {
				lista.remove(tipoServico2);
				break;
			}
			
			*/

		}

	}
}
