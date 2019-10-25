package br.ufpr.ees2019.ees2019api.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import br.ufpr.ees2019.ees2019api.service.BaseService;
import br.ufpr.ees2019.ees2019api.service.exception.ClienteTemPedidosServiceException;

public abstract class BaseRestController<TDTO, TID> {
    protected abstract BaseService<TDTO, TID> getService();
    
    @GetMapping
    public ResponseEntity<List<TDTO>> retornarTodos() {
        try {
            return ResponseEntity.ok(this.getService().retornarTodos());
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }       
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TDTO> retornarPorId(@PathVariable("id") TID id) {
        try {
            return ResponseEntity.ok(this.getService().retornarPorId(id));
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping
    public ResponseEntity<TDTO> salvar(@RequestBody TDTO dto) {
        try {
            return ResponseEntity.ok(this.getService().salvar(dto));
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable("id") TID id) {
        try {
            this.getService().excluir(id);
            return ResponseEntity.ok().build();
        } catch(ClienteTemPedidosServiceException ex) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }       
    }
}
