package br.ufpr.ees2019.ees2019api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
