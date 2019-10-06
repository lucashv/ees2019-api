package br.ufpr.ees2019.ees2019api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufpr.ees2019.ees2019api.domain.Cliente;
import br.ufpr.ees2019.ees2019api.dto.ClienteDTO;

@Service
public interface ClienteService {
	public ClienteDTO salvar(Cliente cliente);
	public List<ClienteDTO> getAll();
	public ClienteDTO findById(Integer id);
}
