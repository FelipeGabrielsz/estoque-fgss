package com.estoque.fgss.service;

import com.estoque.fgss.model.Produto;
import com.estoque.fgss.repositories.EstoqueRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public List<Produto> buscarTodosProdutos() {
        return estoqueRepository.findAll();
    }

    public Object buscarProdutoPorNome(String nome){
        return estoqueRepository.findByNome(nome);
    }

    @Transactional
    public Object cadastrarProduto(Produto produto) {
        return estoqueRepository.save(produto);
    }

    @Transactional
    public void deletarProdutoPorNome(String nome){
        estoqueRepository.deleteByNome(nome);
    }

    public boolean nomeExistente(String nome) {
        return estoqueRepository.existsByNome(nome);
    }

    public Produto mesclarProdutoCasoJaExistir(Produto produto, Long qtd) {
        Produto produtoPorNome = new Produto();
        BeanUtils.copyProperties(estoqueRepository.findByNome(produto.getNome()), produtoPorNome);
        produto = produtoPorNome;

        Long valorRecebido = produtoPorNome.getQuantidade() + qtd;
        produto.setQuantidade(valorRecebido);
        return produto;
    }

}
