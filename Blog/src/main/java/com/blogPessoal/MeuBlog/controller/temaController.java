package com.blogPessoal.MeuBlog.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogPessoal.MeuBlog.model.Tema;
import com.blogPessoal.MeuBlog.repository.TemaRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping ("/temas")
public class temaController {
	
	@Autowired
	private TemaRepository repository;
	
	@GetMapping
	public ResponseEntity <List<Tema>> getAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("{/id}")
	public ResponseEntity<Tema> getById(@PathVariable long id)
	{
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp) )
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Tema>> getByNeme(@PathVariable String nome)
	{
		return ResponseEntity.ok(repository.findAllByDescricaoContainsIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Tema> post (@RequestBody Tema tema)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity<Tema> put (@RequestBody Tema tema)
	{
		return ResponseEntity.ok(repository.save(tema));
	}
	
	@DeleteMapping("{/id}")
	public void delete (@PathVariable long id)
	{
		repository.deleteById(id);
	}

}
	