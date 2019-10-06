package br.ufpr.ees2019.ees2019api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpr.ees2019.ees2019api.converter.ClienteConverter;
import br.ufpr.ees2019.ees2019api.domain.Cliente;
import br.ufpr.ees2019.ees2019api.dto.ClienteDTO;
import br.ufpr.ees2019.ees2019api.repository.ClienteRepository;
import br.ufpr.ees2019.ees2019api.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteConverter clienteConverter;
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Override
	public ClienteDTO salvar(Cliente cliente) {		
		return clienteConverter.convertToDto(clienteRepo.save(cliente));
	}

	@Override
	public List<ClienteDTO> getAll() {
		return clienteRepo.findAll().stream()
						.map(clienteConverter::convertToDto)
						.collect(Collectors.toList());
	}

	@Override
	public ClienteDTO findById(Integer id) {
		return clienteRepo.findById(id)
					.map(clienteConverter::convertToDto)
					.orElse(null);
	}
	
}