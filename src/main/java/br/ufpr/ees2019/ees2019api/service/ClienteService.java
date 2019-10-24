package br.ufpr.ees2019.ees2019api.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.ufpr.ees2019.ees2019api.dto.ClienteDTO;

public interface ClienteService extends BaseService<ClienteDTO, Long>, UserDetailsService {

}
