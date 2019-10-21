package br.ufpr.ees2019.ees2019api.api;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import br.ufpr.ees2019.ees2019api.dto.ClienteDTO;
import br.ufpr.ees2019.ees2019api.dto.PedidoDTO;
import br.ufpr.ees2019.ees2019api.service.ClienteService;

public class ClientRestControllerTest {
    
    @Mock
    private ClienteService clienteService;
    
    @InjectMocks
    private ClienteRestController clienteRestController;
    
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void deveSalvarCliente() throws Exception {
        ClienteDTO cDto = new ClienteDTO();
        when(clienteService.salvar(any(ClienteDTO.class))).thenReturn(cDto);        
        ResponseEntity<ClienteDTO> re = clienteRestController.salvar(cDto);
        assertTrue(cDto.equals(re.getBody()));
    }
    
    @Test
    public void deveExcluirClienteQueNaoTenhaPedido() throws Exception {
        
    }
    
    @Test
    public void deveNaoExcluirClientePoisTemPedido() throws Exception {
        List<PedidoDTO> listaPedidos = new ArrayList<>();
        listaPedidos.add(new PedidoDTO());
        
        ClienteDTO cDto = new ClienteDTO();
        cDto.setPedidos(listaPedidos);
        
        //when(clienteService.retornarPorId(any(Long.class))).thenReturn(cDto);
        
        clienteRestController.excluir(cDto.getId()); 
    }
    
    @Test
    public void deveListarTodosOsClientes() throws Exception {
        
    }
}
