package br.ufpr.ees2019.ees2019api.service;

import java.util.List;

import br.ufpr.ees2019.ees2019api.dto.ProdutoDTO;

public interface ProdutoService extends BaseService<ProdutoDTO, Long> {
    List<ProdutoDTO> buscarPorNome(String nome);
}
