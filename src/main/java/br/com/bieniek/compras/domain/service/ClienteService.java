package br.com.bieniek.compras.domain.service;

import br.com.bieniek.compras.domain.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClienteService {

    Cliente findById(Long id);
    List<Cliente> findAll();
    public Cliente save(Cliente c);
    public Boolean deleteById(Long id);
}
