package com.wandeilson.acermoneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wandeilson.acermoneyapi.model.Lancamento;
import com.wandeilson.acermoneyapi.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery{


}
