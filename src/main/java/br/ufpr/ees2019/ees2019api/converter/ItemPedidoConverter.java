package br.ufpr.ees2019.ees2019api.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import br.ufpr.ees2019.ees2019api.domain.ItemPedido;
import br.ufpr.ees2019.ees2019api.dto.ItemPedidoDTO;

@Component
public class ItemPedidoConverter implements Convertable<ItemPedido, ItemPedidoDTO>{

    @Autowired
    private PedidoConverter pedidoConverter;
    @Autowired
    private ProdutoConverter produtoConverter;
    
    @Override
    public ItemPedido convertToDomain(ItemPedidoDTO dto) {
        ItemPedido entity = new ItemPedido();
        
        entity.setId(dto.getId());
        entity.setPedido(Optional.ofNullable(dto.getPedido())
                            .map(pedidoConverter::convertToDomain)
                            .get());
        entity.setProduto(Optional.ofNullable(dto.getProduto())
                             .map(produtoConverter::convertToDomain)
                             .get());
        entity.setQuantidade(dto.getQuantidade());
        
        return entity;
    }

    @Override
    public ItemPedidoDTO convertToDto(ItemPedido entity) {
        ItemPedidoDTO dto = new ItemPedidoDTO();
        
        dto.setId(entity.getId());
        dto.setPedido(Optional.ofNullable(entity.getPedido())
                            .map(pedidoConverter::convertToDto)
                            .get());
        dto.setProduto(Optional.ofNullable(entity.getProduto())
                             .map(produtoConverter::convertToDto)
                             .get());
        dto.setQuantidade(entity.getQuantidade());
        
        return dto;
    }

}
