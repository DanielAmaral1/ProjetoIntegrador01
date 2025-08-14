package app.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@JsonIgnoreProperties({"XXX"})
//alterar o campo `XXX` para algum atributo que voce quer que nao seja retornado no POSTMAN (API)
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_agendamento;

    private String ISSN;
    private String titulo;
    private String sinopse;
    private Integer ano;
    private Integer qtdPaginas;

    private LocalDateTime dataHora;

    // Relacionamento ManyToOne com Cliente
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    // Relacionamento ManyToOne com Funcionario
    @ManyToOne
    @JoinColumn(name = "id_funcionario", nullable = false)
    private Funcionario funcionario;

    // Relacionamento ManyToMany com Servico
    @ManyToMany
    @JoinTable(
            name = "agendamento_servico",
            joinColumns = @JoinColumn(name = "id_agendamento"),
            inverseJoinColumns = @JoinColumn(name = "id_servico")
    )
    private List<Servico> servicos;

    public Agendamento(Long id_agendamento, String ISSN, String titulo, String sinopse, Integer ano, Integer qtdPaginas, LocalDateTime dataHora) {
        this.id_agendamento = id_agendamento;
        this.ISSN = ISSN;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.ano = ano;
        this.qtdPaginas = qtdPaginas;
        this.dataHora = dataHora;
    }

    public Agendamento() {
    }

    // Getters e Setters
    public Long getId_agendamento() {
        return id_agendamento;
    }

    public void setId_agendamento(Long id_agendamento) {
        this.id_agendamento = id_agendamento;
    }

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(Integer qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
}
