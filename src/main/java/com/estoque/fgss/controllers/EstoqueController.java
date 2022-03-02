package com.estoque.fgss.controllers;

import com.estoque.fgss.model.Produto;
import com.estoque.fgss.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstoqueController {

    @Autowired
    EstoqueService estoqueService;

    @GetMapping
    public List<Produto> buscarTodosProdutos(){
        return estoqueService.buscarTodosProdutos();
    }

    @PostMapping
    public void cadastrarProduto(@RequestBody Produto produto){
        estoqueService.cadastrarProduto(produto);
    }

}
