package com.pratica.ps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratica.ps.domain.Categoria;

@Repository
public interface CategoriaRepositoriry extends JpaRepository<Categoria, Integer> {

}
