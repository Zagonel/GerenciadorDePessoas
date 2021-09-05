package com.cba.edu.ifmt.GerenciadorDePessoas.dto.request;

import com.cba.edu.ifmt.GerenciadorDePessoas.enums.TipoTelefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TelefoneDTO {

    private Long Id;

    @Enumerated(EnumType.STRING)
    private TipoTelefone tipo;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String numero;
}
