package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_agendamento;

    @NotNull(message = "O campo data/hora é obrigatório")
    private LocalDateTime dataHora;

    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    @NotNull(message = "O campo cliente é obrigatório")
    @JsonIgnoreProperties("agendamentos")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_funcionario", nullable = false)
    @NotNull(message = "O campo funcionário é obrigatório")
    @JsonIgnoreProperties("agendamentos")
    private Funcionario funcionario;

    @ManyToMany
    @JoinTable(
        name = "agendamento_servico",
        joinColumns = @JoinColumn(name = "id_agendamento"),
        inverseJoinColumns = @JoinColumn(name = "id_servico")
    )
    @JsonIgnoreProperties("agendamentos")
    private List<Servico> servicos;

    public Agendamento() {}

    public Agendamento(LocalDateTime dataHora, Cliente cliente, Funcionario funcionario) {
        this.dataHora = dataHora;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }
}
