package br.ufpr.ees2019.ees2019api.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

import br.ufpr.ees2019.ees2019api.converter.Convertable;
import br.ufpr.ees2019.ees2019api.service.BaseService;
import br.ufpr.ees2019.ees2019api.service.exception.EntidadeNaoEncontradaServiceException;
import br.ufpr.ees2019.ees2019api.service.exception.ServiceException;

public abstract class BaseServiceImpl<TDTO, TENTITY, TID> implements BaseService<TDTO, TID> {
    
    protected abstract Convertable<TENTITY, TDTO> getConv();
    protected abstract JpaRepository<TENTITY, TID>  getRepo();
    
    @Override
    public TDTO salvar(TDTO dto) throws ServiceException {
        TENTITY entity = this.getConv().convertToDomain(dto);
        return this.getConv().convertToDto(this.getRepo().save(entity));
    }

    public void excluir(TID id) throws ServiceException {
        this.getRepo().deleteById(id);     
    }
    
    @Override
    public List<TDTO> retornarTodos() throws ServiceException {       
        return this.getRepo().findAll()
                             .stream()
                             .map(this.getConv()::convertToDto)
                             .collect(Collectors.toList());      
    }

    @Override
    public TDTO retornarPorId(TID id) 
            throws EntidadeNaoEncontradaServiceException, ServiceException {     
        TENTITY entity = 
                this.getRepo().findById(id)
                              .orElseThrow(() -> new EntidadeNaoEncontradaServiceException(id));
        return this.getConv().convertToDto(entity);
    }

}
