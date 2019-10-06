package br.ufpr.ees2019.ees2019api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_produto")
public class Produto {
	@Id
	@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
	@Column(name = "id")
	private Integer id;
	@Column(name = "descricao")
	private String descricao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
