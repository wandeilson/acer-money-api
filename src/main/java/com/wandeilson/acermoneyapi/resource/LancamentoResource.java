package com.wandeilson.acermoneyapi.resource;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wandeilson.acermoneyapi.event.RecursoCriadoEvent;
import com.wandeilson.acermoneyapi.exceptionhandler.AcerMoneyExceptionHandler.Erro;
import com.wandeilson.acermoneyapi.model.Lancamento;
import com.wandeilson.acermoneyapi.repository.LancamentoRepository;
import com.wandeilson.acermoneyapi.repository.filter.LancamentoFilter;
import com.wandeilson.acermoneyapi.service.LancamentoService;
import com.wandeilson.acermoneyapi.service.exception.PessoaInexistenteOuInativaException;
@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private LancamentoService lancamentoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private MessageSource messageSource;
	
	
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public Page<Lancamento> pesquisar(LancamentoFilter lancametoFilter, Pageable pageable){
		return lancamentoRepository.filtrar(lancametoFilter, pageable);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Lancamento> buscarPeloCodigo( @PathVariable Long codigo ){
		Lancamento lancamentoBuscado = lancamentoRepository.findOne(codigo);
		return lancamentoBuscado != null ? ResponseEntity.ok(lancamentoBuscado) : ResponseEntity.notFound().build() ;
	}
	
	@PostMapping
	public ResponseEntity<Lancamento> criar ( @Valid @RequestBody Lancamento lancamento, HttpServletResponse response ){
		Lancamento lancamentoSalvo = lancamentoService.salvar(lancamento);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover (@PathVariable Long codigo) {
		lancamentoRepository.delete(codigo);
		
	}
	
	@ExceptionHandler({PessoaInexistenteOuInativaException.class})
	public ResponseEntity<Object> handdlePessoaInexistenteOuInativaException(PessoaInexistenteOuInativaException ex){
		String mensagemUsuario = messageSource.getMessage("pessoa.inexistente-ou-inativa", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
		return ResponseEntity.badRequest().body(erros);
	}
	
}
