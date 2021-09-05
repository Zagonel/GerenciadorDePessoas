package com.cba.edu.ifmt.GerenciadorDePessoas.exeption;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaNotFoundExeption extends Exception{
    public PessoaNotFoundExeption(Long Id){
        super("Pessoa com o ID " + Id + " não foi encontrada");
    }
}
