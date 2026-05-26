package com.PersonalLibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nomeLivro;
    private int paginas;

    @Min(value = 0, message = "A avaliação não pode ser menor que 0.")
    @Max(value = 10, message = "A avaliação não pode ser maior que 10.")
    private int avaliacao;
    private String avaliacaoEscrita;

    public Livro(String nomeLivro, int paginas, int avaliacao, String avaliacaoEscrita){
        if(avaliacao < 0 || avaliacao > 10){
            throw new IllegalArgumentException("A avaliação deve ser entre 0 e 10!!");
        }
        this.nomeLivro = nomeLivro;
        this.paginas = paginas;
        this.avaliacao = avaliacao;
        this.avaliacaoEscrita = avaliacaoEscrita;
    }
}
