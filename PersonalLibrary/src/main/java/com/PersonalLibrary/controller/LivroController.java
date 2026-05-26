package com.PersonalLibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PersonalLibrary.model.Livro;
import com.PersonalLibrary.service.LivroService;

@CrossOrigin("*")
@RestController
@RequestMapping("/livros")
public class LivroController {

    private LivroService service;

    @Autowired
    public LivroController(LivroService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Livro> criarLivro(@RequestBody Livro livro){
        Livro novoLivro = service.criarLivro(livro);
        return ResponseEntity.status(201).body(novoLivro);
    }

    @GetMapping("/{id}")
    public Livro buscarLivro(@PathVariable Long id){
        return service.buscarLivro(id);
    }

    @GetMapping
    public List<Livro> listarLivro(){
        return service.listarLivro();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> editarLivro(@PathVariable Long id, @RequestBody Livro livro){
        livro.setId(id);
        service.editarLivro(livro);
        Livro livroEditado = service.editarLivro(livro);

        return ResponseEntity.ok(livroEditado);
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id){
        service.deletarLivro(id);
    }

}
