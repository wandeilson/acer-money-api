package com.wandeilson.acermoneyapi.repository.lancamento;

import java.util.List;

import com.wandeilson.acermoneyapi.model.Lancamento;
import com.wandeilson.acermoneyapi.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {

	public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
}
