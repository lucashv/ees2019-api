package br.ufpr.ees2019.ees2019api.service;

import java.util.List;

import br.ufpr.ees2019.ees2019api.domain.Cliente;
import br.ufpr.ees2019.ees2019api.dto.ClienteDTO;

public interface ClienteService {
	public ClienteDTO salvar(Cliente cliente);
	public List<ClienteDTO> getAll();
	public ClienteDTO findById(Integer id);
}
