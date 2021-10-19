package com.pratica.ps.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.pratica.ps.domain.Categoria;

@RestController
@RequestMapping(value="/categoria")
public class CategoriaResouces {
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		
		Categoria cat1 = new Categoria(1, "Informatica");
		Categoria cat2 = new Categoria(2, "Escritorio");
		
		List<Categoria> lista = new ArrayList<>();
		
		lista.add(cat1);
		lista.add(cat2);
		
		return lista;
	}
}
