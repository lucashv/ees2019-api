package br.ufpr.ees2019.ees2019api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import br.ufpr.ees2019.ees2019api.converter.Convertable;
import br.ufpr.ees2019.ees2019api.converter.PedidoConverter;
import br.ufpr.ees2019.ees2019api.domain.Pedido;
import br.ufpr.ees2019.ees2019api.dto.PedidoDTO;
import br.ufpr.ees2019.ees2019api.repository.PedidoRepository;
import br.ufpr.ees2019.ees2019api.service.PedidoService;

@Service(value = "pedidoService")
public class PedidoServiceImpl extends BaseServiceImpl<PedidoDTO, Pedido, Long> implements PedidoService  {
    @Autowired
    private PedidoConverter pedidoConverter;
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Override
    protected Convertable<Pedido, PedidoDTO> getConv() {
        return this.pedidoConverter;
    }
    @Override
    protected JpaRepository<Pedido, Long> getRepo() {
        return this.pedidoRepository;
    }  
    
    @Override
    public List<PedidoDTO> buscarPorIdCliente(Long idCliente) {
        return this.pedidoRepository.findByClienteId(idCliente)
                                .orElse(Collections.emptyList())
                                .stream()
                                .map(pedidoConverter::convertToDto)
                                .collect(Collectors.toList());
    }
}
