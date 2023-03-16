package br.com.bieniek.compras.domain.service.impl;

import br.com.bieniek.compras.domain.Produto;
import br.com.bieniek.compras.domain.repository.ProdutoRepository;
import br.com.bieniek.compras.domain.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository rep;

    public List<Produto> findAll() {
        return rep.findAll();
    }

    public Produto findById(Long id) {
        return rep.findById(id).orElse(null);
    }

    @Transactional
    public Produto save(Produto p) {
        return rep.save(p);
    }

    @Transactional
    public Boolean deleteById(Long id) {
        if(rep.findById(id).isPresent()) {
            rep.deleteById(id);
            return true;
        }
        return false;
    }

}
