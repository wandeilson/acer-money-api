package com.wandeilson.acermoneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wandeilson.acermoneyapi.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
}
