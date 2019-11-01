package gerenciamento.garagem.GEEstacionamentos.models.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Regra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Estacionamento estacionamento;
    private BigDecimal valor;
    private int horas;
    @OneToMany(mappedBy = "regra")
    private List<Vaga> vagas;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Estacionamento getEstacionamento() { return estacionamento; }
    public void setEstacionamento(Estacionamento estacionamento) { this.estacionamento = estacionamento; }
    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }
    public int getHoras() { return horas; }
    public void setHoras(int horas) { this.horas = horas; }
    public List<Vaga> getVagas() { return vagas; }
    public void setVagas(List<Vaga> vagas) { this.vagas = vagas; }
}
