package br.ufpr.ees2019.ees2019api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.ufpr.ees2019.ees2019api.converter.ClienteConverter;
import br.ufpr.ees2019.ees2019api.converter.Convertable;
import br.ufpr.ees2019.ees2019api.domain.Cliente;
import br.ufpr.ees2019.ees2019api.dto.ClienteDTO;
import br.ufpr.ees2019.ees2019api.repository.ClienteRepository;
import br.ufpr.ees2019.ees2019api.security.DetalheUsuario;
import br.ufpr.ees2019.ees2019api.service.ClienteService;

@Service(value = "clienteService")
public class ClienteServiceImpl extends BaseServiceImpl<ClienteDTO, Cliente, Long> implements ClienteService {
	
	@Autowired
	private ClienteConverter clienteConverter;
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Override
    protected Convertable<Cliente, ClienteDTO> getConv() {
        return this.clienteConverter;
    }

    @Override
    protected JpaRepository<Cliente, Long> getRepo() {
        return this.clienteRepo;
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
