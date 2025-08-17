package app.app.repository;

import app.app.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Métodos automáticos (mínimo 2 por repository)
    List<Cliente> findByNomeContaining(String nome);

    //busca por idade maior ou igual
    List<Cliente> findByIdadeGreaterThanEqual(Integer idade);
}