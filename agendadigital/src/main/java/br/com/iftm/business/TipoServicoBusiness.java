package br.com.iftm.business;

import java.util.List;

import br.com.iftm.entity.TipoServico;

public interface TipoServicoBusiness {

	/**
	 * metodo responsavel por garantia os pareametros obrigatorios, bem como
	 * solicitar a camada de acesso a dados que persista o
	 * objeto({@link TipoServico}.
	 * 
	 * @param tiposervico objeto a ser persistido
	 * @return Objeto persistido
	 * @throws BusinessException
	 */
	TipoServico create(TipoServico tipoServico) throws BusinessException;

	/**
	 * metodo reponsavel por recuperar da base de dados todos os objeto
	 * {@link TipoServico}
	 * 
	 * @return lista de {@link TipoServico}
	 * @throws BusinessException
	 */
	List<TipoServico> read() throws BusinessException;

	/**
	 * metodo reponsavel por recuperar da base de dados todos os objeto
	 * {@link TipoServico}, cujo seu nome possua parte do parametro Nome.
	 * 
	 * @param nome
	 * @return lista de {@link TipoServico}
	 * @throws BusinessException
	 */
	List<TipoServico> readByName(String nome) throws BusinessException;

	/**
	 * metodo reponsavel por persistir (atualizar) na base de dados o objeto
	 * {@link TipoServico}
	 * 
	 * @param TipoServico objeto a ser persistido
	 * @return Objeto persistido
	 * @throws BusinessException
	 */
	TipoServico update(TipoServico tipoServico) throws BusinessException;

	/**
	 * metodo reponsavel por excluir da base de dados o objeto {@link TipoServico}
	 * referente ao id informado
	 * 
	 * @param id identificador do objeto {@link TipoServico} a ser excluido
	 * @throws BusinessException
	 * 
	 */
	void delete(Integer id) throws BusinessException;

}
