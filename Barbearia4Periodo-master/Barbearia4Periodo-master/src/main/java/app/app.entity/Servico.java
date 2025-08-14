package app.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"XXX"})
//alterar o campo `XXX` para algum atributo que voce quer que nao seja retornado no POSTMAN (API)
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_servico;

    private String nome;
    private String telefone;

    // Relacionamento ManyToMany com Funcionario
    @ManyToMany(mappedBy = "servicos")
    private List<Funcionario> funcionarios;

    // Relacionamento OneToMany com Agendamento
    @OneToMany(mappedBy = "servico")
    private List<Agendamento> agendamentos;

    // Construtor completo
    public Servico(Long id_servico, String nome, String telefone) {
        this.id_servico = id_servico;
        this.nome = nome;
        this.telefone = telefone;
    }

    // Construtor padrão
    public Servico() {
    }

    // Getters e Setters
    public Long getId_servico() {
        return id_servico;
    }

    public void setId_servico(Long id_servico) {
        this.id_servico = id_servico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
