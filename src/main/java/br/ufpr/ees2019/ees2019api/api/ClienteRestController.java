package br.ufpr.ees2019.ees2019api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
