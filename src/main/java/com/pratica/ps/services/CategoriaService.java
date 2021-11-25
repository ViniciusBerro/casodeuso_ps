package com.pratica.ps.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratica.ps.domain.Categoria;
import com.pratica.ps.repositories.CategoriaRepositoriry;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepositoriry repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}
