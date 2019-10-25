package br.ufpr.ees2019.ees2019api.converter;

import org.springframework.stereotype.Component;

import br.ufpr.ees2019.ees2019api.domain.Produto;
import br.ufpr.ees2019.ees2019api.dto.ProdutoDTO;

@Component
public class ProdutoConverter implements Convertable<Produto, ProdutoDTO> {

    @Override
    public Produto convertToDomain(ProdutoDTO dto) {
        Produto entity = new Produto();
        
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        
        return entity;
    }

    @Override
    public ProdutoDTO convertToDto(Produto entity) {
        ProdutoDTO dto = new ProdutoDTO();
        
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setDescricao(entity.getDescricao());
        
        return dto;
    }

}
