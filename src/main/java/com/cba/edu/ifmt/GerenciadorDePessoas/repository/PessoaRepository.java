package com.cba.edu.ifmt.GerenciadorDePessoas.repository;

import com.cba.edu.ifmt.GerenciadorDePessoas.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
