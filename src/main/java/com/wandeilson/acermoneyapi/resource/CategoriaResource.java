package com.wandeilson.acermoneyapi.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public ResponseEntity<Categoria> criar (@Valid  @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria catSalva = categoriaRepository.save(categoria);
		//Utilizado p informar onde (url) foi salvo o novo registro. A info vai junto a response
		//no 'location' do Header
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
		.buildAndExpand(catSalva.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(catSalva);
	}
	@GetMapping("/{codigo}")
	public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo) {
		Categoria categoria = categoriaRepository.findOne(codigo);
		return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
	}

}
