package br.ufpr.ees2019.ees2019api.api;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufpr.ees2019.ees2019api.dto.ClienteDTO;
import br.ufpr.ees2019.ees2019api.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteRestController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> getAll() {
		return ResponseEntity.ok(clienteService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathParam("id") Integer id) {
		return ResponseEntity.ok(clienteService.findById(id));
	}
}