package br.ufpr.ees2019.ees2019api.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufpr.ees2019.ees2019api.dto.ClienteDTO;
import br.ufpr.ees2019.ees2019api.service.ClienteService;
import br.ufpr.ees2019.ees2019api.service.exception.ClienteTemPedidosException;

@RestController
@RequestMapping("/api/cliente")
public class ClienteRestController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> retornarTodos() {
		try {
			return ResponseEntity.ok(clienteService.retornarTodos());
		} catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> retornarPorId(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(clienteService.retornarPorId(id));
		} catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO> salvar(@RequestBody ClienteDTO clienteDto) {
		try {
			return ResponseEntity.ok(clienteService.salvar(clienteDto));
		} catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity excluir(@PathVariable("id") Long id) {
		try {
			clienteService.excluir(id);
			return ResponseEntity.ok().build();
		} catch(ClienteTemPedidosException ex) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		} catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
}
