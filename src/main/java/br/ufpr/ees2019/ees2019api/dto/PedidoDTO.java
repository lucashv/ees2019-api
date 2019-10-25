package br.ufpr.ees2019.ees2019api.dto;

import java.util.Date;
import java.util.List;

public class PedidoDTO {
    private Long id;
    private Date data;
    private ClienteDTO cliente;
    private List<ItemPedidoDTO> itens;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public ClienteDTO getCliente() {
        return cliente;
    }
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
    public List<ItemPedidoDTO> getItens() {
        return itens;
    }
    public void setItens(List<ItemPedidoDTO> itens) {
        this.itens = itens;
    }
    
}
