package br.ufpr.ees2019.ees2019api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

import br.ufpr.ees2019.ees2019api.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    @Query("select p from Pedido p where p.cliente.id = :idCliente")
    Optional<List<Pedido>> findByClienteId(Long idCliente);
}
