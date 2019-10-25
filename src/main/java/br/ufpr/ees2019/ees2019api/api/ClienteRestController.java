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
import br.ufpr.ees2019.ees2019api.service.BaseService;
import br.ufpr.ees2019.ees2019api.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteRestController extends BaseRestController<ClienteDTO, Long> {
	@Autowired
	private ClienteService clienteService;

    @Override
    protected BaseService<ClienteDTO, Long> getService() {
        return this.clienteService;
    }
    
    @GetMapping("/porcpf/{cpf}")
    public ResponseEntity<List<ClienteDTO>> buscarPorCpf(@PathVariable("cpf") String cpf) {
        try {
            return ResponseEntity.ok(this.clienteService.buscarPorCPF(cpf));
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/pornome/{nome}")
    public ResponseEntity<List<ClienteDTO>> buscarPorNome(@PathVariable("nome") String nome) {
        try {
            return ResponseEntity.ok(this.clienteService.buscarPorNome(nome));
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
