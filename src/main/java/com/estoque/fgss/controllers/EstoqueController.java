package com.estoque.fgss.controllers;

import com.estoque.fgss.dto.ProdutoDto;
import com.estoque.fgss.model.Produto;
import com.estoque.fgss.service.EstoqueService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    EstoqueService estoqueService;

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodosProdutos() {
        return ResponseEntity.status(HttpStatus.OK).body((estoqueService.buscarTodosProdutos()));
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarProduto(@RequestBody @Valid ProdutoDto produtoDto) {
        var produto = new Produto();
        BeanUtils.copyProperties(produtoDto, produto);

        if (estoqueService.nomeExistente(produto.getNome())) {

            //Irá ficar mesclado
            produto = estoqueService.mesclarProdutoCasoJaExistir(produto);

            estoqueService.cadastrarProduto(produto);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("'" + produto.getNome() + "'" + " foi cadastrado com Sucesso");
        }
        estoqueService.cadastrarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("'" + produto.getNome() + "'" + " foi cadastrado com Sucesso");
    }
}
