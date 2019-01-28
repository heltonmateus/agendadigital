package br.com.iftm.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.PrestadorServicoBusiness;
import br.com.iftm.controller.dto.FiltroPrestadorDTO;
import br.com.iftm.dao.PrestadorServicoDAO;
import br.com.iftm.entity.PrestadorServico;
import br.com.iftm.entity.Telefone;
import br.com.iftm.entity.TipoServico;

@Service
@Transactional
public class PrestadorServicoBusinessImpl implements PrestadorServicoBusiness {

	@Autowired
	private PrestadorServicoDAO dao;

	// validações
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PrestadorServico create(PrestadorServico prestadorServico) throws BusinessException {

		if (StringUtils.isEmpty(prestadorServico.getNome())) {
			throw new BusinessException("Nome requerido!");
		}

		if (prestadorServico.getCidade() == null || prestadorServico.getCidade().getCodigo() == null) {

			throw new BusinessException(" Cidade requerida!");
		}

		if (prestadorServico.getTipoLogradouro() == null) {

			throw new BusinessException(" Tipo Lougradoro requerida!");
		}

		if (prestadorServico.getLogradouro() == null) {

			throw new BusinessException(" Logradouro requerido!");

		}

		if (prestadorServico.getNumero() == null) {

			throw new BusinessException(" Numero requerido!");
		}

		if (prestadorServico.getBairro() == null || StringUtils.isEmpty(prestadorServico.getBairro())) {
			throw new BusinessException(" bairro requerido!");
		}

		if (prestadorServico.getTelefones() == null || prestadorServico.getTelefones().isEmpty()) {

			throw new BusinessException(" Telefone requerido!");
		}

		for (Telefone telefone : prestadorServico.getTelefones()) {

			if (telefone.getDdd() == null) {

				throw new BusinessException(" ddd requerido!");
			}

			if (telefone.getNumero() == null) {

				throw new BusinessException(" Telefone invalido!");
			}

			telefone.setPrestadorServico(prestadorServico);

		}

		if (prestadorServico.getTipoServicos() == null || prestadorServico.getTipoServicos().isEmpty()) {

			throw new BusinessException(" Servico requerido!");
		}

		for (TipoServico tipoServico : prestadorServico.getTipoServicos()) {

			if (tipoServico.getCodigo() == null) {
				throw new BusinessException(" codigo tipo servico requerido!");

			}

		}

		return dao.create(prestadorServico);
	}

	/*
	 * .............................................................................
	 * .............
	 */

	@Override
	@Transactional(readOnly = true)
	public List<PrestadorServico> read() throws BusinessException {

		return dao.read();
	}

	/*
	 * .............................................................................
	 * .............
	 */

	/*
	 * @Override public List<PrestadorServico> readByName(String nome) throws
	 * BusinessException {
	 * 
	 * if (StringUtils.isEmpty(nome)) {
	 * 
	 * throw new BusinessException("Nome Requerido"); }
	 * 
	 * return dao.readByName(nome);
	 * 
	 * }
	 */

	@Override
	@Transactional(readOnly = true)
	public List<PrestadorServico> readByCidade(String cidade) throws BusinessException {

		if (StringUtils.isEmpty(cidade)) {

			throw new BusinessException("Nome Requerido");
		}

		return dao.readByCidade(cidade);

	}

	/*
	 * .............................................................................
	 * .............
	 */

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PrestadorServico update(PrestadorServico prestadorServico) throws BusinessException {

		if (prestadorServico.getCodigo() == null) {

			throw new BusinessException("Nome Requerido");
		}

		if (StringUtils.isEmpty(prestadorServico.getNome())) {
			throw new BusinessException("Nome requerido!");
		}

		if (prestadorServico.getCidade() == null || prestadorServico.getCidade().getCodigo() == null) {

			throw new BusinessException(" Cidade requerida!");
		}

		if (prestadorServico.getTipoLogradouro() == null) {

			throw new BusinessException(" Tipo Lougradoro requerida!");
		}

		if (prestadorServico.getLogradouro() == null) {

			throw new BusinessException(" Logradouro requerido!");

		}

		if (prestadorServico.getNumero() == null) {

			throw new BusinessException(" Numero requerido!");
		}

		if (prestadorServico.getBairro() == null || StringUtils.isEmpty(prestadorServico.getBairro())) {
			throw new BusinessException(" bairro requerido!");
		}

		if (prestadorServico.getTelefones() == null || prestadorServico.getTelefones().isEmpty()) {

			throw new BusinessException(" Telefone requerido!");
		}

		for (Telefone telefone : prestadorServico.getTelefones()) {

			if (telefone.getDdd() == null) {

				throw new BusinessException(" ddd requerido!");
			}

			if (telefone.getNumero() == null) {

				throw new BusinessException(" Telefone invalido!");
			}

			telefone.setPrestadorServico(prestadorServico);

		}

		if (prestadorServico.getTipoServicos() == null || prestadorServico.getTipoServicos().isEmpty()) {

			throw new BusinessException(" Servico requerido!");
		}

		for (TipoServico tipoServico : prestadorServico.getTipoServicos()) {

			if (tipoServico.getCodigo() == null) {
				throw new BusinessException(" codigo tipo servico requerido!");

			}

		}

		return dao.update(prestadorServico);

	}

	/*
	 * .............................................................................
	 * .............
	 */

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Integer id) throws BusinessException {

		if (id == null) {

			throw new BusinessException("Nome Requerido");
		}

		dao.delete(id);

	}

	@Override
	@Transactional(readOnly = true)
	public List<PrestadorServico> readyByFiltros(FiltroPrestadorDTO FiltroPrestadorDTO) throws BusinessException {

		return dao.readyByFiltros(FiltroPrestadorDTO);
	}

}
