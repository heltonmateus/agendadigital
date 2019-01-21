package br.com.iftm.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iftm.entity.TipoServico;

@RestController //habilita classe como um servico rest
@RequestMapping(value="/tiposervico") //nome do servico
public class TipoServicoRest {
	
	private List<TipoServico> lista = new ArrayList<>();
	private int indice = 0;
	

	//create
	@PostMapping(name = "create")
	public ResponseEntity<?> create(@RequestBody TipoServico tipoServico){
		
		if(StringUtils.isEmpty(tipoServico.getNome())) {
			return ResponseEntity.badRequest().body("Nome requerido!");
		}
		
		tipoServico.setCodigo(indice++);
		lista.add(tipoServico);
		return ResponseEntity.ok(tipoServico);
		
	}
	
	//read
		@GetMapping		
		public ResponseEntity<?> read(){
			
			return ResponseEntity.ok(lista);
		}
	
	
	//update
		
		@PutMapping
		public ResponseEntity<?> updste(@RequestBody TipoServico tipoServico){
			
			if(tipoServico.getCodigo() == null) {
			
			return ResponseEntity.badRequest().body("Nome Requerido");
		}
		
		if(StringUtils.isEmpty(tipoServico.getNome())) {
			
			return ResponseEntity.badRequest().body("Nome Requerido!");
		}
		
		for(TipoServico tipoServico2 : lista) {
			
			if(tipoServico2.getCodigo().equals(tipoServico.getCodigo())) {
				tipoServico2.setNome(tipoServico.getNome());
			}
		}
		
		return ResponseEntity.ok(tipoServico);	 
		
		}
	
	//delete
		
		@DeleteMapping
		public ResponseEntity<?> delete(@RequestBody TipoServico tipoServico){
			
			if(tipoServico.getCodigo() == null) {
				
				return ResponseEntity.badRequest().body("Nome Requerido");
			}
			
			
			for(TipoServico tipoServico2 : lista) {				
				if(tipoServico2.getCodigo().equals(tipoServico.getCodigo())) {
					lista.remove(tipoServico2);
				}
			}
			
			return ResponseEntity.ok(tipoServico);
			
			
		
		}
		
	}

