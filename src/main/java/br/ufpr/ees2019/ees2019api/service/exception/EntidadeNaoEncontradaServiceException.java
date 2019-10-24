package br.ufpr.ees2019.ees2019api.service.exception;

public class EntidadeNaoEncontradaServiceException extends ServiceException {

    public EntidadeNaoEncontradaServiceException(Object id) {
        super("Entidade não encontrada. Id: " + id);
    }

}
