package br.ufpr.ees2019.ees2019api.converter;

import org.springframework.stereotype.Component;

import br.ufpr.ees2019.ees2019api.domain.Cliente;
import br.ufpr.ees2019.ees2019api.dto.ClienteDTO;

@Component
public class ClienteConverter implements Convertable<Cliente, ClienteDTO> {

	@Override
	public Cliente convertToDomain(ClienteDTO dto) {
		Cliente entity = new Cliente();
		
		entity.setId(dto.getId());
		entity.setCpf(dto.getCpf());
		entity.setNome(dto.getNome());		
		entity.setSobrenome(dto.getSobrenome());
		entity.setEmail(dto.getEmail());
		
		return entity;
	}

	@Override
	public ClienteDTO convertToDto(Cliente entity) {
		ClienteDTO dto = new ClienteDTO();
		
		dto.setId(entity.getId());
		dto.setCpf(entity.getCpf());
		dto.setNome(entity.getNome());		
		dto.setSobrenome(entity.getSobrenome());
		dto.setEmail(entity.getEmail());
		
		return dto;
	}


}
