package br.com.bieniek.compras.graphql.resolver;

import br.com.bieniek.compras.domain.Cliente;
import br.com.bieniek.compras.domain.Compra;
import br.com.bieniek.compras.domain.Produto;
import br.com.bieniek.compras.domain.service.ClienteService;
import br.com.bieniek.compras.domain.service.ProdutoService;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompraResolver implements GraphQLResolver<Compra> {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    public String status(Compra c) {
        return c.getStatus();
    }

    public Cliente cliente(Compra c) {
        return clienteService.findById(c.getCliente().getId());
    }

    public Produto produto(Compra c) {
        return produtoService.findById(c.getProduto().getId());
    }
}
