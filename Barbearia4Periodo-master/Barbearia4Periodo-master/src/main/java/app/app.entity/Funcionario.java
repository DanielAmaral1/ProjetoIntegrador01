package app.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"XXX"})
//alterar o campo `XXX` para algum atributo que voce quer que nao seja retornado no POSTMAN (API)
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_funcionario;

    private String nome;
    private String telefone;
    private String endereco;

    // Relacionamento OneToMany com Agendamento
    @OneToMany(mappedBy = "funcionario")
    private List<Agendamento> agendamentos;

    // Relacionamento ManyToMany com Servico
    @ManyToMany
    @JoinTable(
            name = "funcionario_servico",
            joinColumns = @JoinColumn(name = "id_funcionario"),
            inverseJoinColumns = @JoinColumn(name = "id_servico")
    )
    private List<Servico> servicos;

    // Construtor padrão
    public Funcionario() {}

    // Construtor completo
    public Funcionario(int id_funcionario, String nome, String telefone, String endereco) {
        this.id_funcionario = id_funcionario;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    // Getters e Setters
    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
}
