package br.ufpr.ees2019.ees2019api.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import br.ufpr.ees2019.ees2019api.converter.ClienteConverter;
import br.ufpr.ees2019.ees2019api.domain.Cliente;
import br.ufpr.ees2019.ees2019api.domain.Pedido;
import br.ufpr.ees2019.ees2019api.dto.ClienteDTO;
import br.ufpr.ees2019.ees2019api.dto.PedidoDTO;
import br.ufpr.ees2019.ees2019api.repository.ClienteRepository;
import br.ufpr.ees2019.ees2019api.service.exception.EntidadeNaoEncontradaServiceException;
import br.ufpr.ees2019.ees2019api.service.exception.ClienteTemPedidosServiceException;
import br.ufpr.ees2019.ees2019api.service.impl.ClienteServiceImpl;

public class ClienteServiceTest {
    @Mock(answer = Answers.CALLS_REAL_METHODS)
    private ClienteConverter clienteConverter;
    @Mock
    private ClienteRepository clienteRepository;
    @InjectMocks
    private ClienteService clienteService = new ClienteServiceImpl();
    
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void deveRetornarTodosClientes() throws Exception {
        final List<Cliente> listaClientes = new ArrayList<>();
        IntStream.range(0, 10).forEach(i -> {
            listaClientes.add(new Cliente());
        });        
        when(clienteRepository.findAll())
            .thenReturn(listaClientes);
        List<ClienteDTO> listaClientesDTO = this.clienteService.retornarTodos();
        assertTrue(listaClientesDTO != null && listaClientesDTO.size() == 10);
    }
    
    @Test
    public void deveRetornarUmaListaVaziaDeClientes() throws Exception {
        final List<Cliente> listaClientes = new ArrayList<>();
        when(clienteRepository.findAll())
            .thenReturn(listaClientes);
        List<ClienteDTO> listaClientesDTO = this.clienteService.retornarTodos();
        assertTrue(listaClientesDTO != null && listaClientesDTO.size() == 0);
    }
    
    @Test
    public void deveRetornarUmClientePorId() throws Exception {
        Cliente c = new Cliente();
        c.setId(1L);
        Optional<Cliente> optCliente = Optional.of(c);        
        when(clienteRepository.findById(1L))
            .thenReturn(optCliente);
        ClienteDTO clienteDTO = clienteService.retornarPorId(new Long(1));
        assertTrue(clienteDTO != null && clienteDTO.getId().equals(1L));
    }
    
    @Test(expected = EntidadeNaoEncontradaServiceException.class)
    public void naoDeveRetornarNenhumClientePorId() throws Exception {
        when(clienteRepository.findById(1L))
            .thenReturn(Optional.empty());
        clienteService.retornarPorId(new Long(1));
    }
    
    @Test
    public void deveSalvarUmCliente() throws Exception {
        final Long testeId = 1L;
        final String testeNome = "Teste";
        final ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNome(testeNome);        
        when(clienteRepository.save(any(Cliente.class)))
            .thenAnswer(new Answer<Cliente>() {
                @Override
                public Cliente answer(InvocationOnMock invocation) throws Throwable {
                    Cliente cliente = new Cliente();
                    cliente.setId(testeId);
                    cliente.setNome(testeNome);
                    return cliente;
                }                
            });        
        ClienteDTO newClienteDTO = clienteService.salvar(clienteDTO);
        assertTrue(newClienteDTO.getId().equals(testeId) &&
                   newClienteDTO.getNome().equals(testeNome));        
    }
    
    @Test
    public void deveExcluirUmClienteSemPedidos() throws Exception {
        final Long testeId = 1L;
        Cliente c = new Cliente();
        c.setId(1L);
        Optional<Cliente> optCliente = Optional.of(c);   
        when(clienteRepository.findById(testeId)).thenReturn(optCliente);
        doNothing().when(clienteRepository).deleteById(testeId);            
        clienteService.excluir(testeId);
        assertTrue(true);
    }
    
    @Test(expected = ClienteTemPedidosServiceException.class)
    public void naoDeveExcluirClienteComPedidos() throws Exception {
        final Long testeId = 1L;
        List<Pedido> listaPedidos = new ArrayList<>();
        listaPedidos.add(new Pedido());
        Cliente c = new Cliente();
        c.setId(1L);
        c.setPedidos(listaPedidos);
        Optional<Cliente> optCliente = Optional.of(c);   
        when(clienteRepository.findById(testeId)).thenReturn(optCliente);
        doNothing().when(clienteRepository).deleteById(testeId);            
        clienteService.excluir(testeId);
    }
}
