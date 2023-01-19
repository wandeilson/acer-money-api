package com.wandeilson.acermoneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wandeilson.acermoneyapi.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
