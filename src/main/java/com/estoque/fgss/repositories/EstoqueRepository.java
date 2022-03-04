package com.estoque.fgss.repositories;

import com.estoque.fgss.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstoqueRepository extends MongoRepository<Produto, String> {

    Object findByNome(String nome);

    Object deleteByNome(String nome);

    boolean existsByNome(String nome);

}
