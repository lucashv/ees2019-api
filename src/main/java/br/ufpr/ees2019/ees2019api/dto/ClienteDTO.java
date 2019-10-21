package br.ufpr.ees2019.ees2019api.dto;

import java.util.List;

public class ClienteDTO {
	private Long id;
	private String cpf;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private List<PedidoDTO> pedidos;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public List<PedidoDTO> getPedidos() {
        return pedidos;
    }
    public void setPedidos(List<PedidoDTO> pedidos) {
        this.pedidos = pedidos;
    }	
}
