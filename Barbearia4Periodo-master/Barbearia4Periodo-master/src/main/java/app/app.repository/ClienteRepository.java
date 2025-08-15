package app.repository;

import app.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Métodos automáticos (mínimo 2 por repository)
    List<Cliente> findByNomeContainingIgnoreCase(String nome);
    List<Cliente> findByIdadeGreaterThanEqual(Integer idade);
}