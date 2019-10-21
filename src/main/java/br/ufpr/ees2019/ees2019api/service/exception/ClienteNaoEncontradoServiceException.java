package br.ufpr.ees2019.ees2019api.service.exception;

public class ClienteNaoEncontradoServiceException extends ServiceException {

    public ClienteNaoEncontradoServiceException(Long id) {
        super("Cliente não encontrado. Id: " + id);
    }

}
