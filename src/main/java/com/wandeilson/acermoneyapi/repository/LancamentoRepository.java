package com.wandeilson.acermoneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wandeilson.acermoneyapi.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

	
}
