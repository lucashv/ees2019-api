package br.ufpr.ees2019.ees2019api.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.ufpr.ees2019.ees2019api.dto.ClienteDTO;

public interface ClienteService extends UserDetailsService {
	public ClienteDTO salvar(ClienteDTO cliente);
	public List<ClienteDTO> getAll();
	public ClienteDTO findById(Long id);
}
