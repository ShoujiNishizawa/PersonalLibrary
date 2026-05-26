package com.PersonalLibrary.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.PersonalLibrary.model.Livro;

public interface LivroRepository extends CrudRepository<Livro, Long> {
    public List<Livro> findAll();
}