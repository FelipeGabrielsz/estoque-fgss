package com.estoque.fgss.service;

import com.estoque.fgss.dto.ProdutoDto;
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

    public List<Produto> buscarTodosProdutos(){
        return estoqueRepository.findAll();
    }

    @Transactional
    public Object cadastrarProduto(Produto produto){
        return estoqueRepository.save(produto);
    }

    public boolean nomeExistente(String nome){
        return estoqueRepository.existsByNome(nome);
    }

    public Long somarQuantidadeSeJaExistir(Produto produto, Long valorAtual){
        Produto produtoPorNome = new Produto();
        BeanUtils.copyProperties(estoqueRepository.findByNome(produto.getNome()), produtoPorNome);
        return produtoPorNome.getQuantidade() + valorAtual;
    }

    public Produto mesclarProdutoCasoJaExistir(Produto produto){

        var produtoPorNome = estoqueRepository.findByNome(produto.getNome());

        BeanUtils.copyProperties(produtoPorNome, produto);

        return produto;
    }

}
