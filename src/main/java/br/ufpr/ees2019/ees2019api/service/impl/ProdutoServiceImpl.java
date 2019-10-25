package br.ufpr.ees2019.ees2019api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import br.ufpr.ees2019.ees2019api.converter.Convertable;
import br.ufpr.ees2019.ees2019api.converter.ProdutoConverter;
import br.ufpr.ees2019.ees2019api.domain.Produto;
import br.ufpr.ees2019.ees2019api.dto.ProdutoDTO;
import br.ufpr.ees2019.ees2019api.repository.ProdutoRepository;
import br.ufpr.ees2019.ees2019api.service.ProdutoService;

@Service(value = "produtoService")
public class ProdutoServiceImpl extends BaseServiceImpl<ProdutoDTO, Produto, Long> implements ProdutoService {
    @Autowired
    private ProdutoConverter produtoConverter;
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Override
    protected Convertable<Produto, ProdutoDTO> getConv() {
        return this.produtoConverter;
    }

    @Override
    protected JpaRepository<Produto, Long> getRepo() {
        return this.produtoRepository;
    }
    
    @Override
    public List<ProdutoDTO> buscarPorNome(String nome) {
        return this.produtoRepository.findByNomeContaining(nome)
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(produtoConverter::convertToDto)
                        .collect(Collectors.toList());
    }
}
