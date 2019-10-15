package br.ufpr.ees2019.ees2019api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.ufpr.ees2019.ees2019api.converter.ClienteConverter;
import br.ufpr.ees2019.ees2019api.domain.Cliente;
import br.ufpr.ees2019.ees2019api.dto.ClienteDTO;
import br.ufpr.ees2019.ees2019api.repository.ClienteRepository;
import br.ufpr.ees2019.ees2019api.security.DetalheUsuario;
import br.ufpr.ees2019.ees2019api.service.ClienteService;
import br.ufpr.ees2019.ees2019api.service.exception.ClienteTemPedidosException;
import br.ufpr.ees2019.ees2019api.service.exception.ServiceException;

@Service(value = "clienteService")
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteConverter clienteConverter;
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Override
	public ClienteDTO salvar(ClienteDTO clienteDTO) throws ServiceException {
		try {
			Cliente cliente = clienteConverter.convertToDomain(clienteDTO);
			return clienteConverter.convertToDto(clienteRepo.save(cliente));
		} catch(Exception ex) {
			throw new ServiceException(ex);
		}
	}

	public void excluir(Long id) throws ClienteTemPedidosException, ServiceException {
		try {
			Cliente c = clienteRepo.findById(id).orElse(null);
			
			if (c != null && c.getPedidos() != null && c.getPedidos().size() > 0)
				throw new ClienteTemPedidosException(c);
			
			clienteRepo.deleteById(id);
		} catch(Exception ex) {
			throw new ServiceException(ex);
		}
	}
	
	@Override
	public List<ClienteDTO> retornarTodos() throws ServiceException {
		try {
			return clienteRepo.findAll().stream()
							.map(clienteConverter::convertToDto)
							.collect(Collectors.toList());
		} catch(Exception ex) {
			throw new ServiceException(ex);
		}
	}

	@Override
	public ClienteDTO retornarPorId(Long id) throws ServiceException {
		try {
			return clienteRepo.findById(id)
						.map(clienteConverter::convertToDto)
						.orElse(null);
		} catch(Exception ex) {
			throw new ServiceException(ex);
		}
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
