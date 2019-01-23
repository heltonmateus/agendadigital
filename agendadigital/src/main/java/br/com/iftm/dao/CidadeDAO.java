package br.com.iftm.dao;

import java.util.List;

import br.com.iftm.entity.Cidade;
import br.com.iftm.entity.TipoServico;
import br.com.iftm.entity.enums.Estado;;

public interface CidadeDAO {

	/**
	 * Metodo responsavel por persistir o objeto{@link TipoServico} na base de
	 * dados.
	 * 
	 * @param tipoServico Objeto a ser persistido.
	 * @return Objeto persistido.
	 */
	Cidade create(Cidade cidade);

	/**
	 * metodo reponsavel por recuperar da base de dados todos os objeto
	 * {@link TipoServico}
	 * 
	 * @return lista de {@link TipoServico}
	 */
	List<Cidade> read();

	/**
	 * metodo reponsavel por recuperar da base de dados todos os objeto
	 * {@link TipoServico}, cujo seu nome possua parte do parametro Nome.
	 * 
	 * @param nome
	 * @return lista de {@link TipoServico}
	 */
	List<Cidade> readByEstado(Estado estado);

	/**
	 * metodo reponsavel por persistir (atualizar) na base de dados o objeto
	 * {@link TipoServico}
	 * 
	 * @param TipoServico objeto a ser persistido
	 * @return Objeto persistido
	 */
	Cidade update(Cidade cidade);

	/**
	 * metodo reponsavel por excluir da base de dados o objeto {@link TipoServico}
	 * referente ao id informado
	 * 
	 * @param id identificador do objeto {@link TipoServico} a ser excluido
	 * 
	 */
	void delete(Integer id);

	// List<Cidade> readByName(Estado estado);

}
