package com.blogPessoal.MeuBlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogPessoal.MeuBlog.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long>{
	
	public List<Tema> findAllByDescricaoContainsIgnoreCase(String d);

}
