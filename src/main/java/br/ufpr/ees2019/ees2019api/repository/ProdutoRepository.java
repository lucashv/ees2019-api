package br.ufpr.ees2019.ees2019api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufpr.ees2019.ees2019api.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>  {

}