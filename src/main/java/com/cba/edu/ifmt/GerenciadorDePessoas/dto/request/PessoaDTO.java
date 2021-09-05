package com.cba.edu.ifmt.GerenciadorDePessoas.dto.request;

import com.cba.edu.ifmt.GerenciadorDePessoas.entity.Telefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

    private Long Id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String primeiroNome;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String ultimoNome;

    @NotEmpty
    @CPF
    private String CPF;

    private String dataDeNascimento;

    @Valid
    @NotEmpty
    private List<Telefone> telefones;
}
