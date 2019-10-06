package br.ufpr.ees2019.ees2019api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_item_pedido")
public class ItemPedido {
	@Id
	@SequenceGenerator(name = "seq_item_pedido", sequenceName = "seq_item_pedido")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_item_pedido")
	@Column(name = "id")
	private Integer id;
	@Column(name = "quantidade")
	private Integer quantidade;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_produto")
	private Produto produto;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
