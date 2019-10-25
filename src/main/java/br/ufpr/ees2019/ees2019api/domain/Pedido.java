package br.ufpr.ees2019.ees2019api.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_pedido")
public class Pedido {
	@Id
	@SequenceGenerator(name = "seq_pedido", sequenceName = "seq_pedido", allocationSize = 1 )
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedido")
	@Column(name = "id")
	private Long id;
	@Column(name = "data")
	private Date data;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemPedido> itens;
	
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ItemPedido> getItens() {
		return itens;
	}
	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
}
