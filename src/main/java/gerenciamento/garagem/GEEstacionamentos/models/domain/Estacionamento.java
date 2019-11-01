package gerenciamento.garagem.GEEstacionamentos.models.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Estacionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "estacionamento")
    private List<Vaga> vagas;
    @OneToOne
    private Endereco endereco;
    @OneToMany(mappedBy = "estacionamento")
    private List<Regra> regras;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public List<Vaga> getVagas() { return vagas; }
    public void setVagas(List<Vaga> vagas) { this.vagas = vagas; }
    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }
    public List<Regra> getRegras() { return regras; }
    public void setRegras(List<Regra> regras) { this.regras = regras; }
}
