package gerenciamento.garagem.GEEstacionamentos.models.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Estacionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @OneToMany(mappedBy = "estacionamento")
    @JsonIgnore
    private List<Vaga> vagas;
    @OneToOne
    private EnderecoEstacionamento endereco;
    @OneToMany(mappedBy = "estacionamento")
    private List<Regra> regras;

    public Estacionamento() {
    }

    public Estacionamento(EnderecoEstacionamento endereco) {
        this.endereco = endereco;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public List<Vaga> getVagas() { return vagas; }
    public void setVagas(List<Vaga> vagas) { this.vagas = vagas; }
    public EnderecoEstacionamento getEndereco() { return endereco; }
    public void setEndereco(EnderecoEstacionamento endereco) { this.endereco = endereco; }
    public List<Regra> getRegras() { return regras; }
    public void setRegras(List<Regra> regras) { this.regras = regras; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
