package br.ufpr.ees2019.ees2019api.service.exception;

import br.ufpr.ees2019.ees2019api.domain.Cliente;

public class ClienteTemPedidosException extends ServiceException {
	public ClienteTemPedidosException(Cliente cliente) {
		super("O Cliente " + cliente.getId() + " tem pedidos.");
	}
}
