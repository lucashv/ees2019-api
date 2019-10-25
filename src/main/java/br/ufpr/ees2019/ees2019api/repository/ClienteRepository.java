package br.ufpr.ees2019.ees2019api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import br.ufpr.ees2019.ees2019api.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	Optional<Cliente> findOneByEmail(String email);
	Optional<List<Cliente>> findByCpfContaining(String cpf);
	Optional<List<Cliente>> findByNomeContaining(String nome);
}
