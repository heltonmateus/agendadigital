package br.com.iftm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.iftm.dao.CidadeDAO;
import br.com.iftm.entity.Cidade;
import br.com.iftm.entity.enums.Estado;

@Repository
public class CidadeDAOImpl implements CidadeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private List<Cidade> lista = new ArrayList<>();
	// private int indice = 0;

	@Override
	public Cidade create(Cidade cidade) {

		sessionFactory.getCurrentSession().save(cidade);
		sessionFactory.getCurrentSession().flush();

		// cidade.setCodigo(indice++);
		// lista.add(cidade);
		return cidade;

	}

	@Override
	public List<Cidade> read() {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cidade.class);

		return criteria.list();
	}

	@Override
	public List<Cidade> readByEstado(Estado estado) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cidade.class);

		criteria.add(Restrictions.eq("estado", estado));

		return criteria.list();

		/*
		 * List<Cidade> listaRetorno = new ArrayList<>();
		 * 
		 * for (Cidade cidade : lista) {
		 * 
		 * if (cidade.getEstado().equals(estado)) { listaRetorno.add(cidade);
		 * 
		 * return listaRetorno;
		 * 
		 * }
		 */
	}

	@Override
	public Cidade update(Cidade cidade) {

		sessionFactory.getCurrentSession().update(cidade);
		sessionFactory.getCurrentSession().flush();

		/*
		 * for (Cidade cidade2 : lista) {
		 * 
		 * if (cidade2.getCodigo().equals(cidade.getCodigo())) {
		 * cidade2.setNome(cidade.getNome()); cidade2.setEstado(cidade.getEstado()); }
		 * 
		 * }
		 */
		return cidade;
	}

	@Override
	public void delete(Integer id) {

		Cidade cidade = new Cidade();
		cidade.setCodigo(id);

		sessionFactory.getCurrentSession().delete(cidade);

		/*
		 * for (Cidade cidade2 : lista) {
		 * 
		 * if (cidade2.getCodigo().equals(id)) { lista.remove(cidade2); break; }
		 */

	}

}
