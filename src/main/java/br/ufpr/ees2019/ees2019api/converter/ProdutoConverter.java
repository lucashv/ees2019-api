package br.ufpr.ees2019.ees2019api.converter;

import org.springframework.stereotype.Component;

import br.ufpr.ees2019.ees2019api.domain.Produto;
import br.ufpr.ees2019.ees2019api.dto.ProdutoDTO;

@Component
public class ProdutoConverter implements Convertable<Produto, ProdutoDTO> {

    @Override
    public Produto convertToDomain(ProdutoDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ProdutoDTO convertToDto(Produto entity) {
        // TODO Auto-generated method stub
        return null;
    }

}
