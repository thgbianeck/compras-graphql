package br.com.bieniek.compras.domain.service.impl;

import br.com.bieniek.compras.domain.Cliente;
import br.com.bieniek.compras.domain.Compra;
import br.com.bieniek.compras.domain.service.CompraService;
import br.com.bieniek.compras.graphql.dto.CompraResumo;
import br.com.bieniek.compras.graphql.exceptions.DomainException;
import br.com.bieniek.compras.domain.repository.CompraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompraServiceImpl implements CompraService {

    private final CompraRepository rep;

    public Compra findById(Long id) {
        return rep.findById(id).orElse(null);
    }

    public List<Compra> findAll(Pageable pageable) {
        return rep.findAll(pageable).getContent();
    }

    @Transactional
    public Compra save(Compra c) {
        if(c.getQuantidade() > 100) {
            throw new DomainException("Não é possível fazer uma compra com mais de 100 items");
        }
        return rep.save(c);
    }

    @Transactional
    public boolean deleteById(Long id) {
        if(rep.findById(id).isPresent()) {
            rep.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Compra> findAllByCliente(Cliente c) {
        return rep.findAllByCliente(c.getId());
    }

    public List<CompraResumo> findAllComprasRelatorio() {
        return rep.findAllComprasRelatorio();
    }
}
