package com.cba.edu.ifmt.GerenciadorDePessoas.controller;


import com.cba.edu.ifmt.GerenciadorDePessoas.dto.request.PessoaDTO;
import com.cba.edu.ifmt.GerenciadorDePessoas.dto.response.MessageResponseDTO;
import com.cba.edu.ifmt.GerenciadorDePessoas.entity.Pessoa;
import com.cba.edu.ifmt.GerenciadorDePessoas.exeption.PessoaNotFoundExeption;
import com.cba.edu.ifmt.GerenciadorDePessoas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/pessoa")
public class PessoaController {

    private PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO criaPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
        return pessoaService.criaPessoa(pessoaDTO);
    }

    @GetMapping
    public List<PessoaDTO> listaAll() {
        return pessoaService.listaAll();
    }

    @GetMapping("/{id}")
    public PessoaDTO procuraPorId(@PathVariable Long Id) throws PessoaNotFoundExeption {
        return pessoaService.procuraPorId(Id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletaPorId(@PathVariable Long Id) throws PessoaNotFoundExeption {
        pessoaService.delete(Id);
    }
}
