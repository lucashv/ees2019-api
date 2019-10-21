package br.ufpr.ees2019.ees2019api.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.ufpr.ees2019.ees2019api.dto.ClienteDTO;
import br.ufpr.ees2019.ees2019api.service.exception.ClienteTemPedidosServiceException;
import br.ufpr.ees2019.ees2019api.service.exception.ServiceException;

public interface ClienteService extends UserDetailsService {
	ClienteDTO salvar(ClienteDTO cliente) throws ServiceException;
	void excluir(Long id) throws ClienteTemPedidosServiceException, ServiceException;
	List<ClienteDTO> retornarTodos() throws ServiceException;
	ClienteDTO retornarPorId(Long id) throws ServiceException;
}
