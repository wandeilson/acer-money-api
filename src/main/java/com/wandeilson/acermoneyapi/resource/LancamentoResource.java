package com.wandeilson.acermoneyapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wandeilson.acermoneyapi.model.Lancamento;
import com.wandeilson.acermoneyapi.repository.LancamentoRepository;
@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<Lancamento> listar(){
		return lancamentoRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Lancamento> buscarPeloCodigo( @PathVariable Long codigo ){
		Lancamento lancamentoBuscado = lancamentoRepository.findOne(codigo);
		return lancamentoBuscado != null ? ResponseEntity.ok(lancamentoBuscado) : ResponseEntity.notFound().build() ;
	}
	
}
