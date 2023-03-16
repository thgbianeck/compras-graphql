package br.com.bieniek.compras.graphql;

import br.com.bieniek.compras.domain.Compra;
import br.com.bieniek.compras.domain.service.ClienteService;
import br.com.bieniek.compras.domain.service.CompraService;
import br.com.bieniek.compras.domain.service.ProdutoService;
import br.com.bieniek.compras.graphql.dto.CompraResumo;
import br.com.bieniek.compras.graphql.inputs.CompraInput;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CompraGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final CompraService service;

    private final ClienteService clienteService;

    private final ProdutoService produtoService;

    public Compra compra(Long id) {
        return service.findById(id);
    }

    public List<Compra> getCompras(int page, int size) {
        Pageable pageable = PageRequest.of(page,size, Sort.by("quantidade"));
        return service.findAll(pageable);
    }

    public List<CompraResumo> getComprasRelatorio() {
        return service.findAllComprasRelatorio();
    }

    public Compra saveCompra(CompraInput input) {
        ModelMapper m = new ModelMapper();
        Compra c = m.map(input,Compra.class);

        c.setData(new Date());

        c.setCliente(clienteService.findById(input.getClienteId()));
        c.setProduto(produtoService.findById(input.getProdutoId()));

        return service.save(c);
    }

    public Boolean deleteCompra(Long id) {
        return service.deleteById(id);
    }
}
