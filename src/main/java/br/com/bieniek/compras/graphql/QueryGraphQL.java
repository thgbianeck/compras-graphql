package br.com.bieniek.compras.graphql;

import br.com.bieniek.compras.domain.Cliente;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    public String hello() {
        return "Hello GraphQL!";
    }

    public int soma(int a, int b) {
        return a + b;
    }

    public Cliente cliente() {
        return new Cliente("Thiago Bianeck", "thiagobianeck@gmail.com");
    }

    public List<Cliente> clientes() {
        List<Cliente> list = new ArrayList<>();

        for (int i = 0; i < 10; i++)
            list.add(new Cliente("Thiago Bianeck " + i, "thgbnck" + i + "@gmail.com"));

        return list;
    }
}
