package app.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"XXX"})
//alterar o campo `XXX` para algum atributo que voce quer que nao seja retornado no POSTMAN (API)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    private String nome;
    private String Cpf;
    private Integer Idade;

    // Relacionamento OneToMany com Agendamento
    @OneToMany(mappedBy = "cliente")
    private List<Agendamento> agendamentos;

    public Cliente(Long id_cliente, String nome, String cpf, Integer idade) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        Cpf = cpf;
        Idade = idade;
    }

    public Cliente() {
    }

    // Getters e Setters
    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public Integer getIdade() {
        return Idade;
    }

    public void setIdade(Integer idade) {
        Idade = idade;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
