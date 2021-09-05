package com.cba.edu.ifmt.GerenciadorDePessoas.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTelefone {

    CASA("Casa"),
    CELULAR("Celular"),
    COMERCIAL("Comercial");

    private final String descrição;
}
