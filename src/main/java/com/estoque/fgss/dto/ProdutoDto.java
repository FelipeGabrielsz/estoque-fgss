package com.estoque.fgss.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {

    @NotBlank
    private String nome;

    private Long quantidade;

}
