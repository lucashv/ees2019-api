package br.ufpr.ees2019.ees2019api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufpr.ees2019.ees2019api.dto.PedidoDTO;
import br.ufpr.ees2019.ees2019api.service.BaseService;
import br.ufpr.ees2019.ees2019api.service.PedidoService;

@RestController
@RequestMapping("/api/pedido")
public class PedidoRestController extends BaseRestController<PedidoDTO, Long> {
    @Autowired
    private PedidoService pedidoService;
    
    @Override
    protected BaseService<PedidoDTO, Long> getService() {
        return pedidoService;
    }
}
