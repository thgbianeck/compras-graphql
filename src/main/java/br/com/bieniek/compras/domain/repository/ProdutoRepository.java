package br.com.bieniek.compras.domain.repository;

import br.com.bieniek.compras.domain.Cliente;
import br.com.bieniek.compras.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
