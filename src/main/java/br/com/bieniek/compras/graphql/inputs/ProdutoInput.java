package br.com.bieniek.compras.graphql.inputs;

import lombok.Data;

@Data
public class ProdutoInput {

    private Long id;
    private String nome;
    private double valor;
}
