package br.com.iftm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.PrestadorServicoBusiness;
import br.com.iftm.entity.PrestadorServico;

@RestController // habilita classe como um servico rest
@RequestMapping(value = "/prestadorServico") // nome do servico
public class PrestadorServicoRest {

	private List<PrestadorServico> lista = new ArrayList<>();
	private int indice = 0;

	@Autowired
	private PrestadorServicoBusiness business;

	// create
	@PostMapping(name = "create")
	public ResponseEntity<?> create(@RequestBody PrestadorServico prestadorServico) {

		try {
			prestadorServico = business.create(prestadorServico);

			return ResponseEntity.ok(prestadorServico);

		} catch (BusinessException e) {

			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {

			return ResponseEntity.badRequest().body(e);

		}
	}

	/*
	 * .............................................................................
	 */

	// read
	@GetMapping
	public ResponseEntity<?> read() {

		try {

			return ResponseEntity.ok(business.read());

		} catch (BusinessException e) {

			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {

			return ResponseEntity.badRequest().body(e);

		}

	}

	/*
	 * .............................................................................
	 */

	// leitura /filtro/nome?nome=xxx pelo nome

	/*
	 * @GetMapping("/filtro/nome") public ResponseEntity<?>
	 * readByName(@PathParam("nome") String nome) {
	 * 
	 * try {
	 * 
	 * List<PrestadorServico> readByName = business.readByName(nome);
	 * 
	 * if (readByName.isEmpty()) {
	 * 
	 * return ResponseEntity.notFound().build(); }
	 * 
	 * return ResponseEntity.notFound().build();
	 * 
	 * } catch (BusinessException e) {
	 * 
	 * e.printStackTrace(); return ResponseEntity.badRequest().body(e); } catch
	 * (Exception e) {
	 * 
	 * return ResponseEntity.badRequest().body(e);
	 * 
	 * } }
	 */

	@GetMapping("/filtro/nome")
	public ResponseEntity<?> readByName(@PathParam("cidade") String cidade) {
		try {

			List<PrestadorServico> readByCidade = business.readByCidade(cidade);

			if (readByCidade.isEmpty()) {

				return ResponseEntity.notFound().build();
			}

			return ResponseEntity.notFound().build();

		} catch (BusinessException e) {

			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {

			return ResponseEntity.badRequest().body(e);

		}
	}

	/*
	 * .............................................................................
	 */

	// update

	@PutMapping
	public ResponseEntity<?> update(@RequestBody PrestadorServico prestadorServico) {

		try {
			prestadorServico = business.update(prestadorServico);

		} catch (BusinessException e) {

			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);

		} catch (Exception e) {

			return ResponseEntity.badRequest().body(e);

		}
		return ResponseEntity.ok(prestadorServico);

	}

	/*
	 * .............................................................................
	 */

	// delete

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {

		try {
			business.delete(id);

			return ResponseEntity.ok().build();

		} catch (BusinessException e) {

			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);

		} catch (Exception e) {

			return ResponseEntity.badRequest().body(e);

		}

	}

}
