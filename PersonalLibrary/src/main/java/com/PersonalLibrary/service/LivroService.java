package com.PersonalLibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PersonalLibrary.model.Livro;
import com.PersonalLibrary.repository.LivroRepository;

@Service
public class LivroService {
    private LivroRepository repository;

    @Autowired
    public LivroService(LivroRepository repository){
        this.repository = repository;
    }

    public Livro criarLivro(Livro livro){
        return repository.save(livro);
    }

    public Livro buscarLivro(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado com id: " + id));
    }

    public List<Livro> listarLivro(){
        return repository.findAll();
    }

    public Livro editarLivro(Livro livro){
        if(!repository.existsById(livro.getId())){
            throw new RuntimeException("Livro não encontrado com id: " + livro.getId());
        }

        return repository.save(livro);
    }

    public void deletarLivro(Long id){
        if (!repository.existsById(id)) {
            throw new RuntimeException("Livro não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
