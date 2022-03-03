package com.estoque.fgss.service;

import com.estoque.fgss.model.Produto;
import com.estoque.fgss.repositories.EstoqueRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public List<Produto> buscarTodosProdutos() {
        return estoqueRepository.findAll();
    }

    @Transactional
    public Object cadastrarProduto(Produto produto) {
        return estoqueRepository.save(produto);
    }

    public boolean nomeExistente(String nome) {
        return estoqueRepository.existsByNome(nome);
    }

    public Produto mesclarProdutoCasoJaExistir(Produto produto) {
        Produto produtoPorNome = new Produto();
        BeanUtils.copyProperties(estoqueRepository.findByNome(produto.getNome()), produtoPorNome);

        produto = produtoPorNome;

        produto.setQuantidade(produtoPorNome.getQuantidade() + produto.getQuantidade());

        return produto;
    }

}
