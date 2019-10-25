package br.ufpr.ees2019.ees2019api.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

import br.ufpr.ees2019.ees2019api.domain.Pedido;
import br.ufpr.ees2019.ees2019api.dto.PedidoDTO;

@Component
public class PedidoConverter implements Convertable<Pedido, PedidoDTO> {

    @Autowired
    private ClienteConverter clienteConverter;
    @Autowired
    private ItemPedidoConverter itemPedidoConverter;
    
    @Override
    public Pedido convertToDomain(PedidoDTO dto) {
        Pedido entity = new Pedido();
        
        entity.setId(dto.getId());
        entity.setData(dto.getData());
        entity.setItens(dto.getItens().stream()
                            .map(itemPedidoConverter::convertToDomain)
                            .collect(Collectors.toList()));
        entity.setCliente(Optional.ofNullable(dto.getCliente())
                            .map(clienteConverter::convertToDomain)
                            .get());
        
        Optional.ofNullable(entity.getItens())
            .orElse(Collections.emptyList())
            .forEach(i -> i.setPedido(entity));
        
        return entity;
    }

    @Override
    public PedidoDTO convertToDto(Pedido entity) {
        PedidoDTO dto = new PedidoDTO();
        
        dto.setId(entity.getId());
        dto.setData(entity.getData());
        dto.setItens(entity.getItens().stream()
                .map(itemPedidoConverter::convertToDto)
                .collect(Collectors.toList()));
        dto.setCliente(Optional.ofNullable(entity.getCliente())
                .map(clienteConverter::convertToDto)
                .get());
        
        return dto;
    }

}
