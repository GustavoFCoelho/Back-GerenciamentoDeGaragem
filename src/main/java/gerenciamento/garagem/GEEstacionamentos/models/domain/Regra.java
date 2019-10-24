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
}
