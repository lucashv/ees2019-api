package br.ufpr.ees2019.ees2019api.service;

import java.util.List;

import br.ufpr.ees2019.ees2019api.dto.PedidoDTO;

public interface PedidoService extends BaseService<PedidoDTO, Long> {
    List<PedidoDTO> buscarPorIdCliente(Long idCliente);
}
