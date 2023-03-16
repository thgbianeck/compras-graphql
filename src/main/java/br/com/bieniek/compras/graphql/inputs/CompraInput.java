package br.com.bieniek.compras.graphql.inputs;

import lombok.Data;

@Data
public class CompraInput {

    private Long id;
    private Integer quantidade;
    private String status;

    private Long clienteId;

    private Long produtoId;
}
