package com.pratica.ps.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pratica.ps.domain.Categoria;
import com.pratica.ps.services.CategoriaService;

@RestController
@RequestMapping(value="/categoria")
public class CategoriaResouces {
	@Autowired
	private CategoriaService servece;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Categoria obj = servece.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
