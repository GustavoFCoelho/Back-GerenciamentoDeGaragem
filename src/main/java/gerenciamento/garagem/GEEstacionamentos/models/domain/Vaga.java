package gerenciamento.garagem.GEEstacionamentos.models.domain;

import javax.persistence.*;

@Entity
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String codigo;
    @OneToOne
    private Carro carro;
    @ManyToOne
    private Estacionamento estacionamento;
    @ManyToOne
    private Regra regra;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public Carro getCarro() { return carro; }
    public void setCarro(Carro carro) { this.carro = carro; }
    public Estacionamento getEstacionamento() { return estacionamento; }
    public void setEstacionamento(Estacionamento estacionamento) { this.estacionamento = estacionamento; }
    public Regra getRegra() { return regra; }
    public void setRegra(Regra regra) { this.regra = regra; }
}
