package com.cba.edu.ifmt.GerenciadorDePessoas.service;

import com.cba.edu.ifmt.GerenciadorDePessoas.dto.request.PessoaDTO;
import com.cba.edu.ifmt.GerenciadorDePessoas.dto.response.MessageResponseDTO;
import com.cba.edu.ifmt.GerenciadorDePessoas.entity.Pessoa;
import com.cba.edu.ifmt.GerenciadorDePessoas.exeption.PessoaNotFoundExeption;
import com.cba.edu.ifmt.GerenciadorDePessoas.mapper.PessoaMapper;
import com.cba.edu.ifmt.GerenciadorDePessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @PostMapping
    public MessageResponseDTO criaPessoa(PessoaDTO pessoaDTO) {

        Pessoa pessoaParaSalva = pessoaMapper.toModel(pessoaDTO);

        Pessoa pessoaSalva = pessoaRepository.save(pessoaParaSalva);
        return MessageResponseDTO
                .builder()
                .message("Pessoa criada com o id : " + pessoaSalva.getId())
                .build();
    }

    public List<PessoaDTO> listaAll() {
        List<Pessoa> allPeople = pessoaRepository.findAll();
        return allPeople.stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PessoaDTO procuraPorId(Long Id) throws PessoaNotFoundExeption {
        Pessoa pessoa = pessoaRepository.findById(Id).orElseThrow(() -> new PessoaNotFoundExeption(Id));
        return pessoaMapper.toDTO(pessoa);
    }
}
