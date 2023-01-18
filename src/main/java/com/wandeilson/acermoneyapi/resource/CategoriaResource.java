package com.wandeilson.acermoneyapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wandeilson.acermoneyapi.model.Categoria;
import com.wandeilson.acermoneyapi.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")//Endereço da classe
public class CategoriaResource {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping //todos GET enviados para esse endereço irão cair aqui
	public List<Categoria> listar (){
		return categoriaRepository.findAll();
	}
}
