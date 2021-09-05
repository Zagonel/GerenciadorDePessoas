package com.cba.edu.ifmt.GerenciadorDePessoas.mapper;

import com.cba.edu.ifmt.GerenciadorDePessoas.dto.request.PessoaDTO;
import com.cba.edu.ifmt.GerenciadorDePessoas.entity.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PessoaMapper {
    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    @Mapping(target = "dataDeNascimento", source = "dataDeNascimento", dateFormat = "dd-MM-yyyy")
    Pessoa toModel(PessoaDTO pessoaDTO);

    PessoaDTO toDTO(Pessoa pessoa);
}
