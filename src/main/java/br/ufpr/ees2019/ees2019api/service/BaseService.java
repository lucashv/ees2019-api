package br.ufpr.ees2019.ees2019api.service;

import java.util.List;

import br.ufpr.ees2019.ees2019api.service.exception.EntidadeNaoEncontradaServiceException;
import br.ufpr.ees2019.ees2019api.service.exception.ServiceException;

public interface BaseService<TDTO, TID> {
    TDTO salvar(TDTO obj) throws ServiceException;
    void excluir(TID id) throws ServiceException;
    List<TDTO> retornarTodos() throws ServiceException;
    TDTO retornarPorId(TID id) throws EntidadeNaoEncontradaServiceException, ServiceException;
}
