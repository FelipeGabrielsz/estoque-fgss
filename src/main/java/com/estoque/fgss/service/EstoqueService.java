package com.estoque.fgss.service;

import com.estoque.fgss.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EstoqueService {

    //Get
    public ResponseEntity<List<Produto>> buscarTodosProdutos(){

        return ResponseEntity.ok(null);
    }

    //Post
    public ResponseEntity<Object> cadastrarProduto(@RequestBody Produto produto){

        Object object = new Object();

        return ResponseEntity.ok(object);
    }

}
