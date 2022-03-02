package com.estoque.fgss.service;

import com.estoque.fgss.model.Produto;
import com.estoque.fgss.repositories.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public List<Produto> buscarTodosProdutos(){
        return estoqueRepository.findAll();
    }

    public void cadastrarProduto(Produto produto){
        estoqueRepository.save(produto);
    }

}
