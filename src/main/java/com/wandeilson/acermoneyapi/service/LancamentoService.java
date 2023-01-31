package com.wandeilson.acermoneyapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wandeilson.acermoneyapi.model.Lancamento;
import com.wandeilson.acermoneyapi.model.Pessoa;
import com.wandeilson.acermoneyapi.repository.LancamentoRepository;
import com.wandeilson.acermoneyapi.repository.PessoaRepository;
import com.wandeilson.acermoneyapi.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {

	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	public Lancamento salvar(Lancamento lancamento) {
		Pessoa pessoa = pessoaRepository.findOne(lancamento.getPessoa().getCodigo());
		if(pessoa == null || pessoa.isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		}
		return lancamentoRepository.save(lancamento);
	}

}
