package br.com.bieniek.compras.domain.service.impl;

import br.com.bieniek.compras.domain.Cliente;
import br.com.bieniek.compras.domain.repository.ClienteRepository;
import br.com.bieniek.compras.domain.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;
    @Override
    public Cliente findById(Long id) {
        Optional<Cliente> op = repository.findById(id);
        if (op.isPresent()) {
            return op.get();
        }
        return null;
    }

    @Override
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Cliente save(Cliente c) {
        return repository.save(c);
    }

    @Override
    @Transactional
    public Boolean deleteById(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
