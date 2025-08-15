package app.app.repository;

import app.app.entity.Agendamento;
import app.app.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    // Métodos automáticos (mínimo 2 por repository)
    List<Agendamento> findByCliente(Cliente cliente);
    List<Agendamento> findByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);
}
