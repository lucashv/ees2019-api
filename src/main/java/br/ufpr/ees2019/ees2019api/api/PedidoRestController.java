package br.ufpr.ees2019.ees2019api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import br.ufpr.ees2019.ees2019api.dto.ClienteDTO;
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
    
    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<PedidoDTO>> buscarPorNome(@PathVariable("idCliente") Long idCliente) {
        try {
            return ResponseEntity.ok(this.pedidoService.buscarPorIdCliente(idCliente));
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
