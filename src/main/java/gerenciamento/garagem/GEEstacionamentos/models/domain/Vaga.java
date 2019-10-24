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
}
