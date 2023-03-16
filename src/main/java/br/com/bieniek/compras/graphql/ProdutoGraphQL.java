package br.com.bieniek.compras.graphql;

import br.com.bieniek.compras.domain.Produto;
import br.com.bieniek.compras.graphql.inputs.ProdutoInput;
import br.com.bieniek.compras.domain.service.ProdutoService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProdutoGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final ProdutoService service;

    public Produto produto(Long id) {
        return service.findById(id);
    }

    public List<Produto> getProdutos() {
        return service.findAll();
    }

    public Produto saveProduto(ProdutoInput input) {
        ModelMapper m = new ModelMapper();
        Produto c = m.map(input,Produto.class);

        return service.save(c);
    }

    public Boolean deleteProduto(Long id) {
        return service.deleteById(id);
    }
}
