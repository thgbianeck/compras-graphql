package br.com.bieniek.compras.graphql;

import br.com.bieniek.compras.domain.Cliente;
import br.com.bieniek.compras.graphql.inputs.ClienteInput;
import br.com.bieniek.compras.domain.service.ClienteService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final ClienteService service;

    public Cliente cliente(Long id) {
        return service.findById(id);
    }

    public List<Cliente> clientes() {
        return service.findAll();
    }

    public Cliente saveCliente(ClienteInput input) {
        ModelMapper m = new ModelMapper();
        Cliente c = m.map(input,Cliente.class);
        return service.save(c);
    }

    public Boolean deleteCliente(Long id) {
        return service.deleteById(id);
    }
}
