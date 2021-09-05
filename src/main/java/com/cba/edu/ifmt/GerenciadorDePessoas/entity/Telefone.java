package com.cba.edu.ifmt.GerenciadorDePessoas.entity;

import com.cba.edu.ifmt.GerenciadorDePessoas.enums.TipoTelefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoTelefone tipo;
    @Column(nullable = false)
    private String numero;

}
