package br.ufpr.ees2019.ees2019api.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_cliente")
public class Cliente {
	@Id
	@SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliente")
	@Column(name = "id")
	private Integer id;
	@Column(name = "cpf")
	private String cpf;
	@Column(name = "nome")
	private String nome;
	@Column(name = "sobrenome")
	private String sobrenome;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List<Pedido> pedidos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}
