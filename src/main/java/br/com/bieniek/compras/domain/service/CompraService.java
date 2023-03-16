package br.com.bieniek.compras.domain.service;

import br.com.bieniek.compras.domain.Cliente;
import br.com.bieniek.compras.domain.Compra;
import br.com.bieniek.compras.graphql.dto.CompraResumo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompraService {

    Compra findById(Long id);

    List<Compra> findAll(Pageable pageable);

    Compra save(Compra c);

    boolean deleteById(Long id);

    List<Compra> findAllByCliente(Cliente c);

    List<CompraResumo> findAllComprasRelatorio();
}
