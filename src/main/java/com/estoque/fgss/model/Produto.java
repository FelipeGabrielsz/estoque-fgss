package com.estoque.fgss.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "estoque")
public class Produto {

    @Id
    private String id;
    private String nome;
    private Long quantidade;
}
