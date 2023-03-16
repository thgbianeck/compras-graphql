package br.com.bieniek.compras.domain.service;

import br.com.bieniek.compras.domain.Cliente;
import br.com.bieniek.compras.domain.Produto;

import java.util.List;

public interface ProdutoService {

    List<Produto> findAll();

    Produto findById(Long id);

    Produto save(Produto p);

    Boolean deleteById(Long id);
}
