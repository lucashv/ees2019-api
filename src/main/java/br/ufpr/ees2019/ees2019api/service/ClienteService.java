package br.ufpr.ees2019.ees2019api.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import br.ufpr.ees2019.ees2019api.domain.Cliente;
import br.ufpr.ees2019.ees2019api.dto.ClienteDTO;

public interface ClienteService extends UserDetailsService {
	public ClienteDTO salvar(Cliente cliente);
	public List<ClienteDTO> getAll();
	public ClienteDTO findById(Integer id);
}
