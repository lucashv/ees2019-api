package br.ufpr.ees2019.ees2019api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.ufpr.ees2019.ees2019api.converter.ClienteConverter;
import br.ufpr.ees2019.ees2019api.domain.Cliente;
import br.ufpr.ees2019.ees2019api.dto.ClienteDTO;
import br.ufpr.ees2019.ees2019api.repository.ClienteRepository;
import br.ufpr.ees2019.ees2019api.security.DetalheUsuario;
import br.ufpr.ees2019.ees2019api.service.ClienteService;
import br.ufpr.ees2019.ees2019api.service.exception.ClienteNaoEncontradoServiceException;
import br.ufpr.ees2019.ees2019api.service.exception.ClienteTemPedidosServiceException;
import br.ufpr.ees2019.ees2019api.service.exception.ServiceException;

@Service(value = "clienteService")
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteConverter clienteConverter;
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Override
	public ClienteDTO salvar(ClienteDTO clienteDTO) throws ServiceException {
		Cliente cliente = clienteConverter.convertToDomain(clienteDTO);
		return clienteConverter.convertToDto(clienteRepo.save(cliente));
	}

	public void excluir(Long id) throws ClienteTemPedidosServiceException, ServiceException {		
		Cliente c = clienteRepo.findById(id).orElse(null);
		
		if (c != null && c.getPedidos() != null && c.getPedidos().size() > 0)
			throw new ClienteTemPedidosServiceException(c);
		
		clienteRepo.deleteById(id);		
	}
	
	@Override
	public List<ClienteDTO> retornarTodos() throws ServiceException {		
		return clienteRepo.findAll()
		                .stream()
						.map(clienteConverter::convertToDto)
						.collect(Collectors.toList());		
	}

	@Override
	public ClienteDTO retornarPorId(Long id) 
	        throws ClienteNaoEncontradoServiceException, ServiceException {		
	    Cliente cliente = 
	            clienteRepo.findById(id)
                           .orElseThrow(() -> new ClienteNaoEncontradoServiceException(id));
		return clienteConverter.convertToDto(cliente);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return clienteRepo.findOneByEmail(username)
				.map(cliente -> {
					return new DetalheUsuario(cliente.getId(), cliente.getEmail(), cliente.getPassword());
				})
				.orElseThrow(() -> new UsernameNotFoundException("Usuário '"+ username +"' não encontrado."));
	}
	
}
