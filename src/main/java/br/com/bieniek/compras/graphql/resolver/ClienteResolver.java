package br.com.bieniek.compras.graphql.resolver;

import br.com.bieniek.compras.domain.Cliente;
import br.com.bieniek.compras.domain.Compra;
import br.com.bieniek.compras.domain.service.CompraService;
import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClienteResolver implements GraphQLResolver<Cliente> {

    private final CompraService compraService;

    public List<Compra> compras(Cliente c) {
        return compraService.findAllByCliente(c);
    }
}
