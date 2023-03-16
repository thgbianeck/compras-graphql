package br.com.bieniek.compras.graphql.resolver;

import br.com.bieniek.compras.domain.Produto;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class ProdutoResolver implements GraphQLResolver<Produto> {

    public String valorReais(Produto p) {
        return "R$"+p.getValor();
    }
}
