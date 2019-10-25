package br.ufpr.ees2019.ees2019api.dto;

public class ItemPedidoDTO {
    private Long id;
    private Integer quantidade;
    private PedidoDTO pedido;
    private ProdutoDTO produto;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public PedidoDTO getPedido() {
        return pedido;
    }
    public void setPedido(PedidoDTO pedido) {
        this.pedido = pedido;
    }
    public ProdutoDTO getProduto() {
        return produto;
    }
    public void setProduto(ProdutoDTO produto) {
        this.produto = produto;
    }
    
}
