package br.ufpr.ees2019.ees2019api.converter;

import org.springframework.stereotype.Component;

import br.ufpr.ees2019.ees2019api.domain.Pedido;
import br.ufpr.ees2019.ees2019api.dto.PedidoDTO;

@Component
public class PedidoConverter implements Convertable<Pedido, PedidoDTO> {

    @Override
    public Pedido convertToDomain(PedidoDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PedidoDTO convertToDto(Pedido entity) {
        // TODO Auto-generated method stub
        return null;
    }

}
