package br.com.bieniek.compras.graphql.inputs;

import lombok.Data;

@Data
public class ClienteInput {

    private Long id;
    private String nome;
    private String email;

}
