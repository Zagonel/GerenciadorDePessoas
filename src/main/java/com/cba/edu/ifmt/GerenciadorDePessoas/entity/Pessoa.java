package com.cba.edu.ifmt.GerenciadorDePessoas.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
    private String primeiroNome;
    @Column(nullable = false)
    private String ultimoNome;
    @Column(nullable = false, unique = true)
    private String CPF;
    private LocalDate dataDeNascimento;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST})
    private List<Telefone> telefones;
}
