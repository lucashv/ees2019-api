package br.ufpr.ees2019.ees2019api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import br.ufpr.ees2019.ees2019api.dto.ClienteDTO;
import br.ufpr.ees2019.ees2019api.dto.ProdutoDTO;
import br.ufpr.ees2019.ees2019api.service.BaseService;
import br.ufpr.ees2019.ees2019api.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoRestController extends BaseRestController<ProdutoDTO, Long> {
    @Autowired
    private ProdutoService produtoService;
    
    @Override
    protected BaseService<ProdutoDTO, Long> getService() {
        return produtoService;
    }
    
    @GetMapping("/pornome/{nome}")
    public ResponseEntity<List<ProdutoDTO>> buscarPorNome(@PathVariable("nome") String nome) {
        try {
            return ResponseEntity.ok(this.produtoService.buscarPorNome(nome));
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
