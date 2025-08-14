package app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O campo data/hora é obrigatório")
    private LocalDateTime dataHora;

    private String observacoes;

    @NotNull(message = "O campo cliente ID é obrigatório")
    private Long clienteId;

    @NotNull(message = "O campo funcionário ID é obrigatório")
    private Long funcionarioId;

    @NotNull(message = "O campo serviço ID é obrigatório")
    private Long servicoId;

    public Agendamento() {}

    public Agendamento(LocalDateTime dataHora, Long clienteId, Long funcionarioId, Long servicoId) {
        this.dataHora = dataHora;
        this.clienteId = clienteId;
        this.funcionarioId = funcionarioId;
        this.servicoId = servicoId;
    }
}
